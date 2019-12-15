package onsite.test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * This class draws a bar chart
 *
 * @author Jack
 * @version V1.0
 * @date 2019/12/4 18:05
 */
public class JUnitPerfTest extends TestCase {

    /*private EquityPositionImpl equityPosition = new EquityPositionImpl();

    private static Transaction transaction1, transaction2, transaction3, transaction4, transaction5, transaction6;

    public JUnitPerfTest(String name) {
        super(name);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        transaction1 = new Transaction(1, 1, 1, "REL", 50, TradeAction.INSERT, Operation.BUY);
        transaction2 = new Transaction(2, 2, 1, "ITC", 40, TradeAction.INSERT, Operation.SELL);
        transaction3 = new Transaction(3, 3, 1, "INF", 70, TradeAction.INSERT, Operation.BUY);
        transaction4 = new Transaction(4, 1, 2, "REL", 60, TradeAction.UPDATE, Operation.BUY);
        transaction5 = new Transaction(5, 2, 2, "ITC", 30, TradeAction.CANCEL, Operation.BUY);
        transaction6 = new Transaction(6, 4, 1, "INF", 20, TradeAction.INSERT, Operation.SELL);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void CompareDateTime() {
        String dateTime1 = "20120111 01:02:03";
        String dateTime2 = "20130111 01:02:03";
        String dateTime3 = "20130111 01:02:03";
        assertEquals(-1, DateUtil.compareDateTime(dateTime1, dateTime2));
        assertEquals(1, DateUtil.compareDateTime(dateTime2, dateTime1));
        assertEquals(0, DateUtil.compareDateTime(dateTime2, dateTime3));
    }

    protected static Test compareDateTimeLoadTestMethod() {
        int users = 5;
        Test factory = new TestMethodFactory(JUnitPerfTest.class,
                "CompareDateTime");
        Test loadTest = new LoadTest(factory, users);
        return loadTest;
    }

    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(compareDateTimeLoadTestMethod());
        return suite;
    }

    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }*/
}
