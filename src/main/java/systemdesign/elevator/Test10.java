package systemdesign.elevator;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 *
 */
public class Test10 {
    public static void main(String[] str) {
        Queue<Integer> requestQueueUp = new LinkedList<>();
        Queue<Integer> requestQueueDown = new LinkedList<>();
        requestQueueDown.offer(10);
        requestQueueDown.offer(6);
        requestQueueDown.offer(2);
        requestQueueUp.offer(3);
        requestQueueUp.offer(5);
        requestQueueUp.offer(8);

        Elevator10 elevator10 = new Elevator10(1, 20, 10,
                1, 1, requestQueueUp, requestQueueDown);
        // floor down from 2 to 1 is error if QueueUp has 3

        //elevator10.addWaitingFloor(3, true);
    }
}
