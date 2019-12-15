package leetcode.string;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements t = new TopKFrequentElements();
        int[] a = new int[]{1, 1, 1, 2, 2, 3, 3, 3, 3};
        int k = 2;
        System.out.println(t.kLgN(a, k));
        //System.out.println(t.nLgK(a, k));
    }

    private List<Integer> nLgK(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : a) {
            map.put(val, map.containsKey(val) ? map.get(val) + 1 : 1); // val -> freq;
        }

        PriorityQueue<Map.Entry<Integer, Integer>> _minHeap = new PriorityQueue<>((o1 , o2) -> o1.getValue().compareTo(o2.getValue()));  // Line 13: java.lang.NullPointerException
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            _minHeap.add(entry);
            if (_minHeap.size() == k + 1) { // more code than kLgN
                _minHeap.poll();
            }
        }

        List<Integer> result = new LinkedList<>(); // LinkedList
        while (!_minHeap.isEmpty()) {
            result.add(0, _minHeap.poll().getKey());
        }
        return result;
    }

    private List<Integer> kLgN(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : a) {
            map.put(val, map.containsKey(val) ? map.get(val) + 1 : 1); // val -> freq;
        }

        PriorityQueue<Map.Entry<Integer, Integer>> _maxHeap = new PriorityQueue<>(
                (o1 ,o2) -> o2.getValue() - o1.getValue());  // Line 12: java.lang.NullPointerException
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            _maxHeap.add(entry);
        }

        List<Integer> result = new ArrayList<>();
        while (!_maxHeap.isEmpty()) {
            result.add(_maxHeap.poll().getKey());
            if (result.size() == k) {
                break;
            }
        }
        return result;
    }
}
