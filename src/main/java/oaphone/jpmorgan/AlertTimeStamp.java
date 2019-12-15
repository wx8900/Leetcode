package oaphone.jpmorgan;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Jeff Cai
 * @Date 2019/3/28
 * @Version
 */
public class AlertTimeStamp {

    public static final int COMPARE_TO_ZERO = 0;

    public static void main(String[] args) {
        Record t1 = new Record(1, Boolean.TRUE, LocalDateTime.of(2019, 03, 01, 03, 18, 15));
        Record t2 = new Record(3, Boolean.FALSE, LocalDateTime.of(2019, 03, 01, 03, 20, 36));
        Record t3 = new Record(2, Boolean.FALSE, LocalDateTime.of(2019, 03, 01, 03, 21, 58));
        Record t4 = new Record(3, Boolean.FALSE, LocalDateTime.of(2019, 03, 01, 03, 23, 12));
        Record t5 = new Record(1, Boolean.TRUE, LocalDateTime.of(2019, 03, 01, 03, 24, 27));
        Record t6 = new Record(2, Boolean.FALSE, LocalDateTime.of(2019, 03, 01, 03, 25, 31));
        Record t7 = new Record(1, Boolean.FALSE, LocalDateTime.of(2019, 03, 01, 03, 26, 03));
        Record t8 = new Record(2, Boolean.FALSE, LocalDateTime.of(2019, 03, 01, 03, 27, 53));
        Record t9 = new Record(3, Boolean.FALSE, LocalDateTime.of(2019, 03, 01, 03, 31, 18));
        Record t10 = new Record(1, Boolean.FALSE, LocalDateTime.of(2019, 03, 01, 03, 33, 10));
        Record t11 = new Record(1, Boolean.FALSE, LocalDateTime.of(2019, 03, 01, 03, 34, 10));

        long minute = 10;
        int maxAlarmThreshold = 3;
        int initialCapacity = 10;
        int numberOfServer = 1000;

        Map<Integer, List<Record>> map = new HashMap<>(initialCapacity);
        List<Record> timeList = new ArrayList<>();
        timeList.add(t1);
        timeList.add(t5);
        timeList.add(t7);
        timeList.add(t10);
        timeList.add(t11);
        map.put(1, timeList);
        timeList = new ArrayList<>();
        timeList.add(t3);
        timeList.add(t6);
        timeList.add(t8);
        map.put(2, timeList);
        timeList = new ArrayList<>();
        timeList.add(t2);
        timeList.add(t4);
        timeList.add(t9);
        map.put(3, timeList);

        AlertTimeStamp alert = new AlertTimeStamp();
        alert.logStatisticsAndAlert(map, minute, maxAlarmThreshold, numberOfServer);
    }

    /**
     * Add 10 minutes base on the input data time
     *
     * @param ldt
     * @param minutes
     * @return
     */
    public static LocalDateTime addTenMinutes(LocalDateTime ldt, long minutes) {
        return ldt.plusMinutes(minutes);
    }

    /**
     * JP Morgan On-site Interview:
     * 教训：（1）没有把实际的例子写出来，光凭脑子是想不出代码的。
     * （2）要分成几个步骤（字段）来过滤数据，每一步过滤掉一个字段，（不要一口气吃成大胖子）最终得到想要的数据。
     *
     * @param map
     * @param minute
     * @param numberOfFailures
     */
    private void logStatisticsAndAlert(Map<Integer, List<Record>> map, long minute, int maxAlarmThreshold, int numberOfServer) {
        for (Map.Entry<Integer, List<Record>> entry : map.entrySet()) {
            int key = entry.getKey();
            List<Record> value = entry.getValue();

            if (key > 0 && key <= numberOfServer) {
                // put all failure records to a new list
                List<Record> failureRecordList = new ArrayList<>();
                for (Record failureRecord : value) {
                    if (!failureRecord.getResult()) {
                        failureRecordList.add(failureRecord);
                    }
                }

                // compare two failure records. Alert when amount of failure records are more then 3 within 10 minutes
                int index = 0;
                Record recordStart = failureRecordList.get(index);
                Record recordEnd;
                int countOfFailure = 1;
                for (int i = 1, sizeOfFailure = failureRecordList.size(); i < sizeOfFailure; i++) {
                    recordEnd = failureRecordList.get(i);
                    ++countOfFailure;
                    if (addTenMinutes(recordStart.getTimestamp(), minute).compareTo(recordEnd.getTimestamp()) > COMPARE_TO_ZERO) {
                        if (countOfFailure >= maxAlarmThreshold) {
                            System.out.println("Warning: ============> Server ID " + key + " sent alter message!!!");
                        }
                    } else {
                        recordStart = failureRecordList.get(++index);
                    }
                }
            }
        }
    }
}
