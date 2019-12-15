package oaphone.ebay;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * input= abbbbccc
 * output= bbbbccca
 *
 * @author Jeff Cai
 * @date 03/04/2019
 */
public class DescendingFrequencyOfCharacterII {

    public static void main(String[] args) {
        String input = "aaaazzzzzzzzrrrrrbcccggggggtttkkooooooo";    // z o g r a t/c k b

        //LocalDateTime startTime = LocalDateTime.now();
        // do something
        //LocalDateTime endTime = LocalDateTime.now();
        //java.time.Duration duration = java.time.Duration.between(startTime, endTime);
        //System.out.println("程序运行时间： " + (duration.toMillis()) + " ms "); // 程序运行时间： 70ms  118   61

        Instant start = Instant.now();
        DescendingFrequencyOfCharacterII dfc2 = new DescendingFrequencyOfCharacterII();
        System.out.println(" Version 2: Return String is : " + dfc2.getMostAppearance(input));
        Instant end = Instant.now();
        long timeDiff = Duration.between(start, end).toMillis();
        System.out.println("Difference in milliseconds : " + timeDiff + " ms");
    }

    public String getMostAppearance(String in) {
        char[] out = new char[in.length()];
        // create mapping between char and frequency
        Map<Character, Integer> outputMap = new HashMap<>();
        for (char ch : in.toCharArray()) {
            if (outputMap.containsKey(ch)) {
                outputMap.put(ch, outputMap.get(ch) + 1);
            } else {
                outputMap.put(ch, 1);
            }
        }

        // sort elements of map
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(outputMap.entrySet());
        /*Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });*/

        list.sort((Map.Entry<Character, Integer> s1,
                   Map.Entry<Character, Integer> s2) -> s2.getValue() - s1.getValue());


        // output the sorted list to the result array
        int index = 0;
        for (Map.Entry<Character, Integer> sortedEntry : list) {
            int freq = sortedEntry.getValue();
            while (freq > 0) {
                out[index] = sortedEntry.getKey();
                index++;
                freq--;
            }
        }

        return String.valueOf(out);
    }
}
