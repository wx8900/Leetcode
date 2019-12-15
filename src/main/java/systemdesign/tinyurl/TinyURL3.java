package systemdesign.tinyurl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TinyURL3 {

    public static void main(String[] args) {
        TinyURL3 tiny = new TinyURL3();
        String originLongURL = "http://tiny.url/12356423/00ds043-vd(abfty2$#*(^ababarty1";
        String shortURL =  tiny.longToShort(originLongURL);
        String longURL = tiny.shortToLong(shortURL);
        System.out.println("originLongURL : " + originLongURL);
        System.out.println("shortURL      : " + shortURL);
        System.out.println("longURL       : " + longURL);
    }

    private Map<String, String> short2Long = new HashMap<>();
    private Map<String, String> long2Short  = new HashMap<>();

    public String longToShort(String url) {
        if (long2Short.containsKey(url)) {
            return long2Short.get(url);
        }
        while (true) {
            String shortURL = createShortURL(url);
            if (!short2Long.containsKey(shortURL)) {
                short2Long.put(shortURL, url);
                long2Short.put(url, shortURL);
                return shortURL;
            }
        }
    }

    public String shortToLong (String url) {
        if (!short2Long.containsKey(url)) {
            return null;
        }
        return short2Long.get(url);
    }

    private String createShortURL (String url) {
        String shortURL = "http://tiny.url/";
        String scopeChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random ran = new Random();
        for (int i =0; i < 6; i++) {
            int index = ran.nextInt(62);
            shortURL += scopeChars.charAt(index); //chartAt 方法名拼写错误
        }
        return shortURL;
    }

}

