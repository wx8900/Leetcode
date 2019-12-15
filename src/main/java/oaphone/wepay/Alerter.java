package oaphone.wepay;

import java.util.TreeSet;

public class Alerter {

    public static void main(String[] args) {
        Alerter alerter = new Alerter();
        int[] input = {
                8,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100
        };
        System.out.print(" " + alerter.alert(input, 2,1.5));// should be return false
    }

    public boolean alert(int[] nums, int winSize, double allowedIncrease) {
        if (nums == null || nums.length == 0) { // check the input array is null or empty
            return false;
        }

        int max = Integer.MIN_VALUE;
        double avg = 0.0;

        if (nums.length <= winSize) { // the number of elements in the window is not larger than the window size
            for (int i = 0; i < nums.length; i++) {
                avg += nums[i];           // add all element of input array
                if (max < nums[i]) {      // when the value of any element is large than the max
                    max = nums[i];        // update the max value
                }
            }
            avg /= nums.length;           // calculate the average of the window
            return (double)max > avg * allowedIncrease; // judge whether max value is large than average multiply allowed Increase
        }

        // the number of elements in the window is larger than the window size
        // initialization
        int maxIndex = -1;
        TreeSet<Integer> bst = new TreeSet<>((i1, i2)->nums[i1] == nums[i2] ? i1 - i2 : nums[i1] - nums[i2]);    // BST<Index>

        for (int i = 0; i < winSize; i++) {
            avg += nums[i];
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
            bst.add(i);
        }
        avg /= winSize;

        if (maxIndex == 0 && (double)max > avg * allowedIncrease) {
            return true;
        }

        // General Case
        double preAvg = avg;
        boolean result = true;
        for (int i = winSize; i < nums.length; i++) {
            bst.remove(i - winSize);    // delete the
            bst.add(i);                    // add the new element
            maxIndex = bst.last();
            max = nums[bst.last()];
            avg = (preAvg * winSize - nums[i - winSize] + nums[i]) / winSize;
            result = result && (double)max > avg * allowedIncrease;
            if (maxIndex == i - winSize + 1 && result) {
                return result;
            }
            if (avg > preAvg * allowedIncrease) {
                return true;
            }
            preAvg = avg;
        }
        return false;
    }
}
