package onsite.threadsafereview;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 10/7/19 13:03
 */
public final class Singleton2Lazy {

    private Singleton2Lazy(){}

    private static Singleton2Lazy instance = null;

    public static synchronized Singleton2Lazy getInstance() {
        if (instance == null) {
            instance = new Singleton2Lazy();
        }
        return instance;
    }


}
