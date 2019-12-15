package oaphone.intuit;

/**
 * When does the "Demo" object instantiated at line 6 become eligible for garbage collection?
 * 在第6行实例化的“Demo”对象, 何时有资格进行垃圾回收
 * 选“After line 7"
 *
 *
 * 判断一个数是否是2的次幂
 * （（n & （n-1））== 0）的含义是n满足2的n次方
 * n > 0 && ((n & (n - 1)) == 0，则高位必须全为0，这样就没有相同的1。
 *
 *
 * @author Jeff
 * @version V1.0
 * @date 8/8/19 22:32
 */
public class Test {

    private Demo d;
    void start() {
        d = new Demo();    /* Line 6  */
        this.takeDemo(d);  /* Line 7  */
    }  /* Line 8  */

    void takeDemo(Demo demo) {
        demo = null;
        demo = new Demo();
    }
}
