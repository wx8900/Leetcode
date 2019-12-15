package onsite.threadsafe;
/**
 * 第三种：volatile + 双重校验锁————懒汉模式改良版, 降低锁的细粒度
 *        （线程安全，使用了double-check，即check-加锁-check，目的是为了）
 *
 *        优点：(1) 比synchronized加在方法上的锁粒度细一点
 *             (2) 减少同步的开销
 *             (3) 两次非空判断，并且对第二次判断加锁，确保了多线程下的单例安全，同时保证了性能。
 *        缺点：(1) 双重锁机制之所以不能正常运行. 在new对象的时候，是有三个步骤的：分配内存空间，
               初始化对象，然后将内存地址赋值给变量；在这么三个步骤中，极有可能会在操作上进行重排序，
               在重排序的情况下，还没有初始化对象，先将内存地址赋值给了变量（这种情况是可能存在的），
               当线程B进入时，发现变量不为null，就会直接返回这个实例所以双重锁机制是不提倡使用的。
 *             (2) 在新的内存模型下，实例字段使用volatile可以解决双重锁检查的问题，因为在新的内存模型下，
 *             volatile禁止了一些重排序，但是，同时，使用volatile的性能开销也有所上升。
 *
 * @author Jeff
 * @version V1.0
 * @date 10/6/19 16:42
 */
public final class Singleton3DoubleCheckLock {

    private Singleton3DoubleCheckLock(){}

    /**
     * Double-check有可能因为JVM指令重排的原因，导致空指针异常；
     * 通过volatile, 避免指令重排序导致的空指针异常
     */
    private static volatile Singleton3DoubleCheckLock instance = null;

    /**
     *  check null - 加synchronized锁 - check null
     */
    public static Singleton3DoubleCheckLock getInstance() {
        if (instance == null) {
            synchronized (Singleton3DoubleCheckLock.class) {
                if (instance == null) {
                    // 以下赋值因为不是原子性的，如果不使用volatile使instance在多个线程中可见，将可能导致空指针
                    instance = new Singleton3DoubleCheckLock();
                }
            }
        }
        return instance;
    }

}
