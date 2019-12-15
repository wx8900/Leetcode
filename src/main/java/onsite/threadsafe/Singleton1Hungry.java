package onsite.threadsafe;

/**
 * 第一种：饿汉模式（线程安全，这种方式基于Classloader机制）
 *    调用实例化方法时，已经有实例，是饿汉模式
 *    调用实例化方法时，才产生实例，是懒汉模式
 *
 *    优点: 最简单的线程安全单例。
 *    缺点: (1) 因为类加载即初始化实例，加入实例变量比较多的话，会占用较多的内存。
 *         (2) 没有懒加载
 *
 *
 * @author Jeff
 * @version V1.0
 * @date 10/6/19 16:11
 */
public final class Singleton1Hungry {

    private Singleton1Hungry(){
        System.out.println("SingletonStarve init!!!");
    }

    /** 定义静态实例对象的时候直接new初始化(给他吃饱)，调实例化方法时，就直接用(不吃了) */
    private static Singleton1Hungry instance = new Singleton1Hungry();

    /** 实例方法没干事，所以叫饿汉 */
    public static Singleton1Hungry getInstance(){
        return instance;
    }

}
