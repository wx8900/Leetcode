package oaphone.jpmorgan;

/**
 * @Description
 * @Author Jeff
 * @Date 2019/3/25 22:41
 * @Version V1.0
 */
public class PQImpl {
    private Comparable[] pQueue; // Interface Array
    private int index;

    public PQImpl(int capacity) {
        pQueue = new Comparable[capacity];
    }

    /**
     * O(1)
     *
     * @param item
     */
    public void insert(Comparable item) {
        if (index == pQueue.length) {
            System.out.println("The priority queue is full!! cannot insert");
            return;
        }
        pQueue[index] = item;
        index++;
        System.out.println("Adding element : " + item);
    }

    /**
     * O(n)
     *
     * @return
     */
    public Comparable remove() {
        if (index == 0) {
            System.out.println("The priority queue is empty!! cannot move.");
            return null;
        }
        int maxIndex = 0;
        for (int i = 1; i < index; i++) {
            if (pQueue[i].compareTo(pQueue[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        Comparable result = pQueue[maxIndex];
        System.out.println("removing : " + result);
        index--;
        pQueue[maxIndex] = pQueue[index];
        return result;
    }
}
