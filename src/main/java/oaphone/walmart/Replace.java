package oaphone.walmart;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jeff
 * @version V1.0
 * @date 2019/4/25 12:02
 */
public class Replace {
    public static void main(String[] args) {
        String json = "{\"home\": \"Shanghai\", \"salary\": 50000}";
        //language=RegExp
        String regex = "[1-9]*";
        String s = "ABCDE";
        List<String> list = new ArrayList();
        replace(list, s.charAt(0)+"", 0, 0, s.substring(1, s.length()), false);
        list.forEach(x -> System.out.println(x));
    }

    private static void replace(List<String> list, String s, int num, int step, String string, boolean isValid) {
        if(step == string.length()) {
            if(isValid) {
                list.add(s);
            }
            return;
        }
        replace(list, s, num + 1, step + 1, string, false);
        replace(list, s+(num!=0?num+"":"")+string.charAt(step), 0, step + 1, string, true);
    }

}
