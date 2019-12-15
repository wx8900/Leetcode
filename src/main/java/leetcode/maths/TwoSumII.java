package leetcode.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *   numbers=[2, 7, 11, 15], target=9

     return [0, 1]
 */
public class TwoSumII {

    public static void main(String[] str) {
        TwoSumII twoSumNew = new TwoSumII();
        int[] ints = new int[]{3, 2, 4};
        int[] res = twoSumNew.twoSum(ints, 6);
        for(int i : res) {
            System.out.println(i);
        }
    }

    class Position {
        int val;
        int index;
        public Position(int v, int i) {
            this.val = v;
            this.index = i;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] tmp = new int[2];
        List<Position> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new Position(nums[i], i));
        }
        Arrays.sort(nums);
        int low = 0, high = nums.length - 1;
        while(low < high) {
            if(nums[low] + nums[high] == target) {
                tmp[0] = nums[low];
                tmp[1] = nums[high];
                break;
            } else if(nums[low] + nums[high] > target) {
                high--;
            } else {
                low++;
            }
        }

        int[] result = new int[2];
        for (Position p : list) {
            if (p.val == tmp[0]) {
                result[0] = p.index;
            }
            if (p.val == tmp[1]) {
                result[1] = p.index;
            }
        }
        return result;
    }

}
