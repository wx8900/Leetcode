package leetcode.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jeff
 * @version V2.0
 * @description
 * @date 2019/4/16 19:11
 * @description
 * @date 2019/4/16 19:11
 * @description
 */
public class TwoSumIII {
    public static void main(String[] str) {
        TwoSumIII twoSumNew = new TwoSumIII();
        int[] ints = new int[]{5, 75, 25}; // -1,-2,-3,-4,-5
        //int[] res = twoSumNew.twoSum(ints, 100); // -8
        int[] res = twoSumNew.twoSumII(ints, 100); // -8
        for(int i : res) {
            System.out.println(i);
        }
    }

    public int[] twoSumII(int[] nums, int target) {
        List<Integer> all = new ArrayList<>();
        for (int i : nums) {
            all.add(i);
        }
        Arrays.sort(nums);
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            int id = Arrays.binarySearch(nums, temp);
            if (id >= 0) {
                first = nums[i];
                second = nums[id];
                break;
            }
        }
        int index1 = all.indexOf(first) + 1;
        int index2 = all.lastIndexOf(second) + 1;
        int[] result = new int[2];
        result[0] = (index1 > index2) ? index2 : index1;
        result[1] = (index1 > index2) ? index1 : index2;
        return result;
    }

    public int[] twoSumIII(int[] nums, int target) {
        int[] OriNum=nums.clone();
        Arrays.sort(nums);
        int left=0,right=nums.length-1;
        while(left<right){
            if(nums[left]+nums[right]==target){
                int[] rs=new int[2];
                int pos=0;
                for(int i=0;i<OriNum.length;i++){
                    if(OriNum[i]==nums[left]||OriNum[i]==nums[right])
                        rs[pos++]=i+1;
                }
                return rs;
            }
            if(nums[left]+nums[right]>target)
                right--;
            if(nums[left]+nums[right]<target)
                left++;
        }
        return new int[]{0,0};
    }

    public int[] twoSum(int[] nums, int target) {
        int[] tmp = new int[2];
        int[] newNums = nums.clone();
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
        for (int i = 0; i < newNums.length; i++) {
            if (tmp[0] == tmp[1]) {
                if (newNums[i] == tmp[0]) {
                    result[0] = i;
                    for (int j = i + 1; j < newNums.length; j++) {
                        if (newNums[j] == tmp[1]) {
                            result[1] = j;
                            break;
                        }
                    }
                    break;
                }
            } else {
                if (tmp[0] < 0 && tmp[1] < 0) {
                    if (newNums[i] == tmp[1]) {
                        result[0] = i;
                    }
                    if (newNums[i] == tmp[0]) {
                        result[1] = i;
                        break;
                    }
                } else {
                    for (int k = 0; k < newNums.length; k++) {
                        if (newNums[k] == tmp[0]) {
                            result[0] = k;
                        }
                    }

                    if (newNums[i] == tmp[1]) {
                        result[1] = i;
                    }
                }
            }
        }
        return result;
    }
}
