package onsite.threadsafereview;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 10/7/19 12:58
 */
public class ThreadTest {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {

        t1 = new Thread(() -> {
            System.out.println(t1.getName() + " , " + Singleton6Enum.printString());
        });

        t2 = new Thread(() -> {
            System.out.println(t2.getName() + " , " + Singleton6Enum.printString());
        });

        t1.start();
        t2.start();
    }

}
