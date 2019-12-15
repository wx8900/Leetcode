package leetcode.line.parentheses;

import java.util.Stack;

public class ValidParenthesesII {
    public static void main(String[] args) {
        ValidParenthesesII so = new ValidParenthesesII();
        System.out.println(so.isValid(""));
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cIn = s.charAt(i);
            if (cIn == '(' || cIn == '[' || cIn == '{') {
                stack.push(cIn);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char cOut = stack.pop();
                    return checkValid(cIn, cOut);
                    // if (cOut == '(' && cIn = ')'
                    //     || cOut == '[' && cIn == ']'
                    //     || cOut == '{' && cIn == '}') {
                    //     return true;
                    // } else {
                    //     return false;
                    // }
                }
            }
        }
        return false;
    }

    private boolean checkValid(char cIn, char cOut) {
        if (cOut == '(') {
            if (cIn == ')') {
                return true;
            }
        }
        if (cOut == '[') {
            if (cIn == ']') {
                return true;
            }
        }
        if (cOut == '{') {
            if (cIn == '}') {
                return true;
            }
        }
        return false;
    }


}
