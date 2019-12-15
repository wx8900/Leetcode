package leetcode.microsoft;

public class StringtoInteger {

    public static void main(String[] args) {
        StringtoInteger so = new StringtoInteger();
        System.out.println(so.myAtoi(" +4245567"));
    }

    public int myAtoi(String str) {
        int res = 0, i = 0, j = 0;
        boolean negativeSign = false;
        if (str == null || str.trim().length() == 0) {
            return res;
        }
        char[] c = str.toCharArray();
        for (; i < c.length;) {
            if (c[i] == ' ') {
                i++;
            } else if (!(c[i] == '-' || c[i] == '+' || Character.isDigit(c[i]))) {
                return 0;
            } else {
                if (c[i] == '-' || c[i] == '+') {
                    if (c[i] == '-') {
                        negativeSign = true;
                    }
                    i++;
                }
                for (j = i; j < c.length;) {
                    if (Character.isDigit(c[j])) {
                        j++;
                    } else {
                        break;
                    }
                }
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
            res = negativeSign ? -1 * num : num;
            System.out.println("=====res====="+res);
        } catch (Exception e) {
            //e.printStackTrace();
            res = negativeSign ? Integer.MIN_VALUE: Integer.MAX_VALUE;
        }
        return res;
    }
}
