package leetcode.microsoft;

/**
 * @date 2/19/2019
 */
public class StringtoIntegerIII {
    public static void main(String[] args) {
        StringtoIntegerIII so = new StringtoIntegerIII();
        System.out.println(so.myAtoi(" -42809890890809"));
    }

    public int myAtoi(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        int i = 0, j = 0, sign = 1, res = 0;
        int signCount = 0;
        int len = str.length();
        while (i < len && ' ' == str.charAt(i)) {
            i++;
        }
        while (i < len && '+' == str.charAt(i)) {
            signCount++;
            i++;
        }
        while (i < len && '-' == str.charAt(i)) {
            signCount++;
            sign = -1;
            i++;
        }
        j = i;
        while (j < len && Character.isDigit(str.charAt(j))) {
            j++;
        }
        if (i == j || signCount >= 2) {
            return 0;
        }
        System.out.println(i + "====="+j);
        try {
            res = sign * Integer.parseInt(str.substring(i, j));
        } catch (Exception e) {
            res = (sign < 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return res;
    }
}
