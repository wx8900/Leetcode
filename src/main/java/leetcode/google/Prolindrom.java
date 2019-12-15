package leetcode.google;

public class Prolindrom {

    public static void main(String[] str) {
        Prolindrom p = new Prolindrom();
        System.out.println(p.findPair( "abba"));

    }

    /**
     *  String : "abba"   ==> true
     *
     *  "abc"  ===> false
     *
     *  "A man, a plan, a canal: Panama"
     *
     *  "AmanaplanacanalPanama"
     *
     */

    private boolean findPair(String str){
        if (str == null || str.length() == 0) {
            return false;
        }
        boolean result = false;

        String temp = str.replaceAll(" ", "").replaceAll(", ", "")
                .replaceAll(": ","");

        int start = 0;
        int end = temp.length() - 1;
        while(start < end) {
            if (temp.charAt(start) != temp.charAt(end)) {
                result = false;
            }
            start++;
            end--;
        }
        if(start >= end) {
            result = true;
        }

        return result;
    }
}
