package oaphone.jpmorgan;

/**
 * @Description LeetCode-----将数组/链表后k个元素移动到前面
 * https://blog.csdn.net/sinat_35261315/article/details/78586116
 * @Author Jeff
 * @Date 2019/3/26 17:08
 * @Version V1.0
 * <p>
 * <p>
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 * <p>
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class RotateArray {
    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotateArray.rotate(nums, k);
    }

    public void rotate(int[] nums, int k) {
        /* 防止k大于n，这一步骤让k小于n。因为回转n次等于没有回转 */
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);  // {7, 6, 5, 4, 3, 2, 1}
        reverse(nums, 0, k - 1);            // {5, 6, 7, 4, 3, 2, 1}
        reverse(nums, k, nums.length - 1);        // {5, 6, 7, 1, 2, 3, 4}
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
