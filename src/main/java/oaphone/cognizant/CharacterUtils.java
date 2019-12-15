package oaphone.cognizant;

import java.util.Arrays;

/**
 * @author Jeff
 * @date 03/21/2019 4 - 5 PM
 * @apiNote  Skype interview
 */
public class CharacterUtils {
    public static void main(String[] args) {
        CharacterUtils characterTest = new CharacterUtils();
        boolean result1 = characterTest.hasRepeatedEnglishChar("welcome");
        boolean result2 = characterTest.hasRepeatedASCIIChar("12!a#f,57 !");
        System.out.println("The result of English string is " + result1);
        System.out.println("The result of ASCII string is " + result2);
    }

    /**
     * Assumption: input String only contains 26 lowercase letters
     *
     * @param str
     * @return
     */
    public boolean hasRepeatedEnglishChar(String str) {
        // check null or ""
        if (str == null || str.length() == 0) {
            return false;
        }
        int[] array = new int[26];
        for (char ch : str.toCharArray()) {
            array[ch - 'a']++;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Assumption: input String only contains all 256 ASCII char which contains , ? % # ....
     *
     * @param str
     * @return
     */
    public boolean hasRepeatedASCIIChar(String str) {
        int MAX_SIZE = 256;
        if (str == null || str.length() == 0 || str.length() > MAX_SIZE) {
            return false;
        }
        boolean[] chars = new boolean[MAX_SIZE];
        // init
        Arrays.fill(chars, false);
        for (int i = 0; i < str.length(); i++) {
            int index = (int) str.charAt(i);
            if (chars[index] == true) {
                return true;
            }
            chars[index] = true;
        }
        return false;
    }

}
