package oaphone.ebay;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @Description   LeetCode 451. Sort Characters By Frequency
 * @Author Jeff
 * @Date 2019/3/25 20:23
 * @Version V1.0
 */
public class DescendingFrequencyOfCharacterV {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();   //获取开始时间
        DescendingFrequencyOfCharacterV d5 = new DescendingFrequencyOfCharacterV();
        String input = "aaaazzzzzzzzrrrrrbcccggggggtttkkooooooo";    // z o g r a t/c k b
        System.out.println(" Version 5: Return String is : "+d5.frequencySort(input));
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime - startTime)+"ms"); // 程序运行时间： 66ms  58ms  61ms
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue() );
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry entry = pq.poll();
            for (int i = 0; i < (int)entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
