package leetcode.line;

public class longestValidParentheses {
    public static void main(String[] args) {
        longestValidParentheses so = new longestValidParentheses();
        System.out.println("=========" + so.function("(()()"));
    }

    public int function(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        int result = 0;
        int n = s.length();

        // left to right
        int count = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if ('(' == s.charAt(i)) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                result = Math.max(result, (i - start + 1));
            } else if (count < 0) {
                start = i + 1;
                count = 0;
            }
        }
        System.out.println("====left to right=====" + result);

        //  right to left
        count = 0;
        int end = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (')' == s.charAt(i)) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                result = Math.max(result, end - i + 1);
            } else if (count < 0) {
                end = i - 1;
                count = 0;
            }
        }
        System.out.println("====right to left=====" + result);
        return result;
    }
}
