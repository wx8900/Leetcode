package onsite.threadsafereview;

import java.util.concurrent.locks.ReentrantLock;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 10/7/19 13:14
 */
public final class Singleton4ReentrantLock {

    private Singleton4ReentrantLock(){}

    private static Singleton4ReentrantLock instance = null;

    private static ReentrantLock lock = new ReentrantLock();

    public static Singleton4ReentrantLock getInstance() {
        if (instance == null) {
            try {
                lock.lock();
                if (instance == null) {
                    instance = new Singleton4ReentrantLock();
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

}
