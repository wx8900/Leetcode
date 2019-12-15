package mock.xcode.google;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 *  09/29/2018 Xcode Mock Interview 第3期第2场    Google: 设计实现一个类似模糊搜索的搜索文件的接口
 *
 * 1. Some IDEs let you type a non-contiguous substring of the file name in
 * order to search and open a file. Write a method that takes a pattern and a
 * filename and returns whether or not the pattern is a non-contiguous substring
 * of the filename. For instance, pattern "Mav" is a non-contiguous substring of
 * "MyJavaClass.java". “MM” is not.
 * <p>
 * 2.Usually the IDE will let you type and when you pause, it will display the
 * current list of matches. Pretend you're working on a team for this feature.
 * Someone else is in charge of UI and collecting the current pattern whenever
 * the user pauses. Write a utility that will take the pattern and return a list
 * of the current matches. For example, if the user input is:
 * Ma<pause>v<pause>a<pause> 1st call: “Ma” 2nd call: “Mav” 3rd call: “Mava”
 */
/** File Names：
 MyJavaClass
 MMYTsa
 YMYVZ
 MssAVt
 yMVAAVZYM

 Example 1：
 input -> results
 MA -> MyJavaClass (y), MMYTsa(M), MssAVt(s), yMVAAVZYM
 MAV -> MyJavaClass, MssAVt, yMVAAVZYM
 MAVA -> MyJavaClass, yMVAAVZYM
 */
// getAllFiles() => Iterable<String>
// foo.bar => fo =>
// List<String> files  => result
public class MatchInCache {

    List<String> files = new ArrayList<>();

    private Iterable<String> getAllFiles() {
        return files;
    }

    // 1. foo.bar => fo => list of matching files => foo. => ffooo => ffoo / ffo / ff
    private Map<String, List<String>> cache;

    public List<String> getFiles(String pattern) {
        List<String> files = this.cache.get(pattern);

        // 1. if already matched
        if (files != null) {
            return files;
        }

        // 2. if not searched, already result like foo.bar ffoooo.bar foo.b
        List<String> res;
        // abcd
        //    |
        // abc
        for(int i = pattern.length() - 1; i > 0; i--) {
            String pre = pattern.substring(0, i);
            List<String> l = this.cache.get(pre);
            if(l != null) {
                res = getSubsets(l, pattern.substring(i));
                cache.put(pattern, res);
            }
        }

        // 3. All cache missed => put the search re cache
        res = allCacheMiss(pattern);
        cache.put(pattern, res);
        return res;
    }

    private List<String> getSubsets(List<String> l, String pattern){
        List<String> res = new ArrayList<>();

        for (String file: l) {
//            if(isSubsequence(String s, String t)) {
//
//            }
        }
        return new ArrayList<>();
    }

    private List<String> allCacheMiss(String pattern) {
        Iterator<String> iterator = getAllFiles().iterator();
        List<String> res = new ArrayList<>();

//        while(iterator) {
//
//        }
        return new ArrayList<>();
    }

}
