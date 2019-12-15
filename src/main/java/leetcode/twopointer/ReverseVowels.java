package leetcode.twopointer;

import java.util.*;

public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println("=======Result======"+reverseVowels("hello"));
        //System.out.println("=======Result======"+reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int low = 0, high = s.length() - 1;
        boolean left = false, right = false;
        char[] result = s.toCharArray();
        while (low < high) {
            char lowC = s.charAt(low);
            char highC = s.charAt(high);
            if (!set.contains(lowC)) {
                low++;
            }
            else {
                left = true;
            }
            if (!set.contains(highC)) {
                high--;
            }
            else {
                right = true;
            }
            if (left && right) {
                char temp = result[low];
                result[low] = result[high];
                result[high] = temp;
                left = false;
                right = false;
                low++;
                high--;
            }
        }
        return String.valueOf(result);
    }

}
