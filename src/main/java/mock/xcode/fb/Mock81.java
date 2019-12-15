package mock.xcode.fb;

import java.util.Arrays;

public class Mock81 {

    // Run time: O(nlogn)
    public static void main(String[] args) {
        Mock81 mock81 = new Mock81();
        int[] input = {1, 3, 5, 2, 4, 5, 9, 6, 7};
        System.out.print(" " + mock81.longestK(input,3));
    }

    public int longestK (int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int s = 0, e = 0; s < nums.length;)
        {
            if (nums[s] % k == 0) {
                int pre = nums[s];
                int duplicate = 0;
                e = s + 1;
                while (e < nums.length && (nums[e] - pre == k  || nums[e] == pre)) {
                    if (nums[e] == pre) {
                        duplicate++;
                    }
                    else {
                        pre = nums[e];
                    }
                    e++;
                }
                res = Math.max(res, e - s - duplicate);
                s = e;
            }
            else {
                e++;
                s = e;
            }
        }
        return res;
    }

}
