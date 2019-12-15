package systemdesign.tinyurl;

import java.util.ArrayList;
import java.util.List;

public class Tiny {
    final static int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };

    public static void main(String[] args) {
        //String longURL = "https://leetcode.com/12356423/00ds043-vd&*(*)(*(NNLa2$$543dsfds1"; // good test case
        String longURL = "https://leetcode.com/12356423/00ds043-vd&*(*)(*(NNLa2$$444dsfds1"; // 169664
        int hashCode =  getHashCode(longURL);
        System.out.println("hashCode=========== " + hashCode);
        String tinyURL = getTinyURL(hashCode < 0 ? (-1) * hashCode : hashCode);
        System.out.println("tinyURL : " + tinyURL);
    }

    private static int sizeOfInt(int x) {
        for (int i = 0;; i++)
            if (x <= sizeTable[i])
                return i + 1;
    }

    private static String getTinyURL(int hashCode) {
        if (hashCode == -1) {
            return "input longURL is null or empty!";
        }

        int length = sizeOfInt(hashCode);
        if (length > 10) {
            hashCode = Integer.parseInt(String.valueOf(hashCode).substring(0, 10));
        }
        hashCode = hashCode < 0 ? (-1) * hashCode : hashCode;
        String result = "http://tinyurl.com/";

        String temp = "";
        List<Integer> list = new ArrayList<>();
        int charCount = 0;
        int[] hashCodeArray = new int[]{hashCode, hashCode % 100000000, hashCode % 1000000, hashCode % 10000, hashCode % 100};

        result = getCharacters(result, hashCodeArray);

        for (Integer in : list) {
            temp += String.valueOf(in);
        }

        switch (charCount) {
            case 5 : result += String.valueOf(hashCode % 10); break;
            case 4 : result += temp; break;
            case 3 : result += temp.substring(1); break;
            case 2 : result += temp.substring(2); break;
            case 1 : result += temp.substring(3); break;
            case 0 : result += temp.substring(4); break;
        }

        return result;
    }

    private static String getCharacters(String result, int[] hashCodeArray) {
        for (int i : hashCodeArray) {
            int tempStr = (i < 10) ? (i + 10) : i;
            int num = Integer.parseInt(String.valueOf(tempStr).substring(0, 2));
            if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
                result += String.valueOf((char)num); // 产生一个char
                //charCount++;
            }
            /*else {
                list.add(num); // 产生2个char
            }*/
        }
        return result;
    }

    private static int getHashCode(String longURL) {
        if (longURL == null || longURL.length() == 0) {
            return -1;
        }

        final int random = 31 * 47 * 73;
        return random * longURL.hashCode() * longURL.length();
    }
}
