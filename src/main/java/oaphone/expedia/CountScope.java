package oaphone.expedia;

import java.util.HashMap;
import java.util.Map;

/**
 *  Q2: Given the scores of candidates -  in an integer array
 *  And given a range of min and max score, return the number of score between that range.
 *  Ex: scores: 1,3,4,2,5,3,2,4; No. of score between 3 and 4 is 4
 *                [3, 4]   [3,4] -> number of between 3 and 4
 *                2, 4 -> 6  [3,4,2,3,2,4]
 *  Ex2: 6,2,3,6,4,8,9,4,5,2,4,1,0,1,0,10,4,5,3,2,4
 *  ,2,3,,2,,1,,1,,,,,3,2,
 *  How many scores are there between 1 and 3 => 7
 *
 * @author Jeff
 * @version V1.0
 * @date 5/6/19 15:56
 */
public class CountScope {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,2,5,3,2,4};
        int min = 2, max = 4;
        System.out.println(countInScope(arr, min, max));
    }

    private static int countInScope(int[] arr, int min, int max) {
        if(arr == null || arr.length == 0 || min < 0 || max > Integer.MAX_VALUE) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>(16);
        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int count = 0;
        for(int i = min; i <= max; i++) {
            count += map.get(i);
        }
        return count;
    }
}
