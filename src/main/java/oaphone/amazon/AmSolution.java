package oaphone.amazon;

/**
 * 编码教训:
 * 1. 需求上不理解的地方, 不用怕, 要多问别人几个问题, 把疑问搞懂为止, 才能开始写代码. 不然不能开始写代码.
 * 2. 写一行代码, 打印这一行的结果
 * 3. 完成某个结果, 需要做哪几个事情? 纸上多画一画图
 * 4. 把这几件事分成单独的方法去实现, 不要同时做好几件事, 那样逻辑太复杂.
 * 5. 多Debug, 监控每一个变量值得变化情况.
 * 6. Set后面需要写上类型, 不然放进去char类型('a'), 代码直接当成数字(97)来使用了
 * 7. 循环中修改某个boolean的值, 要在循环的最后一行, 恢复boolean的初始值, 否则boolean为上一次变化后的值就不对了.
 * 8. 基于效率和类型检查的考虑，应该尽可能使用array，无法确定数组大小时才使用ArrayList.
 * 9. 实际经验表明，实现RandomAccess接口的类实例，假如是随机访问的，使用普通for循环效率将高于使用foreach循环；
 * 反过来，如果是顺序访问的，则使用Iterator会效率更高(顺序访问的那些类实例，使用foreach循环去遍历, 因为foreach循环的底层实现原理就是迭代器Iterator)。
 * 可以使用类似如下的代码作判断
     if (list instanceof RandomAccess) {
        for (int i = 0; i < list.size(); i++){}
     } else {
         Iterator<?> iterator = list.iterable();
         while (iterator.hasNext()){iterator.next()}
     }
 * 10. Map的值放入List, 不用for循环直接用addAll方法,可以提高效率, 而且代码少. 尽量使用System.arraycopy ()代替通过来循环复制数组
 * //for (String key : strMap.keySet()) { // 性能不好
 * //   result.add(key);
 * //}
 * result.addAll(strMap.keySet()); // 性能好
 * <p>
 * Collections.addAll(set1, 2, 4, 8); ArrayList.addAll(xxx); set1.addAll(set2);map1.putAll(map2);
 * <p>
 * List<String> mapKeyList = new ArrayList<String>(map.keySet()); // 将Map Key 转化为List
 * Set<String> mapKeySet = map.keySet();  // 将Map 的键转化为Set
 * <p>
 * Set<String> set = new HashSet<String>(Arrays.asList(arr));  //数组-->Set
 * String[] arr = new String[set.size()];
 * set.toArray(arr); //Set-->数组
 * <p>
 * Set<String> listSet = new HashSet<String>(list);    //List-->Set
 * List<String> setList = new ArrayList<String>(set);  //Set --> List
 * <p>
 * Object[] objects = list.toArray();// List-->数组, 返回Object数组
 * <p>
 * String[] arr = new String[list.size()];
 * list.toArray(arr);//将转化后的数组放入已经创建好的对象中
 * <p>
 * String[] ss = {"JJ","KK"};
 * List<String> list1 = Arrays.asList(ss);  //数组-->List
 */

/**
 * Amazon OA1 Question 1 :
 * Michelle has created a word game for her students. The word game begins with Michelle writing a string
 * and a number, K, on the board. The students have to find the substrings of size K with K distinct characters.
 * <p>
 * Write an algorithm to help the students find the correct answer. If the given string doesn't have K distinct characters
 * then output an empty list.
 * <p>
 * Output: return distinct substrings of input string of size K with K distinct characters.
 * 0 <= num <= 26, the input string consist of only lowercase letter of English.
 * Substrings are not necessarily distinct.
 */

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.HashSet;

// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class AmSolution {
    public static void main(String[] args) {
        AmSolution s = new AmSolution();
        System.out.println(" ==== result : ==== " + s.subStringsKDist("awaglknagawunagwkwagl", 4));
        // "wagl" is repeated twice, but is included in the output once.
        //Output: [wagl, aglk, glkn, lkna, knag, gawu, awun, wuna, unag, nagw, agwk, kwag]
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> subStringsKDist(String inputStr, int num) {
        // WRITE YOUR CODE HERE
        List<String> result = new ArrayList<>(1);
        if (inputStr == null || inputStr.length() == 0 || inputStr.length() < num) {
            return result;
        }

        boolean noneDuplicated = true;
        final int len = inputStr.length();
        Set<Character> set = null;
        Map<String, String> strMap = new LinkedHashMap<>(len);

        for (int i = 0, length = len - num; i <= length; i++) {
            String token = inputStr.substring(i, i + num);
            set = new HashSet<>(num); // must add Character type, otherwise code consider as 97
            for (int j = 0; j < num; j++) {
                char ch = token.charAt(j);
                if (set.contains(ch)) {
                    noneDuplicated = false;
                    break;
                } else {
                    set.add(ch);
                }
            }
            if (noneDuplicated) {
                strMap.put(token, token);
            }
            noneDuplicated = true; // reset here is important!!!
        }

        result.addAll(strMap.keySet());

        return result;
    }
    // METHOD SIGNATURE ENDS
}
//  ==== result : ==== [wagl, aglk, glkn, lkna, knag, gawu, awun, wuna, unag, nagw, agwk, kwag]
