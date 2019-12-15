package leetcode.collection;

import leetcode.google.Person;

import java.util.ArrayList;
import java.util.List;

public class AddAllQuestion {

    public static void main(String[] args) {

        List<Person> list1 = new ArrayList<>();
        List<Person> list2 = new ArrayList<>();
        Person p1 = new Person("Zhang San");
        list2.add(p1);
        list1.addAll(list2);
        list1.stream().forEach(obj -> System.out.println(obj.getName()));

        System.out.println("===============================");
        System.out.println("修改Person1里面的姓名,叫Li Si");
        p1.setName("Li Si");
        System.out.println("看看List1里面的Person1会不会改变 : ");
        list1.stream().forEach(obj -> System.out.println(obj.getName()));

        System.out.println("===============================");
        System.out.println("修改List1里面的第一个人姓名,叫Wang Wu");
        list1.get(0).setName("Wang Wu");
        System.out.println("看看Person1里面的姓名会不会改变 : " + p1.getName());
        list1.stream().forEach(obj -> System.out.println(obj.getName()));

        System.out.println("===============================");
        Person p2 = new Person("Robots");
        list2.add(p2);
        System.out.println("在list2里的增加一个人, 查看list2里面的人的姓名 : ");
        list2.stream().forEach(obj2 -> System.out.println(obj2.getName()));
        System.out.print("看看list1里面的人的姓名 : ");
        list1.stream().forEach(obj -> System.out.println(obj.getName()));

        System.out.println("===============================");
        //list2.remove(0);
        list2.clear();
        System.out.println("删除所有list2里的人, 查看list2里面的人的姓名 : ");
        list2.stream().forEach(obj2 -> System.out.println(obj2.getName()));
        System.out.print("看看list1里面的人的姓名 : ");
        list1.stream().forEach(obj -> System.out.println(obj.getName()));

        System.out.println("===============new 1================");
        List<Person> l = new ArrayList<>();
        l.add(p1);
        l.add(p2);
        l.add(new Person("c"));
        List<Person> l2 = new ArrayList<>(l);
        l2.add(new Person("d"));
        p1.setName("new 1 Test");
        l2.get(0).setName("l2 modify name");
        l2.stream().forEach(obj2 -> System.out.println(obj2.getName()));
        System.out.println("======l======");
        l.stream().forEach(obj -> System.out.println(obj.getName()));

        System.out.println("================new 2===============");
        List<Person> list3 = new ArrayList<>();
        list3.add(p1);
        list3.add(p2);
        list3.add(new Person("c"));
        List<Person> list4 = new ArrayList<>();
        list4.addAll(list3);
        list4.add(new Person("d"));
        p1.setName("new 2 Test");
        list4.get(0).setName("list4 modify name");
        list4.stream().forEach(obj2 -> System.out.println(obj2.getName()));
        System.out.println("======l======");
        list3.stream().forEach(obj -> System.out.println(obj.getName()));

        System.out.println("==========$$$$$$$$$$$$$$$$$$==========");
        System.out.println(">>>>>>>>>>>> Java定海神针 -- Java里面凡是传对象, 赋值对象, 都是传引用 <<<<<<<<<<<");
        System.out.println("==========$$$$$$$$$$$$$$$$$$==========");
        System.out.println(
                "\n" + "结论: list1.addAll(list2)和list.add(Element e)方法都是浅拷贝, 是传递引用, " + "\n" +
                "对list1做元素级别的操作(修改某个元素对象的值), 会更新到list2的里面, 反之亦然, 是双向更新. " + "\n" +
                "但是, 对list2做List级别的操作(增加, 删除, 排序元素), 不会更新到list1里 " + "\n" +
                "在list1的构造函数里面直接传入list2, 和 list1.addAll(list2) 的效果一样, 因为Java里面传对象都是传引用, 哈哈哈哈" + "\n" +
                "想要不会更新到另外一个list里, 就要自己实现Cloneable接口,并实现clone()方法");

        /**
         *   ArrayList的addAll的实现为:
         *   在拷贝数组时使用了 arraycopy 这个方法。这个方法是使用拷贝内存的做法 ，效率比遍历数组块很多。首先找到数据源 然后将该段内存拷贝
         *   arraycopy的定义是这样的
         *   public static native void arraycopy(Object src,  int  srcPos, Object dest, int destPos,int length);
         *   native关键字的意思是 这个函数的源码在JDK中没有的。但是他调用的是本地计算机中的函数
         *   这个函数是C，或者C++写完的，编译成DLL。 java调用。所以效率比for循环要块

        public   boolean   addAll(Collection   c)   {
            Object[]   a   =   c.toArray();
            int   numNew   =   a.length;
            ensureCapacity(size   +   numNew);      //   Increments   modCount
            System.arraycopy(a,   0,   elementData,   size,   numNew);
            size   +=   numNew;
            return   numNew   !=   0;
        }


         *
         * 为什么在大数据量时使用addall方法效率快？
         * 1.使用内存拷贝，移动数据。
         * 2.本地函数，执行效率高。
         */

        // 从指定的位置开始，将指定collection中的所有元素插入到此列表中。
        /*public boolean addAll(int index, Collection<? extends E> c) {
            if (index > size || index < 0)
                throw new IndexOutOfBoundsException(
                        "Index: " + index + ", Size: " + size);

            Object[] a = c.toArray();
            int numNew = a.length;
            ensureCapacity(size + numNew);  // Increments modCount

            int numMoved = size - index;
            if (numMoved > 0)
                System.arraycopy(elementData, index, elementData, index + numNew, numMoved);

            System.arraycopy(a, 0, elementData, index, numNew);
            size += numNew;
            return numNew != 0;
        }
        */

    }
}
