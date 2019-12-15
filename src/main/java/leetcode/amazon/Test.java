package leetcode.amazon;

public class Test {

    public static void main(String[] args) {
        /**
         * input: int[] in = [3,7,9,2,1,10,15] and target = 10;
         * output:
         *       3,7
         *       1,9
         *       1,2,7
         *       10
         */
        // [1, 2, 3, 7, 9, 10, 15];
        Test t = new Test();
        System.out.println(t.reverseEachWord("Hello World")); // "Hello World"=>"olleH dlroW"
    }

    public static String findTarget(int[] ints, int target) {
        String result = "";

        return result;
    }

    public String reverseEachWord(String str) {
        String result = "";
        String[] st = str.split(" ");
        final int n = st.length;
        for (int i = 0; i < n; i++) {
            String flag = (i == 0) ? "" : " ";
            result += flag + reverse(st[i]);
        }
        return result;
    }

    private String reverse(String s) {
        char[] ch = s.toCharArray();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++; // 指针移动不要忘记
            end--;
        }
        return String.valueOf(ch);
    }
}