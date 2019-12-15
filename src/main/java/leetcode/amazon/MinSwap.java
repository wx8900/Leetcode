package leetcode.amazon;

public class MinSwap {
    public static void main (String[] args) {
        int[] A = new int[]{0,4,4,7,9};
        int[] B = new int[]{0,1,6,8,10};
        System.out.println( minSwap(A, B) );
    }

    public static int minSwap(int[] A, int[] B) {
        int n = A.length;
        int newStart = 0;
        int[] dp = new int[n];
        int preA = A[0];
        int preB = B[0];
        dp[0] = 0;

        int count = 0;
        for (int i = 1; i < n; ++ i) {
            if (Math.min(A[i], B[i]) > Math.max(preA, preB)) {
                newStart = i;
                count += dp[i - 1];
                dp[i] = 0;
                preA = A[i];
                preB = B[i];
            } else if (A[i] > preA && B[i] > preB) {
                dp[i] = dp[i - 1];
                preA = A[i];
                preB = B[i];
            } else {
                int swap = dp[i - 1] + 1;
                int unswap = i - newStart - swap + 1;
                if (swap < unswap) {
                    preB = A[i];
                    preA = B[i];
                }
                dp[i] = Math.min(swap, unswap);
                preA = A[i];
                preB = B[i];
            }
        }

        return count + dp[n - 1];
    }

    /*public static int minSwap(int[] A, int[] B) {
        int[] result = new int[A.length];
        int odd = 0;
        int swap = 0;
        int topA = A[0];
        int topB = B[0];
        for(int i = 1; i < A.length; i++){
            if(A[i] > topA && A[i] > topB && B[i] > topA && B[i] > topB){
                odd = i;
                topA = A[i];
                topB = B[i];
                result[i] = 0;
                swap += result[i - 1];
            }else if(A[i] > topA && B[i] > topB){
                result[i] = result[i - 1];
                topA = A[i];
                topB = B[i];
            }else if(result[i - 1] * 2 == (i - odd)){
                topA = A[i];
                topB = B[i];
                result[i] = result[i - 1];
            }else{
                topA = B[i];
                topB = A[i];
                result[i] = result[i - 1] + 1;
            }
        }
        swap += result[A.length - 1];
        return swap;
    }*/

}

