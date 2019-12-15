package onsite.threadsafereview;

/**
 * Singleton Enum
 *
 * @author Jeff
 * @version V1.0
 * @date 10/7/19 13:26
 */
public enum Singleton6Enum {
    /**
     * instance
     */
    INSTANCE;

    public static String printString() {
        return INSTANCE.name() + " , " + INSTANCE.hashCode();
    }
}
