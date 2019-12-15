package leetcode.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsCopy {

    public static void main(String[] args) {
        List<String> l = new ArrayList<String>();
        l.add("a");
        l.add("b");
        l.add("c");
        /*
        List<String> l2 = new ArrayList<String>();
        Collections.copy(l2, l); //会报错：java.lang.IndexOutOfBoundsException: Source does not fit in dest
        原因是你使用该方法时，会先比较目标集合和源集合的size，而你直接new ArrayList<String>();还没来得及复制，目标集合的size为0，
        和源集合的size不一样，就会报错。注：new ArrayList(int size)定义的是该集合的的容纳能力为size，并不是说目标集合中就有了size个元素。
        所以要这样写：new ArrayList<Object>(Arrays.asList(new Object[l.size()]));
        */
        List<Object> l2 = new ArrayList<Object>(Arrays.asList(new Object[l.size()]));
        Collections.copy(l2, l);
        l2.add("d");
        System.out.println(l2);
        System.out.println(l);

        System.out.println("===============================");
        List<String> l3 = new ArrayList<String>();
        l3.add("a");
        l3.add("b");
        l3.add("c");
        List<String> l4 = l3; //只是定义了另一个引用，但是指向的内容还是源集合指向的内容。所以对其修改当然会影响源集合了
        l4.add("d");
        System.out.println(l4);
        System.out.println(l3);
    }
}
