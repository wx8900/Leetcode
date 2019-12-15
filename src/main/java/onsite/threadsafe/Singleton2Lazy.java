package onsite.threadsafe;

/**
 * 第二种：懒汉模式本身线程不安全。如果getInstance()方法加了synchronized，则线程安全
 *
 *    优点: 单例设计的懒加载，节省了前期内存空间的占用
 *    缺点: 但是在多线程环境下，如果没加synchronized，可能会导致多对象的产生，破坏实例唯一性。
 *                           如果加了synchronized，锁整个方法很消耗资源，带来性能问题
 *
 *         删掉synchronized，会初始化2次，但是实例的ID是不同的：
 *          SingletonLazy init!!!
            SingletonLazy init!!!
            Thread-0 , onsite.threadsafe.SingletonLazy@67d70949
            Thread-1 , onsite.threadsafe.SingletonLazy@2680baa2

           加上synchronized，只会初始化一次，而且实例的ID是相同的，打印如下：
             SingletonLazy init!!!
             Thread-0 , onsite.threadsafe.SingletonLazy@6328e82
             Thread-1 , onsite.threadsafe.SingletonLazy@6328e82
 *
 * @author Jeff
 * @version V1.0
 * @date 10/6/19 16:27
 */
public final class Singleton2Lazy {

    private Singleton2Lazy(){System.out.println("SingletonLazy init!!!");}
    /** 定义静态变量时给null */
    private static Singleton2Lazy instance = null;

    /**
     * 调实例化方法时，再去new实例===>用的时候才去实例化
     * 懒汉模式名字的由来        ===>要用的时候才去做
     */
    public static synchronized Singleton2Lazy getInstance() {
        if (instance == null) {
            instance = new Singleton2Lazy();
        }
        return instance;
    }

}
