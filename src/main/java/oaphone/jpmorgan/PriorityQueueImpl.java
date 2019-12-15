package oaphone.jpmorgan;

/**
 * @Description one can keep all the elements in an unsorted list. Whenever the highest-priority element
 * is requested, search through all elements for the one with the highest priority. In big O notation:
 * O(1) insertion time, O(n) pull time due to search.
 * @Author Jeff
 * @Date 2019/3/25 22:19
 * @Version V1.0
 */
public class PriorityQueueImpl {
    private Comparable[] pQueue;
    private int index;

    public PriorityQueueImpl(int capacity) {
        pQueue = new Comparable[capacity];
    }

    public static void main(String[] args) {
        PriorityQueueImpl pqi = new PriorityQueueImpl(5);
        pqi.insert(34);
        pqi.insert(23);
        pqi.insert(5);
        pqi.insert(87);
        pqi.insert(32);
        pqi.remove();
        pqi.remove();
        pqi.remove();
        pqi.remove();
        pqi.remove();
    }

    public void insert(Comparable item) {
        if (index == pQueue.length) {
            System.out.println("The priority queue is full!! can not insert.");
            return;
        }
        pQueue[index] = item;
        index++;
        System.out.println("Adding element: " + item);
    }

    @SuppressWarnings("unchecked")
    public Comparable remove() {
        if (index == 0) {
            System.out.println("The priority queue is empty!! can not remove.");
            return null;
        }
        int maxIndex = 0;
        // find the index of the item with the highest priority
        for (int i = 1; i < index; i++) {
            if (pQueue[i].compareTo(pQueue[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        Comparable result = pQueue[maxIndex];
        System.out.println("removing: " + result);
        // move the last item into the empty slot
        index--;
        pQueue[maxIndex] = pQueue[index];
        return result;
    }
}
