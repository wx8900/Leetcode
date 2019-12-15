package leetcode.google;

public class Test {

    public static void main(String[] args) {
        String beginWord = "hit";
        for (int i = 0; i < beginWord.length(); i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                String newWord = beginWord.replace(beginWord.charAt(i), j);
                System.out.println("======"+newWord);
            }
        }
    }

}
