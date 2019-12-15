package oaphone.jpmorgan;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Before constructing Number are : 1 2
 * After constructing Number are : 1 5
 *
 * @Description Wrong way to write a constructor
 * @Author Jeff
 * @Date 2019/3/27 13:05
 * @Version V1.0
 * <p>
 * <p>
 * <p>
 * Before constructing Number are : 1 2
 * After constructing Number are : 1 2
 * @Description Right way to write an immutable class
 * @Date 2019/3/27 13:11
 * @Version V2.0
 * <p>
 * Java中很多class都是immutable，像String，Integer等，它们通常用来作为Map的key.
 * Good news! Primitives are immutable, so you don't have to do anything special.
 * 原始类型包装类（primitive wrappers）（Integer，Long, Short, Double, Float, Character, Byte, Boolean）也都是不可变的
 * <p>
 * 那么在实现自定义的Immutable的Class的时候，应该注意哪些要点呢？
 * <p>
 * a)Class 应该定义成final，避免被继承。
 * <p>
 * b)所有的成员变量应该被定义成final。
 * <p>
 * c)不要提供可以改变类状态(成员变量)的方法。【get 方法不要把类里的成员变量让外部客户端引用,当需要访问成员变量时，返回成员变量的copy】
 * <p>
 * d)构造函数不要引用外部可变对象。如果需要引用可以在外部改变值的变量，应该在构造函数里进行defensive copy。
 */
public final class MyImmutable {
    private int[] myArray = null;

    /**
     * Right way to write a constructor, defensive copy
     */
    public MyImmutable(int[] anArray){
        // this.myArray = anArray; Wrong way to write a constructor
        this.myArray = anArray.clone();
    }

    private List<String> list = null;

    public MyImmutable(List<String> list) {

        this.list = Collections.unmodifiableList(list);
    }

    public static void main(String[] args) {
        int[] array = {1, 2};

        List<String> list = Arrays.asList("Hello", "world");
        MyImmutable myImmutableRef = new MyImmutable(list);
        List<String> li = myImmutableRef.getList();
        // Exception in thread "main" java.lang.UnsupportedOperationException
        li.add("test add");
        for (String str : li) {
            System.out.println("=========>" + str);
        }
    }

    public List<String> getList() {
        return list;
    }

    /**
     * java.util.Collections provides a number of convenience methods that
     * make converting a Collection to an UnmodifiableCollection a snap
     */
    public void print() {
        /*Collections.unmodifiableCollection
        Collections.unmodifiableList
        Collections.unmodifiableMap
        Collections.unmodifiableNavigableMap
        Collections.unmodifiableNavigableSet
        Collections.unmodifiableSet
        Collections.unmodifiableSortedMap
        Collections.unmodifiableSortedSet*/
    }
}
