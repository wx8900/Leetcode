package onsite.threadsafe;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 10/7/19 14:44
 */
public class TicketNumberHandler3 extends TicketNumberHandler {
    //保存单例实例对象
    private static TicketNumberHandler3 INSTANCE;
    //私有化构造方法
    private TicketNumberHandler3() {};

    /**
     * 懒汉式，在第一次获取单例对象的时候初始化对象
     * @return
     */
    public static TicketNumberHandler3 getInsatance() {
        if(INSTANCE == null) {
            try {
                //这里为什么要让当前线程睡眠1毫秒呢？
                //因为在正常的业务逻辑中，单利模式的类不可能这么简单，所以实例化时间会多一些
                //让当前线程睡眠1毫秒
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            INSTANCE = new TicketNumberHandler3();
        }
        return INSTANCE;
    }

}
