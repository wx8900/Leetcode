package leetcode.line;

import java.util.ArrayList;
import java.util.List;

public class ValidWordSquare {

    public static void main(String[] args) {
        ValidWordSquare vw = new ValidWordSquare();
        List<String> words = new ArrayList<>();
        // example 1
//        words.add("abcd");
//        words.add("bnrt");
//        words.add("crmy");
//        words.add("dtye");

        // example 2
        words.add("abcd");
        words.add("bnrt");
        words.add("crm");
        words.add("dt");

        // example 3
//        words.add("ball");
//        words.add("area");
//        words.add("read");
//        words.add("lady");

        System.out.println(vw.validWordSquare(words));
    }

    //     public boolean validWordSquare(List<String> words) {
//         if (words == null || words.size() == 0) {
//             return false;
//         }

//         final int n = words.size();
//         String[] array = new String[n];
//         array = words.toArray();
//         final int m = array[0].length();
//         String rowWord = "", colWord = "";
//         boolean isWordSquare = false;

//         if (n != m) {
//             return false;
//         }

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 colWord += array[j].charAt(j);
//             }
//             if(!isSameWord(rowWord, colWord)) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     private boolean isSameWord(String a, String b) {
//         if (a.length() == b.length()) {
//             for (int i = 0; i < a.length(); i++) {
//                 if (a.charAt(i) == b.charAt(i)) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }

    public boolean validWordSquare(List<String> words) {

        if (words == null || words.size() == 0) {
            return false;
        }

        final int n = words.size();
        String[] array = words.toArray(new String[n]);
        final int m = array[0].length();
        String colWord = "";
        int rowIndex = 0;

        if (n != m) {
            return false;
        }

        for (int col = 0; col < m; col++) {     // 先循环col(表示col index),取每个单词第j个字符，取一个单词，j要保持不变
            for (int row = 0; row < n; row++) { // 再循环row(表示row index)
                String curWord = array[row];
                if (col > curWord.length() - 1) { // 当col超过第i个单词的长度时，skip loop ==>针对example 2
                    continue;
                }
                colWord += curWord.charAt(col);
            }
            if (!isSameWord(array[rowIndex], colWord)) {
                return false;
            }
            colWord = ""; // colWord一定要清掉原来的String
            rowIndex++;   // row的作用域小，所以要添加一个变量rowIndex
        }
        return true;
    }

    private boolean isSameWord(String a, String b) {
        boolean result = false;
        if (a.length() == b.length()) {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {  // 要用 != 来判断，如果有一个字符不相等，就返回false，不要用 == 来判断
                    return false;
                }
            }
            result = true;
        }
        return result;
    }
}
