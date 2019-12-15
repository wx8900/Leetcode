package oaphone.intuit;

import java.util.*;

/**
 * 应该选 null scurvy
 *
 * @author Jeff
 * @version V1.0
 * @date 8/8/19 22:24
 */
public class PirateTalk {

    public static void main(String... arrrrrgs) {
        Properties p = new Properties();
        p.setProperty("pirate" , "scurvy");
        String s = p.getProperty("argProp") + " ";
        s += p.getProperty("pirate");
        System.out.println(s);
    }

}
