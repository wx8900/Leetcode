package onsite.google;

import java.util.HashMap;
import java.util.Map;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 8/13/19 12:54
 */
public class FindDuplicateChar {
    public boolean FindDuplicate(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                return true;
            } else {
                map.put(c, i);
            }
        }
        return false;
    }

    public static String TestFindDuplicate(String s) {
        FindDuplicateChar fd = new FindDuplicateChar();
        if (fd.FindDuplicate(s) == true) {
            return "Pass 1";
        } else if (fd.FindDuplicate(s) == false) {
            return "Pass 2";
        } else {
            return "Fail";
        }
    }

    public static void main(String[] args) {
        System.out.println(TestFindDuplicate(""));
    }
}
