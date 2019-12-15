package oaphone.ebay;

import java.util.Stack;
import java.util.stream.Stream;

/**
 * Decode a String
 *
 * @author Jeff
 * @version V1.0
 * @date 7/18/19 12:02
 */
public class CodeProcess {
    public static void main(String[] args) {
        CodeProcess c = new CodeProcess();
        /*String res = c.decode("3[a]2[bc]");
        System.out.println("The res is : " +res);*/
        long count = c.countWords("This sia eclipse random Eclipse ecliPse not a valid ECLIPSE sdfdsf sdfd");
        System.out.println("The count is : " + count);
    }

    private String decode(String in) {
        if(in == null || in.length() <= 0) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        char[] arr = in.toCharArray();
        int preNum = 1;
        StringBuilder tmp = new StringBuilder();
        StringBuilder tmpStr = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for(char ch : arr) {
            if(Character.isDigit(ch)) {
                preNum = Integer.valueOf(ch - '0');
            } else {
                if(ch == '[') {
                    stack.push('[');
                } else {
                    if(ch != ']') {
                        tmp.append(ch);
                    } else {  // ']'
                        char c = stack.pop();
                        if(c == '[' && ch == ']') {
                            for (int i = 0; i < preNum; i++) {
                                tmpStr.append(tmp);
                            }
                        }
                        res.append(tmpStr);
                        tmp = new StringBuilder();
                        tmpStr = new StringBuilder();
                    }
                }
            }
        }
        return res.toString();
    }

    public long countWords(String str) {
        // assume str is not null or empty
        return Stream.of(str.split(" "))
                     .filter(ele -> ele.equalsIgnoreCase("eclipse"))
                     .map(ele -> new String(ele))
                     .count();
    }

}
