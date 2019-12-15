package oaphone.ebay;

import java.util.PriorityQueue;

/**
 * @Description
 * @Author Jeff
 * @Date 2019/3/25 20:58
 * @Version V1.0
 */
public class DescendingFrequencyOfCharacterVI {
    public static final int AMOUNT_OF_ASCII = 256;
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();   //获取开始时间
        DescendingFrequencyOfCharacterVI d6 = new DescendingFrequencyOfCharacterVI();
        String input = "aaaazzzzzzzzrrrrrbcccggggggtttkkooooooo";    // z o g r a t/c k b
        System.out.println(" Version 6: Return String is : " + d6.frequencySort(input));
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms"); // 程序运行时间： 62ms  56ms   59ms
    }

    public String frequencySort(String s) {
        int[] counts = new int[AMOUNT_OF_ASCII];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            counts[s.charAt(i)] += 1;
        }

        PriorityQueue<int[]> letters = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < AMOUNT_OF_ASCII; i++) {
            if (counts[i] > 0) {
                letters.offer(new int[]{i, counts[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!letters.isEmpty()) {
            int[] letter = letters.poll();
            for (int i = 0; i < letter[1]; i++) {
                sb.append((char) letter[0]);
            }
        }
        return sb.toString();
    }

}
