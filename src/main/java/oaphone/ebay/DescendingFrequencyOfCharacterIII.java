package oaphone.ebay;

import java.util.Arrays;

/**
 * @author  Jeff Cai
 * @date    03/10/2019
 */
public class DescendingFrequencyOfCharacterIII {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();   //获取开始时间
        DescendingFrequencyOfCharacterIII dfc3 = new DescendingFrequencyOfCharacterIII();
        String input = "aaaazzzzzzzzrrrrrbcccggggggtttkkooooooo";    // z o g r a t/c k b
        System.out.println(" Version 3: Return String is : "+dfc3.getMostAppearance(input));
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime - startTime)+"ms"); // 程序运行时间： 0ms  1ms  1ms
    }

    public String getMostAppearance(String in) {
        char[] out = new char[in.length()];
        int[] freqSortedIndex = new int[26]; // Assumption: all input are 26 English letters and all letter are low case
        for (char ch : in.toCharArray()) {   // create mapping between char and frequency
            freqSortedIndex[ch - 'a']++;
        }

        // Arrays.sort() create new index for each value, so copy array to save the original index of each char mapping
        int[] freqOriginalIndex = freqSortedIndex.clone();
        Arrays.sort(freqSortedIndex);

        // output the sorted list to the result array
        int indexOfOutput = 0;
        int[] usedChar = new int[26];
        for (int i = freqSortedIndex.length - 1; i >= 0; i--) {
            int freq = freqSortedIndex[i];
            if (freq == 0) {
                continue;
            }
            int indexOfInput = 0;
            for (int j = 0; j < freqOriginalIndex.length; j++) {
                if (freqOriginalIndex[j] > 0 && freqOriginalIndex[j] == freq && usedChar[j] == 0) {
                    indexOfInput = j;
                    usedChar[j]++;
                    break;
                }
            }
            while (freq > 0) {
                out[indexOfOutput] = (char)(indexOfInput + 'a');
                indexOfOutput++;
                freq--;
            }
        }
        return String.valueOf(out);
    }
}