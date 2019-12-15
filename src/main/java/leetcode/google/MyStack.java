package leetcode.google;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class  MyStack {

    public static void main(String[] args) {
        MyStack m = new MyStack();
        m.add(new Integer(1));
        m.add(new Integer(2));
        m.add(new Integer(3));

        System.out.println(m.pop());
        System.out.println(m.pop());
        System.out.println(m.pop());
    }

    Queue<Integer> queue = new LinkedList<>();

    public Integer pop() {
        Integer t = new Integer(0);
        Collections.reverse(Arrays.asList(queue.toArray()));
        if (!queue.isEmpty()) {
            return queue.remove();
        }

        return t;
    }

    // 1, 2, 3
    public void add(Integer t) {
        queue.add(t);
        // 1, 2, 3
    }
}
