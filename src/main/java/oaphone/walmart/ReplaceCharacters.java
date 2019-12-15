package oaphone.walmart;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeff
 * @version V1.0
 * @date 2019/4/25 11:12
 */
public class ReplaceCharacters {
    public static void main(String[] args) {
        String s = "ABCD";
        List<String> list = new ArrayList<>();
        replace(list, s.charAt(0)+"", 0, 0, s.substring(1, s.length()), false);
        list.forEach(x -> System.out.println(x));
    }

    private static void replace(List<String> list, String s, int num, int step, String string, boolean isValid) {
        if(step == string.length()) { //这里是string，不是s
            if(isValid) {
                list.add(s);
            }
            return;
        }
        replace(list, s, num + 1, step + 1, string, false);
        // 不要忘记了 s+(num!=0?num+"":"")+string.charAt(step)
        replace(list, s+(num!=0?num+"":"")+string.charAt(step), 0, step + 1, string, true);
    }

}
