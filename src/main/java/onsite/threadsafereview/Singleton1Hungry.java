package onsite.threadsafereview;

/**
 * 饿汉式单利————线程安全
 *
 * @author Jeff
 * @version V1.0
 * @date 10/7/19 12:57
 */
public final class Singleton1Hungry {

    private Singleton1Hungry() {}

    private static Singleton1Hungry instance = new Singleton1Hungry();

    public static Singleton1Hungry getInstance() {
        return instance;
    }

}
