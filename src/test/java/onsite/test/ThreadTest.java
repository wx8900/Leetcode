package onsite.test;

import onsite.test.EquityPositionImpl;
import onsite.test.Operation;
import onsite.test.TradeAction;
import onsite.test.Transaction;

import java.util.Arrays;
import java.util.List;

/**
 * This class draws a bar chart
 *
 * @author Jack
 * @version V1.0
 * @date 2019/12/4 17:58
 */
public class ThreadTest extends Thread {

    private EquityPositionImpl equityPosition = new EquityPositionImpl();

    private static Transaction transaction1, transaction2, transaction3, transaction4, transaction5, transaction6;

    static {
        transaction1 = new Transaction(1, 1, 1, "REL", 50, TradeAction.INSERT, Operation.BUY);
        transaction2 = new Transaction(2, 2, 1, "ITC", 40, TradeAction.INSERT, Operation.SELL);
        transaction3 = new Transaction(3, 3, 1, "INF", 70, TradeAction.INSERT, Operation.BUY);
        transaction4 = new Transaction(4, 1, 2, "REL", 60, TradeAction.UPDATE, Operation.BUY);
        transaction5 = new Transaction(5, 2, 2, "ITC", 30, TradeAction.CANCEL, Operation.BUY);
        transaction6 = new Transaction(6, 4, 1, "INF", 20, TradeAction.INSERT, Operation.SELL);
    }

    @Override
    public void run() {
        List<Transaction> transactionList = Arrays.asList(transaction1, transaction2, transaction3, transaction4, transaction5, transaction6);
        List<List<String>> actual = equityPosition.getPosition(transactionList);
        System.out.println("actual = " + actual);
    }

    public static void main(String a[]) {
        Thread t = new ThreadTest();
        t.start();
        Thread t2 = new ThreadTest();
        t2.start();
        Thread t3 = new ThreadTest();
        t3.start();
    }
}
