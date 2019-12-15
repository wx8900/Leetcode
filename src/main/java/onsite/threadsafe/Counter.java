package onsite.threadsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 10/7/19 15:04
 */
public class Counter {

    private final AtomicInteger count= new AtomicInteger();

    public int addOne() {
        return count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }

}
