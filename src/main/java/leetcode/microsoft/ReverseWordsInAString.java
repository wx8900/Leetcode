package leetcode.microsoft;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        ReverseWordsInAString reverse = new ReverseWordsInAString();
        String str = "Seattle has   lot   snow";
        System.out.println(reverse.reverseWords(str));
    }

    public int reverseWords(String s) {
        int n = s.trim().length();
        int switchFlag = 0;
        int index = 0;
        int numberOfWords = 0;
        char[] oldArray = s.toCharArray();
        for (int i = 0; i < oldArray.length; i++) {
            if (oldArray[i] != ' ') {
                switchFlag++;
                if (numberOfWords > 0) {
                    numberOfWords = 1;
                    switchFlag++;

                }
            } else {
                numberOfWords++;
                if (switchFlag > 0) {
                    switchFlag = 1;
                    numberOfWords++;
                }
            }
        }
        return switchFlag;

        /*char[] newArray = new char[n - ];
        for (int i = n - 1; i > 0; i--) {
            char cur = oldArray[i];
            if (cur == ' ') {
                //index--;
            } else {
                newArray[index] = cur;
                index++;
            }
        }
        return String.valueOf(newArray);*/
    }
}
