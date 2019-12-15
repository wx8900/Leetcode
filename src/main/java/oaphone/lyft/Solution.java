package oaphone.lyft;

import java.util.LinkedList;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 6/7/19 16:14
 *
A stack is a data structure with four main operations (for our case, let’s assume it’s a stack of ints):

push(i):    Add i to the top of the stack
pop():      Remove and return the value on the top of the stack, raising an exception
if the stack is empty (e.g. EmptyStackException)
peek():     Return, but do not remove, the value on the top of the stack, raising an
exception if the stack is empty
isEmpty():  Return a boolean that is true if there is nothing on the stack, and false
otherwise
Given this definition, implement a new class called MaxStack. It should have all the same functionality
as a regular stack, as well as a function that returns (but does not remove) the maximum value on the stack
in O(1) time. All other functions must continue to return in O(1) time.

sample input:
operation    stack    max value
push(3)      3        3
push(1)      3,1      3
push(5)      3,1,5    5
pop()        3,1      3

PrioityQueue
LinkedList    push()  compare with cur value with privious max vlaue
Integer
 */
public class Solution {
    int size = 0;
    int max = 0;
    LinkedList<MaxStack> list = new LinkedList<>();

    public static void main(String[] args) {
        Solution s = new Solution();
        s.push(3);
        s.push(1);
        s.push(5);
        int res = 0;
        try {
            res = s.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("res : " + res);
    }

    /**
     * 5  > 3
     * @param i
     */
    void push(Integer i) {
        MaxStack stack = new MaxStack(i);
        if (i > max) {
            list.addFirst(stack);
            max = i;
        } else {
            list.add(stack);
        }
        size++;
    }

    Integer pop() throws Exception {
        if (list.size() == 0) {
            throw new Exception("stack is empty!");
        }
        size--;
        MaxStack m = list.get(0);
        return m.value;
    }

    Integer peek() throws Exception {
        if (list.size() == 0) {
            throw new Exception("stack is empty!");
        }
        MaxStack m = list.get(0);
        return m.value;
    }

    boolean isEmpty() {
        return (list == null || list.size() == 0) ? true : false;
    }

    class MaxStack {
        int value;
        public MaxStack(int val) {
            this.value = val;
        }
    }
}