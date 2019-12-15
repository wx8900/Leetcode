package oaphone.walmart;
import java.util.*;
/**
 * @author Jeff
 * @version V1.0
 * @date 2019/4/24 23:16
 */
public class ReplaceChar {
    public static void main(String[] args) {
        String s = "ABCD";
        List<String> list = new ArrayList<>();
        helper(list, s.charAt(0)+"", 0, 0, s.substring(1, s.length()),false);
        for(String ss : list){
            System.out.println(ss);
        }
    }

    public static void helper(List<String> list, String s, int num,
                              int step,  String string, boolean isValid){ // 保证最后一位是否为字符
        if(step == string.length()) { // step 每生产一个结果就是一步
            if(isValid){
                list.add(s);
            }
            return ;
        }
        helper(list, s, num+1, step+1, string, false); // 中间数字
        helper(list, s +(num!=0?num+"":"")+ string.charAt(step), 0, step+1,  string, true); // 中间数字和字符混合
    }





}
