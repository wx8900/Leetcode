package onsite.threadsafe;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 2019/11/17 16:12
 */
public class Parent {
    protected static int count = 0;
    public Parent () {count++;}
    static int getCount(){
        return count;
    }


}

 class Child extends Parent{
    public Child () {count++;}
    public static void main(String[] args) {
        System.out.println("Count = "+getCount());
        Child obj = new Child();
        System.out.println("Count = "+getCount());
    }
}
