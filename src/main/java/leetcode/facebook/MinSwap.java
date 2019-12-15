package leetcode.facebook;

public class MinSwap {

    public static void main(String[] args) {
        int[] A = new int[]{1,3,5,4};
        int[] B = new int[]{1,2,3,7};
        System.out.println(minSwap(A, B));

    }

    public static int minSwap(int[] A, int[] B) {
        int index = 1;
        int count = 0;
        return dfs(A, B, index, count);
    }

    private static int dfs (int[] A, int[] B, int i, int count) {
        int result = 0;
        for (; i < A.length; i++) {
            if (A[i] == A[i - 1] || B[i] == B[i - 1]) {
                swap(A, B, i - 1);
                int can1 = dfs(A, B, i + 1, count++);
                result = count;
                swap(A, B, i);
                int can2 = dfs(A, B, i + 1, count++);
                result = count;
                //result += Math.min(can1, can2);
            }
            if (A[i] < A[i - 1] || B[i] < B[i - 1]) {
                swap(A, B, i - 1);
                int can1 = dfs(A, B, i + 1, count++);
                result = can1;
                swap(A, B, i);
                int can2 = dfs(A, B, i + 1, count++);
                result = can2;
                //result += Math.min(can1, can2);
            }
        }

        return result;
    }

    private static void swap(int[] A, int[] B, int i) {
        int temp = B[i];
        B[i] = A[i];
        A[i] = temp;
    }
}
