package onsite.threadsafe;

import java.util.concurrent.locks.ReentrantLock;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 10/6/19 18:05
 */
public class Singleton4ReentrantLock {

    private Singleton4ReentrantLock(){}

    private static Singleton4ReentrantLock instance;

    private static ReentrantLock lock = new ReentrantLock();

    public static Singleton4ReentrantLock getInstance() {
        if (instance == null) {
            try {
                lock.lock();
                if (instance == null) {
                    instance = new Singleton4ReentrantLock();
                }
            } finally {  // 保证了即使在代码抛出异常的情况下，也会释放锁
                lock.unlock();
            }
        }

        return instance;
    }

}
