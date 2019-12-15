package leetcode.amazon;

public class ReverseByHex {

    public static void main (String[] args) {
        int a = reverseByHex(0x12345678);
        System.out.println("==="+a);
    }
// reverse integer
//   input: 0x12345678
//   output: 0x78563412

    public static void test() {

    }

    public static int reverseByHex(int num) {
        if (num > Integer.MAX_VALUE) return -1;

        return 0;


    }
}
