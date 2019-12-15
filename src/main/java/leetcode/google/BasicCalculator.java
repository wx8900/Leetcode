package leetcode.google;

import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {
        BasicCalculator b = new BasicCalculator();
        System.out.println("=======Result======"+b.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public int calculate(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        int result = 0;
        boolean isAdd = false;
        s = s.trim();
        int validLen = s.length();
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < validLen; i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    if (c != ')') {
                        stack.push(c);
                    } else {
                        sum = getSum(stack);
                    }
                }
            }
            result += sum;
        }

        return result;
    }

    private int getSum(Stack<Character> stack) {
        int result = 0;
        boolean isAdd = false;
        for (int j = 0; j < stack.size(); j++) {
            char c = stack.pop();
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
