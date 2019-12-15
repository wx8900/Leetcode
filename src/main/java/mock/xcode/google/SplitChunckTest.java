package mock.xcode.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
09/30/2018 10:00 AM 第3期第3场 Z神

 [2, 1, 3, 4, 4]
 0  1  2  3  4

 [2, 1 | 3 | 4 | 4]

 [2, 1] [3] [4] [4]
 [1, 2] [3] [4] [4] => SORTED
 1   2    3  4
 [2] [1] [3] [4] [4]
 2   1   3   4   4

 [5  4   3   2  1]
 4
 1  2   3   4  5
 [1,2,3,4,4]
 [4,4,4,4,4]  =
 */
public class SplitChunckTest {
    public List<Integer> splitChunck(int[] arr) {
        int[] orginal = arr.clone();
        Arrays.sort(arr);
        List<Integer> res = new ArrayList<>();
        int start = 0;
        for (int end = 0; end < orginal.length; end++) {
            if (match(orginal, arr, start, end)) {
                res.add(end);
            }
        }
        res.add(arr.length - 1);
        return res;
    }

    private boolean match(int[] orginal, int[] arr, int start, int end) {
        // ....

        return false;
    }

}
