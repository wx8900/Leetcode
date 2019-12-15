package oaphone.jpmorgan;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jeff
 * @version V2.0
 * @description
 * @date 2019/3/28 19:58
 * @date 2019/3/28 23:50
 */
@SuppressWarnings("ALL")
public class AlertTimeStampII {
    public static final int COMPARE_TO_ZERO = 0;

    public static void main(String[] args) {
        RecordII t1 = new RecordII(1, Boolean.FALSE, Timestamp.valueOf("2019-03-01 03:18:15"));
        RecordII t2 = new RecordII(3, Boolean.FALSE, Timestamp.valueOf("2019-03-01 03:20:36"));
        RecordII t3 = new RecordII(2, Boolean.FALSE, Timestamp.valueOf("2019-03-01 03:21:58"));
        RecordII t4 = new RecordII(3, Boolean.FALSE, Timestamp.valueOf("2019-03-01 03:23:12"));
        RecordII t5 = new RecordII(1, Boolean.FALSE, Timestamp.valueOf("2019-03-01 03:24:27"));
        RecordII t6 = new RecordII(2, Boolean.FALSE, Timestamp.valueOf("2019-03-01 03:25:31"));
        RecordII t7 = new RecordII(1, Boolean.FALSE, Timestamp.valueOf("2019-03-01 03:26:03"));
        RecordII t8 = new RecordII(2, Boolean.FALSE, Timestamp.valueOf("2019-03-01 03:27:53"));
        RecordII t9 = new RecordII(3, Boolean.FALSE, Timestamp.valueOf("2019-03-01 03:31:18"));
        RecordII t10 = new RecordII(1, Boolean.FALSE, Timestamp.valueOf("2019-03-01 03:33:10"));
        RecordII t11 = new RecordII(1, Boolean.FALSE, Timestamp.valueOf("2019-03-01 03:34:10"));

        final int minute = 10;
        final int maxAlarmThreshold = 3;
        final int numberOfServer = 1000;

        // [1 5 7 10 11] [ 3 6 8]  [2 4 9]
        Queue<RecordII> queue = new LinkedList<>();
        queue.add(t1);
        queue.add(t2);
        queue.add(t3);
        queue.add(t4);
        queue.add(t5);
        queue.add(t6);
        queue.add(t7);
        queue.add(t8);
        queue.add(t9);
        queue.add(t10);
        queue.add(t11);

        int[] serverNameArray = new int[numberOfServer];
        RecordII first = queue.element();
        int countOfFailure;

        if (!first.isResult()) {
            serverNameArray[first.getServerName()]++;
        }

        while (!queue.isEmpty()) {
            RecordII q = queue.poll();
            if (!q.isResult()) {
                serverNameArray[q.getServerName()]++;
                if (!q.isResult()) {
                    if (addTenMinutes(first.getTimestamp(), minute)
                            .compareTo(q.getTimestamp()) > COMPARE_TO_ZERO) {
                        countOfFailure = serverNameArray[q.getServerName()];
                        if (countOfFailure >= maxAlarmThreshold) {
                            System.out.println("Warning: Server ID "
                                    + q.getServerName() + " sent alter message!!!");
                            for (int i = 0; i < countOfFailure; i++) {
                                System.out.println(" Freq -- ");
                                serverNameArray[q.getServerName()]--;
                            }
                        }
                    } else {
                        RecordII e = queue.poll();
                        System.out.println(
                                "Remove element : "
                                        + e.toString()
                                        + ", the size of queue is : " + queue.size());
                        first = q;
                    }
                }
            }
        }
    }

    /**
     * Add minutes to TimeStamp by parameter
     *
     * @param timestamp
     * @param minutes
     */
    private static Timestamp addTenMinutes(
            final Timestamp timestamp, final int minutes) {
        Calendar calendar = Calendar.getInstance();
        long time = timestamp.getTime();
        calendar.setTime(new Date(time));
        calendar.add(Calendar.MINUTE, minutes);
        return new Timestamp(calendar.getTimeInMillis());
    }

}
