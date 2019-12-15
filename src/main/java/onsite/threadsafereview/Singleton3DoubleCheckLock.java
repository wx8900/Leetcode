package onsite.threadsafereview;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 10/7/19 13:08
 */
public final class Singleton3DoubleCheckLock {

    private Singleton3DoubleCheckLock(){}

    private static Singleton3DoubleCheckLock instance = null;

    public static Singleton3DoubleCheckLock getInstance() {
        if (instance == null) {
            synchronized (Singleton3DoubleCheckLock.class) {
                if (instance == null) {
                    instance = new Singleton3DoubleCheckLock();
                }
            }
        }
        return instance;
    }

}
