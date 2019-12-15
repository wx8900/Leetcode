package leetcode.facebook;

import java.util.Random;

public class RadomTest {
    public static void main(String[] args) {
        System.out.println(getRandomString(100));

    }

    private static String getRandomString(int length) {
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();

        StringBuffer sb = new StringBuffer();
        for(int i = 0;i< length; i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
