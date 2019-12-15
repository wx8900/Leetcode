package leetcode.string;
//300. Longest Increasing Subsequence
public class LengthOfLISolution {

    /**
     * Given an unsorted array of integers, find the length of longest increasing subsequence.

     Example:
     Input: [10,9,2,5,3,7,101,18]
     Output: 4
     Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

     Note:
     There may be more than one LIS combination, it is only necessary for you to return the length.
     Your algorithm should run in O(n2) complexity.
     Follow up: Could you improve it to O(n log n) time complexity?
     */
    public static void main(String[] args) {
        LengthOfLISolution lis = new LengthOfLISolution();
        int[] nums = new int[]{1000, 10, 50, 18, 69, 2, 9, 7, 40};
        System.out.println(lis.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = binary(dp, nums[i], len);
            if (j == -1) {
                dp[len] = nums[i];
                len++;
            } else {
                dp[j] = nums[i];
            }
        }
        return len;
    }

    private int binary(int[] dp, int target, int len) {
        int result = -1;
        if (len == 0) return -1;
        int start = 0;
        int end = len - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (dp[mid] < target) {
                start = mid + 1;
            } else {
                if (result == -1) result = mid;
                result = (dp[result] > dp[mid]) ? mid : result;
                end = mid - 1;
            }
        }
        return result;
    }

}
