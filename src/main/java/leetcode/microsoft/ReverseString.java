package leetcode.microsoft;

/**
 * @author Jack
 * @date   1/26/2019
 */
public class ReverseString {
    public static void main(String[] str) {
        ReverseString r = new ReverseString();
        System.out.print(r.reverseString("Hello world! "));
    }

    public String reverseString(String s){
        if(s == null || s.length() == 0) {
            return "";
        }
        char[] cs = s.toCharArray();
        int begin = 0, end = s.length() - 1;
        while(begin <= end){
            char c = cs[begin];
            cs[begin] = cs[end];
            cs[end] = c;
            begin++;
            end--;
        }
        return new String(cs);
    }
}
