package leetcode.binarySearch;

public class FindMin {

    public static void main(String[] args) {
        FindMin fm = new FindMin();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(fm.findMin(nums));
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return ((nums[left] > nums[right]) ? nums[right] : nums[left]);
    }
}
