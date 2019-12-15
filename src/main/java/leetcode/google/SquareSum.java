package leetcode.google;

public class SquareSum {
    public static void main(String[] args) {
        System.out.println(100%3);
        System.out.println("============");
        System.out.println(100%3.0);
        SquareSum m2 = new SquareSum();
        m2.judgeSquareSum(5);
        double x =2006;
        System.out.println("=====X========"+ x);
        System.out.println("=====%1=====" + x %1);
        System.out.println("=====%2=====" + x %2);
        System.out.println("=====%3=====" + x %3);
        System.out.println("=====%4=====" + x %4);
        System.out.println("=====%10=====" + x %100);

    }

    public boolean judgeSquareSum(int c) {
        if (c == 0) {
            return true;
        }
        for (int a = 0; a < Math.sqrt(c) + 1; a++) {
            double b = Math.sqrt(c - a * a);
            if (b % 1 == 0) {
                //System.out.println(b % 1);
                return true;
            }
        }
        return false;
    }

}
