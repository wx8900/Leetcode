package leetcode.google;

import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        Calculator b = new Calculator();
        Stack stack = b.buildStack();
        System.out.println("=======Result======"+b.getSum(stack));
    }

    public Stack buildStack() {
        Stack stack=new Stack();
        //1.empty()栈是否为空
        //System.out.println(stack.empty());
        //2.peek()栈顶值    3.进栈push()
        stack.push("(");
        stack.push(new Integer(1));
        stack.push("+");
        stack.push(new Integer(2));
        stack.push(")");
        //System.out.println(stack.pop());
        //4.pop()出栈
        //stack.pop();
        System.out.println(stack);
        return stack;
    }

    private int getSum(Stack<Character> stack) {
        int result = 0;
        boolean isAdd = false;
        for (int j = 0; j < stack.size(); j++) {
            Character c = stack.pop();
            if (c == '(' || c == ')') continue;
            if (c == '+') {
                isAdd = true;
            } else if (c == '-') {
                isAdd = false;
            } else {
                if (c - 48 >= 0 && c - 48 <= 9) {
                    if (isAdd) {
                        result += Integer.valueOf(c - 48);
                    } else {
                        result -= Integer.valueOf(c - 48);
                    }
                }
            }
        }

        return result;
    }
}
