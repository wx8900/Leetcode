package leetcode.facebook;

public class MoveZero {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        int[] result = moveZeroes(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public static int[] moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int len = nums.length;
        /*for (int i = 0; i < len; i++) {
            int temp = -1;
            if (nums[i] == 0 && i + 1 < len) {
                temp = nums[i + 1];
                nums[i + 1] = nums[i];
                nums[i] = temp;
            }
        }*/
        for (int i = len - 1; i > 0; i--) {
            int temp = -1;
            if (nums[i] != 0 && i + 1 < len) {
                temp = nums[i + 1];
                nums[i + 1] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }
}

