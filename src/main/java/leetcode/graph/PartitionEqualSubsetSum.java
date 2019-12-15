package leetcode.graph;

import java.util.HashMap;
import java.util.Map;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        PartitionEqualSubsetSum pe = new PartitionEqualSubsetSum();
        int[] a = new int[]{1,5,11,5};
        System.out.println(pe.canPartition(a));
    }

    public boolean canPartition(int[] a) { // 找两个转换为找一个
        int sum = 0;
        for (int val : a) {
            sum += val;
        }
        if ((sum & 1) == 1) { // 如果所有元素之和是奇数, 没必要走下去, 因为不能出现小数
            return false;
        }

        Map<Key, Boolean> allResults = new HashMap<>();
        return dfs(a, a.length - 1, sum / 2, allResults);
    }

    private boolean dfs(int[] a, int i, int j, Map<Key, Boolean> allResults) {
        if (allResults.containsKey(new Key(i ,j))) {  // DAG永远先判断有没有算过
            return allResults.get(new Key(i ,j));     // 少打了return, 报Time Limit Exceeded
        }

        boolean result = false;

        if (j == 0) { // stop point 找到了.  j == 0 && i == -1, 用到a[i]
            result = true;
        } else if (j < 0) { // stop point
            result = false;
        } else if (i == -1) {  // 走完都找不到
            result = false;
        } else {
            System.out.println("i = "+i+", j = "+j+", a[i] = "+ a[i] +", j - a[i] = " + (j - a[i]));
            result = dfs(a , i - 1, j - a[i], allResults)
                    || dfs(a , i - 1, j, allResults);
            for (Map.Entry entry : allResults.entrySet()) {
                Key keyEntry = (Key)entry.getKey();
                //if (keyEntry._position == 8) {
                System.out.println("i = " + keyEntry._i+" , j = "+ keyEntry._j+" , ===Value=== "+entry.getValue());
                //}
            }
        }
        allResults.put(new Key(i ,j), result);  // 不放进去, 报Time Limit Exceeded
        return result;
    }

    private class Key {
        int _i;
        int _j;
        public Key(int i, int j) {
            _i = i;
            _j = j;
        }

        @Override
        public boolean equals(Object that) {
            return that != null && that instanceof Key
                    && ((Key)that)._i == _i && ((Key)that)._j == _j;
        }
        @Override
        public int hashCode() {
            return 31 * _j + _i;
        }
    }
}
