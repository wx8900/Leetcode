package leetcode.line;

public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        //System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(vp.isPalindrome("0P"));   // true
        //System.out.println(vp.isPalindrome(".a")); //  false
    }


    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int low = 0;
        int high = s.length() - 1;
        char cLow, cHigh;
        while (low <= high) {
            cLow = s.charAt(low);
            cHigh = s.charAt(high);
            if (!Character.isLetter(cLow)) {
                low++;
                if (s.substring(low).length() == 1) {
                    return false;
                }
            } else if (!Character.isLetter(cHigh)) {
                high--;
                if (s.substring(low, high).length() == 1) {
                    return false;
                }
            } else {
                System.out.println("cLow : "+cLow+", cHigh : "+cHigh);
                if (Character.toLowerCase(cLow) != Character.toLowerCase(cHigh)) {
                    return false;
                }
                low++;
                high--;
            }
        }
        return true;
    }
}
