package oaphone.compass;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: positive integer n
 * n=n/2 (if n is even)
 * n=3n+1 (if n is odd)
 * <p>
 * 13->40->20->10->5->16->8->4->2->1 (steps 10)
 * 4->2->1 (3 steps)
 * <p>
 * So the question is:
 * given an upperbound such as 10000, find a start number under that upperbound that gives the longest number of steps
 * <p>
 * Upperbound=5,  Output: 3
 * <p>
 * 1 (1 step)
 * 2->1 (2 steps)
 * 3->10->5->16->8->4->2->1 (8 steps)
 * 4->2->1 (3 steps)
 * Map<start number, steps>
 *
 * @author Jeff
 * @version V1.0
 * @date 6/6/19 17:09
 */
public class ComSolution {
    public static void main(String[] args) {
        ComSolution s = new ComSolution();
        int upperbound = 10000;
        System.out.print("======result====" + s.getMaxSteps(upperbound));
    }

    private int recursive(int i, int steps) {
        if (i == 1) {
            return steps;
        } else {
            if (i % 2 == 0) {
                i = i / 2;
                steps++;
                //System.out.println("===even=="+i);
                return recursive(i, steps);
            } else {
                i = 3 * i + 1;
                steps++;
                //System.out.println("===odd=="+i);
                return recursive(i, steps);
            }
        }
    }

    private int getMaxSteps(int upperbound) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < upperbound; i++) {
            int steps = 1;
            map.put(i, recursive(i, steps));
        }

        int min = Integer.MIN_VALUE;
        for (int i : map.values()) {
            if (i > min) {
                min = i;
            }
        }
        return min;
    }

}
