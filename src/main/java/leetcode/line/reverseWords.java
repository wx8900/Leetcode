package leetcode.line;

import java.util.ArrayList;
import java.util.List;

public class reverseWords {

    public static void main(String[] args) {
        reverseWords so = new reverseWords();
        so.reverseWords("    the  sky is blue");
    }

    public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        boolean lastIsNotBlank = false;
        boolean blankAtFirst = false;
        int index = 0, leng = s.length();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < leng; i++) {
            if (s.charAt(i) == ' ') {
                if (i == 0) {
                    lastIsNotBlank = true;
                    blankAtFirst = true;
                }
                if (!lastIsNotBlank) {
                    list.add(s.substring(i, i));
                    index = i + 1;
                    lastIsNotBlank = true;
                }
            } else {
                lastIsNotBlank = false;
                if (blankAtFirst) {
                    s = s.substring(i, leng);
                }
            }
            if (i == leng - 1) {
                list.add(s.substring(index, leng));
            }
            System.out.println("===i==="+ i +"===list=="+list);
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i) + ((i != leng - 1) ? " " : ""));
            System.out.println("===sb==="+sb.toString());
        }
        return sb.toString();
    }
}