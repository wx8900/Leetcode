package onsite.threadsafe;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 10/6/19 19:24
 */
public class ThreadSafeTest {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {

        t1 = new Thread(() -> {
            //System.out.println(t1.getName() +" , "+ Singleton1Hungry.getInstance());
            //System.out.println(t1.getName() +" , "+ Singleton2Lazy.getInstance());
            //System.out.println(t1.getName() +" , "+ Singleton3DoubleCheck.getInstance());
            //System.out.println(t1.getName() +" , "+ Singleton4ReentrantLock.getInstance());
            //System.out.println(t1.getName() +" , "+ Singleton5InnerClass.getInstance());
            System.out.println(t1.getName() +" , "+ Singleton6Enum.printInstance());
        });

        t2 = new Thread(() -> {
            //System.out.println(t2.getName() +" , "+ Singleton1Hungry.getInstance());
            //System.out.println(t2.getName() +" , "+ Singleton2Lazy.getInstance());
            //System.out.println(t2.getName() +" , "+ Singleton3DoubleCheck.getInstance());
            //System.out.println(t2.getName() +" , "+ Singleton4ReentrantLock.getInstance());
            //System.out.println(t2.getName() +" , "+ Singleton5InnerClass.getInstance());
            System.out.println(t2.getName() +" , "+ Singleton6Enum.printInstance());
        });

        t1.start();
        t2.start();

    }





}
