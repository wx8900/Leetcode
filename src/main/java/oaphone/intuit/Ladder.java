package oaphone.intuit;

/**
 * "exe" followed by an uncaught exception(java.lang.ArrayIndexOutOfBoundsException: 0)
 *
 * @author Jeff
 * @version V1.0
 * @date 8/8/19 22:17
 */
public class Ladder {

    public static void main(String[] args) {
        try {
            System.out.println(doStuff(args));
        } catch (Exception e) {
            System.out.println("exe");
        }
        doStuff(args);
    }

    static int doStuff(String[] args) {
        return Integer.parseInt(args[0]);
    }

}
