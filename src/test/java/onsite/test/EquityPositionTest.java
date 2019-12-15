package onsite.test;

/**
 * This is a Junit class for testing EquityPositionImpl
 *
 * @author Wenxian Cai
 * @version V1.0
 * @date 2019/11/29 10:15
 */

import onsite.test.EquityPositionImpl;
import onsite.test.Operation;
import onsite.test.TradeAction;
import onsite.test.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EquityPositionTest {

    private EquityPositionImpl equityPosition;

    private List<List<String>> expected;

    private Transaction transaction1, transaction2, transaction3, transaction4, transaction5, transaction6;

    @Before
    public void setUp() throws Exception {
        equityPosition = new EquityPositionImpl();
        transaction1 = new Transaction(1, 1, 1, "REL", 50, TradeAction.INSERT, Operation.BUY);
        transaction2 = new Transaction(2, 2, 1, "ITC", 40, TradeAction.INSERT, Operation.SELL);
        transaction3 = new Transaction(3, 3, 1, "INF", 70, TradeAction.INSERT, Operation.BUY);
        transaction4 = new Transaction(4, 1, 2, "REL", 60, TradeAction.UPDATE, Operation.BUY);
        transaction5 = new Transaction(5, 2, 2, "ITC", 30, TradeAction.CANCEL, Operation.BUY);
        transaction6 = new Transaction(6, 4, 1, "INF", 20, TradeAction.INSERT, Operation.SELL);

        expected = new ArrayList();
        List<String> list1 = new ArrayList(){{add("REL"); add("+60");}};
        List<String> list2 = new ArrayList(){{add("ITC"); add("0");}};
        List<String> list3 = new ArrayList(){{add("INF"); add("+50");}};
        expected.add(list1);
        expected.add(list2);
        expected.add(list3);
    }

    @After
    public void tearDown() throws Exception {
        equityPosition = null;
        expected = null;
    }

    @Test(timeout=2000)
    public void test1() {
        List<Transaction> transactionList = Arrays.asList(transaction1, transaction2, transaction3, transaction4, transaction5, transaction6);
        List<List<String>> actual = equityPosition.getPosition(transactionList);
        assertEquals(expected, actual);
    }

    @Test(timeout=2000)
    public void test2() {
        List<Transaction> transactionList = Arrays.asList(transaction2, transaction6, transaction1, transaction4, transaction5, transaction3);
        List<List<String>> actual = equityPosition.getPosition(transactionList);
        assertEquals(expected, actual);
    }

    @Test(timeout=2000)
    public void test3() {
        List<Transaction> transactionList = Arrays.asList(transaction3, transaction5, transaction6, transaction2, transaction4, transaction1);
        List<List<String>> actual = equityPosition.getPosition(transactionList);
        assertEquals(expected, actual);
    }

    @Test(timeout=2000)
    public void test4() {
        List<Transaction> transactionList = Arrays.asList(transaction4, transaction3, transaction1, transaction6, transaction2, transaction5);
        List<List<String>> actual = equityPosition.getPosition(transactionList);
        assertEquals(expected, actual);
    }

    @Test(timeout=2000)
    public void test5() {
        List<Transaction> transactionList = Arrays.asList(transaction5, transaction4, transaction3, transaction1, transaction6, transaction2);
        List<List<String>> actual = equityPosition.getPosition(transactionList);
        assertEquals(expected, actual);
    }

    @Test(timeout=2000)
    public void test6() {
        List<Transaction> transactionList = Arrays.asList(transaction6, transaction1, transaction5, transaction3, transaction4, transaction2);
        List<List<String>> actual = equityPosition.getPosition(transactionList);
        assertEquals(expected, actual);
    }

    @Test
    public void test7() {
        List<Transaction> transactionList = Arrays.asList(transaction2, transaction1, transaction5, transaction6, transaction4, transaction3);
        List<List<String>> actual = equityPosition.getPosition(transactionList);
        assertEquals(expected, actual);
    }

    @Test
    public void test8() {
        List<Transaction> transactionList = Arrays.asList(transaction5, transaction6, transaction4, transaction2, transaction3, transaction1);
        List<List<String>> actual = equityPosition.getPosition(transactionList);
        assertEquals(expected, actual);
    }

    @Test
    public void test9() {
        List<Transaction> transactionList = Arrays.asList(transaction4, transaction1, transaction2, transaction6, transaction3, transaction5);
        List<List<String>> actual = equityPosition.getPosition(transactionList);
        assertEquals(expected, actual);
    }

    @Test
    public void test10() {
        List<Transaction> transactionList = Arrays.asList(transaction3, transaction6, transaction1, transaction5, transaction4, transaction2);
        List<List<String>> actual = equityPosition.getPosition(transactionList);
        assertEquals(expected, actual);
    }

    @Test
    public void test11() {
        List<Transaction> transactionList = Arrays.asList(new Transaction(), new Transaction(), new Transaction(),
                new Transaction(), new Transaction(), new Transaction());
        List<List<String>> list = new ArrayList();
        List<String> list1 = new ArrayList();
        List<String> list2 = new ArrayList();
        List<String> list3 = new ArrayList();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        assertEquals(list, equityPosition.getPosition(transactionList));
    }

    @Test(expected=IllegalArgumentException.class)
    public void test12() {
        List<Transaction> transactionList = null;
        equityPosition.getPosition(transactionList);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test13() {
        List<Transaction> transactionList = new ArrayList<>();
        equityPosition.getPosition(transactionList);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test14() {
        List<Transaction> transactionList = Arrays.asList(null, null, null, null, null, null, null, null, null);
        equityPosition.getPosition(transactionList);
    }

    @Test
    public void test15() {
        Transaction transaction = new Transaction(5, 2, 2, "ITC", 30, TradeAction.CANCEL, Operation.BUY);
        List<Transaction> transactionList = Arrays.asList(null, transaction, null, null, null, null, null, null, null);

        expected = new ArrayList();
        List<String> list2 = new ArrayList(){{add("ITC"); add("0");}};
        List<String> list1 = new ArrayList();
        List<String> list3 = new ArrayList();
        expected.add(list1);
        expected.add(list2);
        expected.add(list3);

        assertEquals(expected, equityPosition.getPosition(transactionList));
    }


}