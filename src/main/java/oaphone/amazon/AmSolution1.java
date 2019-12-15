package oaphone.amazon;

/**
 * 编码教训:
 * 1. 需求上的疑问, 不搞懂, 不开始写代码.
 * 2. 写一行代码, 打印这一行的结果
 * 3. 完成某个结果, 需要做哪几个事情? 纸上多画一画图
 * 4. 把一个功能拆分成几件事或几个步骤, 分别用独立的方法去实现, 不要再一个方法里同时做好几件事, 那样逻辑太复杂太难写.
 * 5. 多Debug, 监控每一个变量值得变化情况.
 * 6. Set后面需要写上类型, 不然放进去char类型('a'), 代码直接当成数字(97)来使用了
 * 7. 循环中修改某个boolean的值, 要在循环的最后一行, 恢复boolean的初始值, 否则boolean为上一次变化后的值就不对了.
 * 8. 警惕“分析瘫痪”。请记住，无论如何都要提前了解整个项目的状况，再去考察其中的细节。由于把握了全局，可快速认识自己未知的一些因素，
 * 防止在考察细节的时候陷入“死逻辑”中。
 * 9. 警惕“过早优化”。首先让它运行起来，再考虑变得更快
 */

/**
 * Amazon OA1 Question 2 :
 * <p>
 * You are working on developing a movie with Amazon Video and want to devise an application to easily break up
 * individual shots (short sequence from a particular camera angle) in a video into screens (a sequence of shots).
 * Each shot is labeled with a letter. There is already an algorithm that breaks the video up into shots and labels them.
 * Write a function which will partition a sequence of shots into minimal sub-sequences so that no shot appears in more than
 * one sub-sequence. The output should be the length of each sub-sequence.
 * 您正在开发与亚马逊视频电影，并想制定一个应用程序，轻松将一个视频的每个情景（特定镜头角度的短序列）分割转换为画面（一系列画面）。
 * 每个情景都标有一个字母。 已经有一个算法把视频分成情景和标签。编写一个功能，将一系列情景划分成最小的子序列，以便不会让同一个情景出现在超过一个
 * 子序列(以便一个情景只出现在一个子序列中,即相同label名字的多条情景记录, 只能归于同一个子序列)。 输出应该是每个子序列的长度.
 * <p>
 * Example 1:
 * inputList = [a, b, c]; //没有反复拍摄，所有镜头都可以在最小长度为1的子序列中
 * output = [1, 1, 1]; // there are no recurring shots, all shots can be in the minimal length 1 sub-sequence.
 * <p>
 * Example 2:
 * inputList = [a, b, c, a];
 * output = [4]; //由于“a”不止一次出现('a'有重复拍摄)，“a”的第一次和最后一次出现之间的所有内容必须位于同一个子序列中。
 * // Because 'a' appears more than once, everything between the first and last appearance of 'a' must be in the same list.
 * <p>
 * Example 3:
 * inputList = [a, b, a, b, c, b, a, c, a, d, e, f, e, g, d, e, h, i, j, h, k, l, i, j];
 * output = [9, 7, 8];
 */

import java.util.*;

public class AmSolution1 {
    public static void main(String[] args) {
        AmSolution1 s = new AmSolution1();
        //List<Character> inputList = new ArrayList<>(Arrays.asList('a', 'b', 'c'));
        //List<Character> inputList = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'a'));

        List<Character> inputList = new ArrayList<>(Arrays.asList('a', 'b', 'a', 'b', 'c', 'b', 'a', 'c', 'a', 'd',
                'e', 'f', 'e', 'g', 'd', 'e', 'h', 'i', 'j', 'h', 'k', 'l', 'i', 'j'));
        /* */
        System.out.println("========= result ==========" + s.lengthEachScene(inputList));
    }

    public List<Integer> lengthEachScene(List<Character> inputList) { // 每个场景的长度
        List<Integer> list = new ArrayList<>(1);
        if (inputList == null || inputList.isEmpty()) {
            return list;
        }

        // 这里的hasDuplicatedChar原来定义在下面求Sum的方法里, 现在定义到这里(另一件事里), 就不用等到遍历完所有的元素, 才知道是否有重复
        final int length = inputList.size();
        Map<Character, List<Integer>> map = getScopeByCharters(inputList, length);

        Set<Character> set = new HashSet<>(map.keySet());
        boolean hasDuplicatedChar = false;
        for (int i = 0; i < length; i++) {
            if (set.contains(inputList.get(i))) {
                hasDuplicatedChar = true;
                break;
            }
        }

        return getSumList(map, hasDuplicatedChar);
    }

    /**
     * Obtain the scopes of individual character
     *
     * @param inputList
     * @param length
     * @return
     */
    private Map<Character, List<Integer>> getScopeByCharters(List<Character> inputList, int length) {
        Map<Character, List<Integer>> map = new LinkedHashMap<>(26);
        List<Integer> arrayList = null;
        for (int i = 0; i < length; i++) {
            char ch = inputList.get(i);
            if (map.containsKey(ch)) {
                List<Integer> val = map.get(ch);
                if (val.get(1) < i) {
                    val.remove(1);
                    val.add(i);
                }
            } else {
                arrayList = new ArrayList<>(2);
                arrayList.add(i);
                arrayList.add(i);
                map.put(ch, arrayList);
            }
        }
        System.out.println("map : ===== " + map);
        return map;
    }

    /**
     * Merge the overlap scopes and calculate sum
     *
     * @param map
     * @param hasDuplicatedChar
     * @return list
     */
    private List<Integer> getSumList(Map<Character, List<Integer>> map, boolean hasDuplicatedChar) {
        List<Integer> resultList = new ArrayList<>(1);
        if (map == null || map.isEmpty()) {
            return resultList;
        }

        int leftMin = 0;  // the min in the left
        int rightMax = 0; // the max in the right
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            //System.out.println("Item : ===== " + entry.getKey() + " === Count : ====" + entry.getValue());
            List<Integer> valueList = entry.getValue();
            int left = valueList.get(0);
            int right = valueList.get(1);

            if (left >= leftMin && right <= rightMax) {// compare scope [], should be 4 type, but this is a sorted list, so only 2 types
                continue;  // the scope of this type is between the last scope, so do nothing
            } else if (left > leftMin && left < rightMax && right > rightMax) {
                rightMax = right; // expand the right boarder (rightMax -> right)
            } else {
                System.out.println("leftMin to rightMax : [" + leftMin + " to " + rightMax + "]");
                resultList.add(rightMax - leftMin + 1); // sum of the scope
                leftMin = left;  // init
                rightMax = right;// init
            }
        }

        System.out.println("leftMin to rightMax : [" + leftMin + " to " + rightMax + "]");
        resultList.add(rightMax - leftMin + 1);

        if (hasDuplicatedChar) {
            resultList = resultList.subList(1, resultList.size());
        }

        return resultList;
    }

    /**
     *    Solution 2 -- from website
     *
     * given list of movie shots represented as chars. partition them so that chars included in each partition not included
     * in any other partition.
     * model shot occurrence window as intervals, and then do interval merge to get non-overlap intervals
     */
    private static class Interval{
        int l;
        int r;
        public Interval(int l, int r){
            this.l = l;
            this.r = r;
        }
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<Integer> lengthEachScene2(List<Character> inputList)
    {
        // WRITE YOUR CODE HERE

        // if no input shot, return empty list
        if(inputList.size() == 0) {
            return new ArrayList<>();
        }

        // find left-most & right-most indexes for each chracter (shot)
        Map<Character, Integer> left = new HashMap<>();
        Map<Character, Integer> right = new HashMap<>();
        for(int i = 0; i < inputList.size(); i++){
            char c = inputList.get(i);
            if(!left.containsKey(c)){
                left.put(c, i);
                right.put(c, i);
            }else{
                right.put(c, i);
            }
        }

        // sort the occurrance window of each character
        PriorityQueue<Interval> q = new PriorityQueue<>((Interval a, Interval b) -> {
            if(a.l != b.l) {
                return a.l - b.l;
            }
            return a.r - b.r;
        });

        for(char c : left.keySet()){
            Interval i = new Interval(left.get(c), right.get(c));
            q.offer(i);
        }

        // if windows have overlap, merge them to get a bigger window, until no overlap among windows.
        // size of each non-overlap window can be added to result
        List<Integer> res = new ArrayList<>();
        int start = q.peek().l;
        int end = q.poll().r;
        while(!q.isEmpty()){
            Interval next = q.poll();
            if(next.l < end){
                end = Math.max(end, next.r);
            }else{
                res.add(end - start + 1);
                start = next.l;
                end = next.r;
            }
        }

        res.add(end - start + 1);
        return res;
    }
}