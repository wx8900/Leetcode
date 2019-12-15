package leetcode.microsoft;

public class StringtoIntegerII {

    public static void main(String[] args) {
        StringtoIntegerII so = new StringtoIntegerII();
        System.out.println(so.myAtoi(" 5436546547657575"));
    }

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int i = 0, j = 0, sign = 1;
        char[] c = str.toCharArray();
        int len = c.length;

        while (i < len && c[i] == ' ') {
            i++;
        }
        if (i < len && c[i] == '-') {
            sign = -1;
            i++;
        } else if (i < len && c[i] == '+') {
            i++;
        }

        if (i < len && !Character.isDigit(c[i])) {
            return 0;
        }
        for (j = i; j < len;) {
            if (Character.isDigit(c[j])) {
                j++;
            } else {
                break;
            }
        }
        if (j == i) {
           return 0;
        }
        System.out.println("==i=="+i +"==j=="+j);
        try {
            int num = Integer.parseInt(str.substring(i, j));
            System.out.println("=====str====="+str.substring(i, j));
            return (sign < 0) ? sign * num : num;
        } catch (Exception e) {
            //e.printStackTrace();
            return (sign < 0)  ? Integer.MIN_VALUE: Integer.MAX_VALUE;
        }
    }
}
