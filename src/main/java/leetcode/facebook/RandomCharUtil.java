package leetcode.facebook;

import java.util.Random;

public class RandomCharUtil {

    public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String upperLetterChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String lowerLetterChar = "abcdefghijklmnopqrstuvwxyz";
    public static final String numberChar = "0123456789";
    public static final String numberLowerLetterChar = "0123456789abcdefghijklmnopqrstuvwxyz";
    public static final String numberUpperLetterChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static String getValuebyKey() {

        return "";
    }

    //可以指定字符串的某个位置是什么范围的值
    public static String getRandomString2(int length){
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length; i++){
            int number = random.nextInt(3);
            long result;
            switch(number){
                case 0:
                    result=Math.round(Math.random()*25+65);
                    sb.append(String.valueOf((char)result));
                    break;
                case 1:
                    result=Math.round(Math.random()*25+97);
                    sb.append(String.valueOf((char)result));
                    break;
                case 2:
                    sb.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }

        }
        return sb.toString();
    }

    public static String getRandomALLChar(int n) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i = 0; i < n; i++) {
            sb.append( allChar.charAt( random.nextInt( allChar.length() ) ) );
        }
        return sb.toString();
    }

    public static String getRandomLetterChar(int n) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i = 0; i < n; i++) {
            sb.append( letterChar.charAt( random.nextInt( letterChar.length() ) ) );
        }
        return sb.toString();
    }

    public static String getRandomUpperLetterChar(int n) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i = 0; i < n; i++) {
            sb.append( upperLetterChar.charAt( random.nextInt( upperLetterChar.length() ) ) );
        }
        return sb.toString();
    }

    public static String getRandomLowerLetterChar(int n) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i = 0; i < n; i++) {
            sb.append( lowerLetterChar.charAt( random.nextInt( lowerLetterChar.length() ) ) );
        }
        return sb.toString();
    }

    public static String getRandomNumberChar(int n) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i = 0; i < n; i++) {
            sb.append( numberChar.charAt( random.nextInt( numberChar.length() ) ) );
        }
        return sb.toString();
    }

    public static String getRandomNumberLowerLetterChar(int n) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i = 0; i < n; i++) {
            sb.append( numberLowerLetterChar.charAt( random.nextInt( numberLowerLetterChar.length() ) ) );
        }
        return sb.toString();
    }

    public static String getRandomNumberUpperLetterChar(int n) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i = 0; i < n; i++) {
            sb.append( numberUpperLetterChar.charAt( random.nextInt( numberUpperLetterChar.length() ) ) );
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        int k = 4;
        int p = 10;
        System.out.println("---------------------------------------------------全部字符------");
        for(int i = 0; i < k; i++) {
            System.out.println("getRandomAllChar(): " + i + " -------");
            System.out.println(getRandomALLChar(p));
        }

        System.out.println("------------------------------------------------字母字符---------");
        for(int i = 0; i < k; i++) {
            System.out.println("getRandomLetterChar(): " + i + " -------");
            System.out.println(getRandomLetterChar(p));
        }

        System.out.println("-------------------------------------------------大写字母字符--------");
        for(int i = 0; i < k; i++) {
            System.out.println("getRandomUpperLetterChar(): " + i + " -------");
            System.out.println(getRandomUpperLetterChar(p));
        }

        System.out.println("-------------------------------------------------小写字母字符--------");
        for(int i = 0; i < k; i++) {
            System.out.println("getRandomLowerLetterChar(): " + i + " -------");
            System.out.println(getRandomLowerLetterChar(p));
        }

        System.out.println("------------------------------------------------数字字符---------");
        for(int i = 0; i < k; i++) {
            System.out.println("getRandomNumberChar(): " + i + " -------");
            System.out.println(getRandomNumberChar(p));
        }

        System.out.println("-----------------------------------------------数字加大写字母字符----------");
        for(int i = 0; i < k; i++) {
            System.out.println("getRandomNumberUpperLetterChar(): " + i + " -------");
            System.out.println(getRandomNumberUpperLetterChar(p));
        }

        System.out.println("------------------------------------------------数字加小写字母字符---------");
        for(int i = 0; i < k; i++) {
            System.out.println("getRandomNumberLowerLetterChar(): " + i + " -------");
            System.out.println(getRandomNumberLowerLetterChar(p));
        }

        System.out.println("------------------------------------------------getRandomString2---------");
            System.out.println(getRandomString2(100));
    }
}