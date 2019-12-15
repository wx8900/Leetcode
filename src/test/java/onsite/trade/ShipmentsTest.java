package onsite.trade;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 2019/11/29 10:15
 */

import onsite.trade.Goods;
import onsite.trade.ShipmentManagementImpl;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShipmentsTest {

    ShipmentManagementImpl shipmentImpl;

    /**
     * @BeforeClass:这个注解表示这个方法会在所有测试方法执行之前执行 因为是static修饰的静态方法，所有只会执行一次。通常用来进行一些
     * 资源的加载，如通过JUnit测试Spring相关的东西时，可以在这个方法
     * 中加载Spring的配置文件
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        //System.out.println("this is before class");
    }

    /**
     * @AfterClass:这个注解表示这个方法会在所有方法执行完毕之后执行，通常用来释放资源
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        //System.out.println("this is after class");
    }

    /**
     * @Before:这个注解表示这个方法会在每个测试方法执行之前执行一次 有多少个测试方法就会执行多少次
     */
    @Before
    public void setUp() throws Exception {
        //System.out.println("this is before");
        shipmentImpl = new ShipmentManagementImpl();
    }

    /**
     * @After:这个注解表示这个方法会在每个测试方法执行之后执行一次 有多少个测试方法就会执行多少次
     */
    @After
    public void tearDown() throws Exception {
        //System.out.println("this is Down");
    }

    /*@Test
    public void test1() {
        List list = shipmentImpl.getRandomNumber(100, 3);
        list.forEach(x -> System.out.println(x));
    }*/

    /*@Test
    public void test2() {
        Goods goods = new Goods("root", "beans", 100, null);
        int splitNumber = 3;
        shipmentImpl.split(goods, splitNumber);
        goods.getShipmentList().forEach(x -> System.out.println(x.toString()));
    }*/

    @Test
    public void test3() {
        Goods goods = new Goods("root", "beans", 700, null);
        int splitNumber = 3;
        shipmentImpl.split(goods, splitNumber);
        goods.getShipmentList().forEach(x -> System.out.println(x.toString()));
        System.out.println("==================test3============================");

        List<String> ids = new ArrayList<>(Arrays.asList("2", "3"));
        shipmentImpl.merge(goods, ids);
        System.out.println("Size of goods.getShipmentList() : "+ goods.getShipmentList().size());
        goods.getShipmentList().forEach(x -> System.out.println(x.toString()));
    }

    @Test
    public void test4() {
        System.out.println("=================test4=============================");
        Goods goods = new Goods("root", "beans", 100, null);
        int splitNumber = 3;
        shipmentImpl.split(goods, splitNumber);
        goods.getShipmentList().forEach(x -> System.out.println(x.toString()));
        System.out.println("=================test4=============================");

        shipmentImpl.changeRootQuantity(goods, 50);
        goods.getShipmentList().forEach(x -> System.out.println(x.toString()));
    }

}