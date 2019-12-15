package leetcode.array;

import java.util.Arrays;

/**
 * @author Jeff
 * @version V1.0
 * @description
 * @date 2019/4/18 00:17
 */
public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println("============"+mergeIntervals.merge(intervals));
    }

    private int[][] merge(int[][] intervals) {
        int m = intervals.length;
        int n = intervals[0].length;
        int[] starts = new int[m];
        int[] ends = new int[m];
        System.out.println("=====m====="+ m + ", =====n====="+n);

        for (int i = 0; i < m; i++) {
            starts[i] = intervals[i][0];
        }
        for (int i = 0; i < m; i++) {
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int[][] res = new int[m][n];
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res[i][j] = starts[j] + ends[i];
                j = i + 1;
            }
        }
        return res;
    }
}
