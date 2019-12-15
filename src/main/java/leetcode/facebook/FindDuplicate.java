package leetcode.facebook;

public class FindDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,4,1,1};
        System.out.println(findDuplicate(nums));

    }


    public static int findDuplicate(int[] nums) {
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] == nums[j]) {
                    result = nums[i];
                    break;
                }
            }
        }
        return result;
    }
}
