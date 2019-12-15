package onsite.threadsafe;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 10/7/19 14:33
 */
public class TicketBuyer {

    public static void main(String[] args) {
        // 用户人数
        int userNumber = 10000;
        // 保存用户线程
        Set<Thread> threadSet = new HashSet();

        // 用于存放TicketNumberHandler实例对象
        List<TicketNumberHandler> hanlderList = new Vector();
        // 保存生成的票号
        List<Long> ticketNumberList = new Vector();

        // 定义购票线程，一个线程模拟一个用户
        for(int i=0;i<userNumber;i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    TicketNumberHandler handler = TicketNumberHandler3.getInsatance();
                    hanlderList.add(handler);

                    Long ticketNumber = handler.getTicketNumber();
                    ticketNumberList.add(ticketNumber);
                };
            };
            threadSet.add(t);
        }
        System.out.println("当前购票人数："+threadSet.size()+" 人");

        //记录购票开始时间
        long beginTime = System.currentTimeMillis();
        for(Thread t : threadSet) {
            //开始购票
            t.start();
        }

        //记录购票结束时间
        long entTime;
        while(true) {
            //除去mian线程之外的所有线程结果后在记录结束时间
            if(Thread.activeCount() == 1) {
                entTime = System.currentTimeMillis();
                break;
            }
        }
        //开始统计
        System.out.println("票号生成类实例对象数目："+new HashSet(hanlderList).size());
        System.out.println("共出票："+ticketNumberList.size()+"张");
        System.out.println("实际出票："+new HashSet(ticketNumberList).size()+"张");
        System.out.println("出票用时："+(entTime - beginTime)+" 毫秒");
    }

}
