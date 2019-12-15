package mock;

import java.util.HashMap;
import java.util.Map;

// Rally Health Inc: 输入2个String，如果s1的每一个字符都在s2中出现，而且该字符的出现频率一样，返回True; 否则返回False
public class CompareTwoString {

    public static void main(String args[]){
        CompareTwoString ct = new CompareTwoString();
        System.out.println(ct.getTwoString("aabbb", "bbbaa"));
    }

    public static boolean getTwoString(String s1, String s2){
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        final int n = s1.length();
        for (int i = 0; i < n; i++) {
            char ch1 = s1.charAt(i);
            if (!map1.containsKey(ch1)) {
                map1.put(s1.charAt(i), 1);
            } else {
                map1.put(s1.charAt(i), map1.get(ch1) + 1);
            }
        }

        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch2 = s2.charAt(i);
            if (!map2.containsKey(ch2)) {
                map2.put(s2.charAt(i), 1);
            } else {
                map2.put(s2.charAt(i), map2.get(ch2) + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            char ch = s2.charAt(i);
            if (!map1.containsKey(ch)) {
                return false;
            }
            if (map1.get(ch) != map2.get(ch)) {
                return false;
            }
        }

        return true;
    }
}
