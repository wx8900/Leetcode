package oaphone.amazon;

import java.util.*;

/**
 *  09/18/2018 do OA
 Given a string input & a integer K
 find all substrings of input with size K and include K distinct chars
 input only includes lower case letter

 Output: [lkna, nagw, kwag, awun, wuna, agwk, wagl, aglk, glkn, gawu, unag, knag]
         [lkna, nagw, kwag, awun, wuna, agwk, wagl, aglk, glkn, gawu, unag, knag]
         [lkna, nagw, kwag, awun, wuna, agwk, wagl, aglk, glkn, gawu, unag, knag]
                                              wagl

         [lkna, nagw  kwag, awun, wuna, agwk, wagl  aglk, glkn, gawu, unag, knag
         wkwa, gwkw, , agaw, naga]

 */
public class SubstringK {
    public static List<String> substringKDist(String input, int K){
        final int length = input.length();
        int[] array = new int[26];
        int i = 0, j = 0;
        Set<String> res = new HashSet<>();

        while(j < length){
            while(j < length && (j - i < K) && array[input.charAt(j) - 'a'] == 0){
                char c = input.charAt(j);
                //System.out.println("======input.charAt(j)========"+ (input.charAt(j) - 'a'));
                array[c - 'a']++;
                j++;
            }

            if(j - i == K) {
                res.add(input.substring(i, j));
            }
            if(j == length) {
                break;
            }

            char c = input.charAt(j);
            if(array[c - 'a'] == 1){
                while(array[c - 'a'] > 0){
                    char next = input.charAt(i++);
                    array[next - 'a']--;
                }
            }else{
                char next = input.charAt(i++);
                array[next - 'a']--;
            }
        }

        return new ArrayList<>(res);
    }

    public static void main(String[] args){
        SubstringK substringK = new SubstringK();
        System.out.println(substringK.substringKDist("awaglknagaaaaaawunagwkwagl", 4));
    }
}

