package mock.xcode.fb;

/**
 FB 原题
 int array [1, 3, 5, 2, 4, 5, 9, 6, 7]
 find the longest 1-incremental sequence
 return 3, 4, 5, 6, 7
 */
public class Mock82 {
    public static void main(String[] args) {
        Mock82 mock82 = new Mock82();
        int[] input = {1, 3, 5, 2, 4, 5, 9, 6, 7};
        for (int i : mock82.longestIncrement(input)) {
            System.out.print(" " + i);
        }
    }

    public static int[] longestIncrement(int[] a) {
        int[] result = new int[0];
        int index = 0;
        int start = 0;

        if (a.length == 1) {
            return result;
        }

        result = new int[a.length];
        for (int i = 1; i < a.length; i++) {
            if (a[i] - a[i - 1] == 1) {
                result[index++] = a[i];
            } else {
                start++;
            }
        }

        return result;
    }
}
