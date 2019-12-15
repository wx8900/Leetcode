package leetcode.maths;

public class TwoSum {
	
	public static int[] twoSum(int[] nums, int target) {
        int a[] = {0, 0};
        int length = nums.length;
        for (int i = 0; i < length; i++) {
        		if (i == (length -1)) {
					break;
			}
            if (target == (nums[i] + nums[i+1])) {
            		a = new int[2];
                 a[0] = i;
                 a[1] = i+1;
            }
        }
        return a;
    }

	public static void main(String[] args) {
		int nums[] = {2, 7, 11, 15};

        int target = 9;

        System.out.println((twoSum(nums, target)));
	}

}
