package leetcode.line.parentheses;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses so = new ValidParentheses();
        System.out.println(so.isValid("([]"));
    }

    public boolean isValid(String s) {
        Set<Character> setLeft = new HashSet<>(Arrays.asList('(', '{', '['));
        Set<Character> setAll = new HashSet<>(Arrays.asList('(', '{', '[', ')', '}', ']'));
        Stack<Character> stack = new Stack<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            if (setLeft.contains(c)) {
                stack.push(c);
            } else if (setAll.contains(c)) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    return checkChar(stack.pop(), c);
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty(); // return true; => logic error, shoule check if the remain stack is empty
    }

    private boolean checkChar(char cL, char cR) {
        return (cL == '(' && cR == ')')
                || (cL == '{' && cR == '}')
                || (cL == '[' && cR == ']');
    }
}
