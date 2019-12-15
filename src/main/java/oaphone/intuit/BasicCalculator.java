package oaphone.intuit;

import java.util.Stack;

/**
 * 224. Basic Calculator
 Implement a basic calculator to evaluate a simple expression string.

 The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

 Example 1:
 Input: "1 + 1"
 Output: 2

 Example 2:
 Input: " 2-1 + 2 "
 Output: 3

 Example 3:
 Input: "(1+(4+5+2)-3)+(6+8)"
 Output: 23
 *
 * @author Jeff
 * @version V1.0
 * @date 8/4/19 13:08
 */
public class BasicCalculator {

    public static void main(String[] args) {
        System.out.println(calculate(" 2-1 + 3"));
    }

    /*public static int calculate(String s) {
        int len = s.length(), sign = 1, result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += sum * sign;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            }
            else if (s.charAt(i) == '-') {
                sign = -1;
            }
            else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }*/

    public static int calculate(String s) {
        int len = s.length(), sign = 1, result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += sum * sign;
            } else if ('+' == s.charAt(i)) {
                sign = 1;
            } else if ('-' == s.charAt(i)) {
                sign = -1;
            } else if ('(' == s.charAt(i)) {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (')' == s.charAt(i)) {
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }
}