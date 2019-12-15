package systemdesign.elevator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 切记一定不要使用普通for循环去遍历LinkedList。使用迭代器或者foreach循环（foreach循环的原理就是迭代器）
 * 去遍历LinkedList即可，这种方式是直接按照地址去找数据的，将会大大提升遍历LinkedList的效率。LinkedList
 * 在get任何一个位置的数据的时候，都会把前面的数据走一遍.LinikedList遍历的时间复杂度为O(N2)，N为LinkedList的容量。
 *
 * 使用普通for循环遍历ArrayList的速度很快，也很稳定, 因为ArrayList的get方法的时间复杂度是O(1)
 *
 * 时间复杂度有以下经验规则
 * O(1) < O(log2N) < O(n) < O(N * log2N) < O(N2) < O(N3) < 2N < 3N < N!
 */
public class Test9 {
    public static void main(String[] str) {
        //Building building = new Building(1, "Town Hall", -3, 10);

        Queue<Integer> requestQueueUp = new LinkedList<>();
        Queue<Integer> requestQueueDown = new LinkedList<>();

        Elevator9 elevator9 = new Elevator9(1, 20, 1, requestQueueUp, requestQueueDown);
        // floor down from 2 to 1 is error if QueueUp has 3

        elevator9.addWaitingFloor(9, false);

    }
}
