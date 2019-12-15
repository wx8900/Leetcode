package oaphone.expedia;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * input:  enjoy every moment of every day
 * index  j:  y     y      t   f      y   y
 * output: yojne yreve moment fo yreve day
 * <p>
 * a, e, i, o, u
 *
 * @author Jeff
 * @version V1.0
 * @date 6/6/19 19:16
 */
public class ExSolution {

    public static void main(String[] args) {
        ExSolution e = new ExSolution();
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        System.out.println("result is : " + e.getReverse("enjoy every moment of every day", set));
    }

    public String getReverse(String input, Set set) {
        StringBuffer res = new StringBuffer();
        if (input == null && input.length() <= 0) {
            return "";
        }
        // Step 1: cut String to word by ' '
        String[] words = input.split(" ");
        // Step2: get the first char of each word
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char ch = word.charAt(0);
            // Step3:  if exists in a, e, i, o, u, will do reverse
            int j = 0, k = word.length() - 1;
            if (set.contains(ch)) {
                res.append(reverse(word.toCharArray(), j, k) + " ");
            } else {
                res.append(word + " ");
            }
        }
        return res.toString();
    }

    /**
     * two pointer, j means the first letter of the word, the k means the last
     *
     * @param word
     * @param j
     * @param k
     * @return
     */
    private String reverse(char[] word, int j, int k) {
        while (j <= k) {
            char tmp = word[j];
            word[j] = word[k];
            word[k] = tmp;
            j++;
            k--;
        }
        return String.valueOf(word);
    }

}
