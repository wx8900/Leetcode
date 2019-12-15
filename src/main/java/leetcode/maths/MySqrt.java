package leetcode.maths;

public class MySqrt {
    public static void main(String[] args) {
        MySqrt m = new MySqrt();
        int a = 8;
        System.out.println(m.mySqrt(a));
    }

    public int mySqrt(int x) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (x == i * i) {
                return (int) Math.floor(i);
            }
        }
        return -1;
    }
}
