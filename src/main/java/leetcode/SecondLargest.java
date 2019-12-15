package leetcode;

import java.util.PriorityQueue;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 7/21/19 19:37
 */
public class SecondLargest {

    public static void main(String[] args) {
        int arr[] = {14, 46, 47, -10, 86, 92, 52, 48, 36, 66, 85, -2};
        SecondLargest secondLargest = new SecondLargest();
        int result = secondLargest.findSecondLargest(arr);
        int result2 = getMax22(arr);
        int result3 = getSecond(arr);
        System.out.println("The result is : " + result);
        System.out.println("The result2 is : " + result2);
        System.out.println("The result2 is : " + result3);
    }

    public static int getSecond(int[] arr) {
        int max1 = arr[0];
        int max2 = arr[1];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > max2) {
                max2 = arr[i];
            }
            if (max2 > max1) {
                int tmp = max1;
                max1 = max2;
                max2 = tmp;
            }
        }
        return max2;
    }

    private int findSecondLargest(int[] arr) {
        int result = Integer.MAX_VALUE;
        int secondLargest = 0;
        if (arr == null || arr.length == 0) {
            return result;
        }
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((a, b) -> b.intValue() - a.intValue());
        for (int i : arr) {
            pQueue.offer(i);
        }
        while (!pQueue.isEmpty()) {
            int p = pQueue.poll();
            if (secondLargest == 1) {
                result = p;
                break;
            }
            secondLargest++;
        }
        return result;
    }

    public static int getMax22(int[] arr) {
        int max1 = arr[0];
        int max2 = arr[1];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > max2) {
                max2 = arr[i];
            }
            if (max2 > max1) {
                int temp = max1;
                max1 = max2;
                max2 = temp;
            }
        }
        return max2;
    }

}
