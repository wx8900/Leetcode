package oaphone.ebay;

import java.util.*;

/**
 * @author  Jeff Cai
 * @date    03/17/2019
 */
public class DescendingFrequencyOfCharacterIV {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();   //获取开始时间
        DescendingFrequencyOfCharacterIV dfc4 = new DescendingFrequencyOfCharacterIV();
        String input = "aaaazzzzzzzzrrrrrbcccggggggtttkkooooooo";    // z o g r a t/c k b
        System.out.println(" Version 4: Return String is : "+dfc4.getMostAppearance(input));
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime - startTime)+"ms"); //  程序运行时间： 97ms  57ms  63ms
    }

    public String getMostAppearance(String in) {
        char[] out = new char[in.length()];
        int[] freqSortedIndex = new int[26];// Assumption: all input are 26 English letters and all letter are low case
        for (char ch : in.toCharArray()) { // create mapping between char and frequency
            freqSortedIndex[ch - 'a']++;
        }

        Map<Integer, Integer> outputMap = new HashMap<>();
        for (int i = 0; i < freqSortedIndex.length; i++) {
            if (freqSortedIndex[i] > 0) {
                outputMap.put(i, freqSortedIndex[i]);
            }
        }
        // sort
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(outputMap.entrySet());
        list.sort((Map.Entry<Integer, Integer> s1,
                   Map.Entry<Integer, Integer> s2) -> s2.getValue() - s1.getValue());

        // output the sorted list to the result array
        int index = 0;
        for (Map.Entry<Integer, Integer> sortedEntry : list) {
            int freq = sortedEntry.getValue();
            while (freq > 0) {
                out[index] = (char)(sortedEntry.getKey() + 'a');
                index++;
                freq--;
            }
        }
        return String.valueOf(out);
    }
}