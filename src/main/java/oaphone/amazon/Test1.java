package oaphone.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName     Test1
 * @Description   Do Amazon OA
 * @Author        Jeff
 * @Date          2019/3/24 19:19
 * @Version       V1.0
 */
public class Test1 {
    public static void main(String[] args) {
        Test1 t = new Test1();
        System.out.println("=============Question 1==================");
        List<Integer> files = Arrays.asList(8, 4, 6, 12);
        System.out.println(t.minimumTime(4, files));
        System.out.println("=============Question 2==================");
        List<Character> list = Arrays.asList('z', 'z',
                'c', 'b', 'z', 'c', 'h', 'f', 'i', 'h', 'i');
        System.out.println(t.lengthSubsequenceShoppers(list));
    }

    /**
     * 如果选Array做数据结构，长度是死的，不能删除2个元素，再加入一个元素，每次加入后都要排序一次，太耗时间，所以选PriorityQueue自动排序
     * @param numOfSubFiles
     * @param files
     * @return
     */
    private int minimumTime(int numOfSubFiles, List<Integer> files) {
        int result = 0;
        if (files == null || files.size() == 0) {
            return result;
        }
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i = 0; i < files.size(); i++) {
            pq.add(files.get(i));
        }
        while (pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();
            int time = first + second;
            pq.add(time);
            result += time;
        }
        return result;
    }

    /**
     * Shoppers
     */
    private List<Integer> lengthSubsequenceShoppers(List<Character> inputList) {
        List<Integer> ans = new ArrayList<>();
        if (inputList == null || inputList.size() == 0) {
            return ans;
        }
        int[] table = new int[26];
        int listSize = inputList.size();
        for (int i = 0; i < listSize; i++) {
            table[inputList.get(i) - 'a'] = i;
        }
        int curMax = 0, count = 0;
        for (int i = 0; i < listSize; i++) {
            char c = inputList.get(i);
            curMax = Math.max(table[c - 'a'], curMax);
            count++;
            if (i == curMax) {
                ans.add(count);
                count = 0;
            }
        }
        return ans;
    }
}
