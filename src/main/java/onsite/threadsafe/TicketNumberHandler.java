package onsite.threadsafe;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 10/7/19 14:32
 */
public class TicketNumberHandler {

    //记录下一个唯一的号码
    private long nextUniqueNumber = 1;
    /**
     * 返回生成的号码
     * @return
     */
    public Long getTicketNumber() {
        return nextUniqueNumber++;
    }

    /*INSTANCE;

    //记录下一个唯一的号码
    private AtomicLong nextUniqueNumber = new AtomicLong();

    *//**
     * 返回生成的号码
     * @return
     *//*
    public synchronized Long getTicketNumber() {
        return nextUniqueNumber.incrementAndGet();
    }*/

}
