package leetcode.microsoft;

public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome vp = new LongestPalindrome();
        // return "bb"
        System.out.println(vp.longestPalindrome("cbbd"));
    }


    int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        for (int i = 0; i < len - 1; i++) {
            palindromeHelper(s, i, i);
            palindromeHelper(s, i, i + 1);
        }
        return s.substring(lo, lo + maxLen);
    }

    private void palindromeHelper(String s, int j, int k) {
        System.out.println("before while, j: "+ j + ", k " + k);
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
            System.out.println("========>Go into while, j: "+ j + ", k " + k);
        }
        System.out.println("After while, j: "+ j + ", k " + k);
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j -1;
            System.out.println("========>Update lo: "+ lo);
        }
        System.out.println("lo: "+ lo + ", maxLen " + maxLen);
    }
}
