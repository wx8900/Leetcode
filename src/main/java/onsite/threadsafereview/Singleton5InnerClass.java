package onsite.threadsafereview;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 10/7/19 13:31
 */
public final class Singleton5InnerClass {

    private Singleton5InnerClass(){}

    private static class Holder {
        private static final Singleton5InnerClass INSTANCE = new Singleton5InnerClass();
    }

    public static Singleton5InnerClass getInstance() {
       return Holder.INSTANCE;
    }

}
