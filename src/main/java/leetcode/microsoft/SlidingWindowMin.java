package leetcode.microsoft;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 // Given Array and Set, find the minimum size of the window in Array which contains all elements from the Set
         [1, 2, 3], {1, 2} -> 2 ([1, 2])
         [2, 2, 1, 3], {1, 2} -> 2 ([2, 1])
         [2, 2, 4, 1, 3], {1, 2} -> 3 ([2, 4, 1])
 [add, delete and add,add, add and compare length, ignore]
 //        1) for loop the array, if nums[i] in Set, add Queue
 //        2) temp int[] -> store Set elements
 //        3) if nums[i] not in Set, continue add Queue until nums[i] find all elements of Set, record size of window
 */
public class SlidingWindowMin {
    public static void main(String[] args) {
        SlidingWindowMin sw = new SlidingWindowMin();
        int[] input = new int[]{2, 2, 1, 3};
        Set set = new HashSet(){{add(1); add(2);}};
        System.out.print(sw.findMinWindow(input, set));
    }

    public int findMinWindow(int[] nums, Set set) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // use two pointer
        int i = 0,j = 0;
        int min = Integer.MAX_VALUE;
        // Map<value of element, number of appear of element>
        Map<Integer, Integer> map = new HashMap<>();
        for (; i < nums.length; i++) {
            int num = nums[i];
            if (set.contains(num)) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }

                while (map.size() == set.size()) {
                    if (map.containsKey(num)) {
                        if (map.get(num) == 0) {
                            map.remove(num);
                        } else {
                            map.put(num, map.get(num) - 1);
                        }
                    }
                    j++;
                }
                min = Math.min(min, (j - i + 1));
            }
        }
        return min;
    }
}