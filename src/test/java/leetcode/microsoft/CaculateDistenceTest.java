package leetcode.microsoft;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 2019/11/29 10:15
 */

import onsite.standardcharteredbank.CaculateDistence;
import org.junit.*;

public class CaculateDistenceTest {

    /**
     * @BeforeClass:这个注解表示这个方法会在所有测试方法执行之前执行
     * 因为是static修饰的静态方法，所有只会执行一次。通常用来进行一些
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
     * @Before:这个注解表示这个方法会在每个测试方法执行之前执行一次
     * 有多少个测试方法就会执行多少次
     */
    @Before
    public void setUp() throws Exception {
        //System.out.println("this is before");
    }

    /**
     * @After:这个注解表示这个方法会在每个测试方法执行之后执行一次
     * 有多少个测试方法就会执行多少次
     */
    @After
    public void tearDown() throws Exception {
        //System.out.println("this is Down");
    }

    @Test
    public void test1() {
        //System.out.println("this is test1");
    }

    @Test
    public void test2() {
        //System.out.println("this is test2");
    }

    @Test
    public void test3() {
        System.out.println("this is test3 : " + CaculateDistence.caculateHalfWord("JavaVirtualMachines", true));
    }

    @Test
    public void test4() {
        System.out.println("this is test4 : " + CaculateDistence.caculateHalfWord("JavaVirtualMachines", false));
    }

    @Test
    public void test5() {
        System.out.println("this is test5 : " + CaculateDistence.caculateHalfWord("Down", true));
    }

    @Test
    public void test6() {
        System.out.println("this is test6 : " + CaculateDistence.caculateHalfWord("Down", true));
    }



}
