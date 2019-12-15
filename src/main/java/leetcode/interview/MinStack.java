package leetcode.interview;

import java.util.LinkedList;
import java.util.Queue;
/**
 *
 how to implement a stack using single queue
 https://leetcode.com/articles/implement-stack-using-queues/

 Implement the following operations of a stack using queues.
 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 empty() -- Return whether the stack is empty.

 */
public class MinStack {

    // Driver program to test above methods
    public static void main(String[] args)
    {
        MinStack s = new MinStack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println("Top element :" + s.top());
        //s.pop();
        s.push(40);
        //s.pop();
        System.out.println("Top element :" + s.top());
    }

    Queue<Integer> q = new LinkedList<Integer>();

    // Push operation
    void push(int val)
    {
        // get previous size of queue
        int size = q.size();

        // Add current element
        q.add(val);

        // Pop (or Dequeue) all previous
        // elements and put them after current element
        for (int i = 0; i < size; i++)
        {
            // this will add front element into
            // rear of queue
            int x = q.remove();  //Retrieves and removes the head of this queue.
            q.add(x);
        }
    }

    // Removes the top element
    int pop()
    {
        if (q.isEmpty())
        {
            System.out.println("No elements");
            return -1;
        }
        int x = q.remove();
        return x;
    }

    // Returns top of stack
    int top()
    {
        if (q.isEmpty()) {
            return -1;
        }
        return q.peek();
    }

    // Returns true if Stack is empty else false
    boolean isEmpty()
    {
        return q.isEmpty();
    }
}
