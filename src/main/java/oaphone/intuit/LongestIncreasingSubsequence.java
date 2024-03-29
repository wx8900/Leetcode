package oaphone.intuit;

/**
 * 673. Number of Longest Increasing Subsequence
 *
 * Given an unsorted array of integers, find the number of longest increasing subsequence.

 Example 1:
 Input: [1,3,5,4,7]
 Output: 2
 Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].

 Example 2:
 Input: [2,2,2,2,2]
 Output: 5
 Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
 *
 * @author Jeff
 * @version V1.0
 * @date 8/3/19 20:24
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] array = {1,3,5,4,7};
        System.out.println(lis.findNumberOfLIS(array));
    }

    /**
     len[i] 代表以第 i 个数结尾的最长上升子序列的长度。
     cnt[i] 代表以第 i 个数结尾的最长上升子序列的个数。
     len[i] = max(len[j] + 1), nums[j] < nums[i]。
     cnt[i] = sum(cnt[j]), nums[j] < nums[i] and len[j] == len[i] - 1。

     The idea is to use two arrays len[n] and cnt[n] to record the maximum length of Increasing Subsequence and the coresponding number of these sequence which ends with nums[i], respectively. That is:

     len[i]: the length of the Longest Increasing Subsequence which ends with nums[i].
     cnt[i]: the number of the Longest Increasing Subsequence which ends with nums[i].

     Then, the result is the sum of each cnt[i] while its corresponding len[i] is the maximum length.
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] len =  new int[n], cnt = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = cnt[i] = 1;
            for (int j = 0; j < i ; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] == len[j] + 1) {
                        cnt[i] += cnt[j];
                    }
                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if (max_len == len[i]) {
                res += cnt[i];
            }
            if (max_len < len[i]) {
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }

}
