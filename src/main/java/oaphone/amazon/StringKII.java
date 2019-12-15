package oaphone.amazon;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 教训：类名字打错，链接运行的是旧的类，得到正确的答案，以为自己的代码没有问题，结果自己的代码有Bug，有2个情况没有考虑到，没做处理
 * 教训：在写完代码后，测试时发现连续3个字母相同的字符串，返回值包含有一个字符出现多次的字符串，不符合题意，调试了2小时没找出错误
 *      先判断可能产生错误代码的行数。然后在纸上把这部分的逻辑再从0推导一遍
 * 总结：在自己写的老代码上debug了1个小时，还是没有找出Bug。==》建议备份老代码，从0开始，在纸上分类讨论，重新推导一遍逻辑，重新写一遍代码
 *
 * 10/4/2018  重新推导，新写一遍代码
 *  1. 未满K位
 *     1.1 无重复字符
 *         freq[end - 'a']++;
 *     1.2 有重复字符
 *         start++;
 *  2. 满了K位
 *     2.1 无重复字符
 *     freq[end - 'a']++; set.add(substring); K中最左边的一位字符（即start）的freq--；
 *     2.2 有重复字符
 *         从索引start开始，向右循环，直到freq[start - 'a'] == 0
 *         并且，所有start移动过位置上字符的freq--；
 *         start++;
 *  最后，发现1.1和2.1部分代码一样，==》可以合并；发现1.2和2.2部分代码一样，==》可以合并
 */
public class StringKII {
    private List<String> substringKDist(String input, int k) {
        int start = 0, end = 0;
        int[] freq = new int[26];
        final int len = input.length();
        Set<String> set = new HashSet<>();

        for (; end < len; end++) {
            char e = input.charAt(end);
            if (freq[e - 'a'] == 0) { // 无重复字符
                freq[e - 'a']++;
            } else {  // 有重复字符
                char s = input.charAt(start);
                if (s == e) { // 新发现的Bug地方：连续出现多个相同字符的情况：如果进入的字符和前一位字符一样，则不降低该字符的频率,直接start++
                    start++;
                } else {
                    while (freq[e - 'a'] > 0) { // 当end遇到freq有重复字符，从索引start开始，向右循环，直到freq[start - 'a'] == 0
                        if (start < len) {
                            char sa = input.charAt(start);
                            //if (sa == e) { // b开头，多个a,还是有Bug：连续出现多个相同字符的情况：如果进入的字符和前一位字符一样，则不降低该字符的频率,直接start++
                            //    start++;
                            //} else {
                                if (freq[sa - 'a'] > 0) { // 避免freq[s - 'a']减到-1
                                    freq[sa - 'a']--;
                                }
                                start++;
                            //}
                        }
                    }
                }
            }
            if (end - start + 1 == k) { // 字符串长度等于K
                set.add(input.substring(start, end + 1)); // 把该字符串放入Set中，作为结果输出
                char s = input.charAt(start);
                if (freq[s - 'a'] > 0) { // K位的字符串放入Set后，离开进入下一个K位字符串前，K中最左边的一位字符的freq--；
                    freq[s - 'a']--;
                }
                start++;
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args){
        StringKII k2 = new StringKII();
        System.out.println(k2.substringKDist("baaaaawunagwkwagl", 4));
    }
}
