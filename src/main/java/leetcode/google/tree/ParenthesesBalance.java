package leetcode.google.tree;

import java.util.Stack;

public class ParenthesesBalance {
    public static void main(String[] args) {
        ParenthesesBalance pb = new ParenthesesBalance();
        System.out.println("=========" + pb.isValid("{([()()[]{}])}")); // support {(a,b)}
        //System.out.println("=========" + pb.getMatchingParenthesis('['));
    }

    private boolean isValid(String s) {
        if (s == null || s.length() <= 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{' ) {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}' ) {
                if (stack.isEmpty() || stack.pop() != getMatchingParenthesis(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private char getMatchingParenthesis(char c) {
        if (c == ')') return '(';
        if (c == ']') return '[';
        if (c == '}') return '{';
        return ' ';
    }
}
