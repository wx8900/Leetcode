package onsite.threadsafe;

/**
 * 第四种：静态内部类, 这种方法使用内部类来做到延迟加载对象（Initialization on Demand Holder）
 *        这种方式同样利用了ClassLoader的机制来保证初始化instance时只有一个线程
 *        利用私有的内部类（线程安全，内部类也可以换成内部接口，
 *        不过工厂类变量的作用域要改为public了。）
 *
 *        优点：(1) 通过使用静态内部类，巧妙地避免了线程不安全
 *             (2) 节省了前期内存空间，编码非常简洁。
 *             (3) 实现懒加载(lazy loading)的效果。
 *
 * @author Jeff
 * @version V1.0
 * @date 10/6/19 16:52
 */
public final class Singleton5InnerClass {

    private Singleton5InnerClass(){}

    /** 定义静态内部类, 及内部实例成员, 并直接初始化 */
    private static class Holder {
        private static final Singleton5InnerClass INSTANCE = new Singleton5InnerClass();
    }


    public static Singleton5InnerClass getInstance() {
        return Holder.INSTANCE;
    }

}
