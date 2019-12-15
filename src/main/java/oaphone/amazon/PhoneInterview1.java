package oaphone.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * 2019/06/07  Amazon Bing New team
 *
 Input: [rockstar, rock, star, rocks, tar, star, rockstars, super, highway, high, way, superhighway]
 rockstar
 dict="rockstar"
 Input: [rock, ro, ck, rockstar, star, rocks, tar, star, rockstars]
 Output : [[rock, star], [rocks,tar]]
 // prefix  suffix
 // rock    star
 //recusive
 */
public class PhoneInterview1 {
    static List<List<String>> res = new ArrayList<>();
    /*public static void main(String[] args) {
        PhoneInterview1 p = new PhoneInterview1();
        int index = 0;
        List<String> list = Arrays.asList("rockstar", "rock", "star",
                "rocks", "tar", "star", "rockstars");
        p.recusiveFind(list, "rockstar", 0,
                list.size() - 1, index);
        for (int i = 0; i < res.size(); i++) {
            System.out.println("====="+res.get(i));
        }
    }

    public String recusiveFind(List<String> list, String dict,
                               int start, int end, int index) {
        String word = "";
        if (index == list.size() - 1) {
            return "";
        } else {
            word = list.get(index);
            index++;
            recusiveFind(list, "rockstar", start, end, index);
            if (dict.equals(word + pair)) {
                List<String> list1 = new ArrayList<>();
                list1.add(word);
                list1.add(pair);
                res.add(list1);
            }
        }
        System.out.println("===word=="+word);
        return word;
    }*/

}
