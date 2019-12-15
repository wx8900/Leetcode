package onsite.threadsafe;

/**
 * 枚举类
 * 《Effective Java》中推荐的单例设计模式，缺点是饿汉式，并且对编码能力要求较高。
 *
 *   优点：单元素的枚举类型已经成为实现Singleton的最佳方法。枚举可解决反序列化会破坏单例的问题
 *   缺点：使用枚举实现单例的方法虽然还没有广泛采用
 *
 * @author Jeff
 * @version V1.0
 * @date 10/6/19 17:25
 *
 * 枚举本身是final的, 不允许被继承
 */
public enum Singleton6Enum {
    INSTANCE;

    /*SingletonEnum(){}*/

    /**
     * 调用该方法会主动使用SingletonEnum, INSTANCE将会实例化
     */
    public static String printInstance() {
        return INSTANCE.name() +" , HashCode is : " + INSTANCE.hashCode();
    }

}
