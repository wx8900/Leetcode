package leetcode.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FrogJumpII {
    public static void main(String[] args) {
        FrogJumpII fg = new FrogJumpII();
        int[] a = new int[]{0, 1, 3, 5, 6, 8, 12, 17};
        long startTime1 =System.currentTimeMillis();
        System.out.println(fg.canCross(a));
        long endTime1 =System.currentTimeMillis();
        System.out.println("运行时间："+(endTime1-startTime1)+" ms !");
    }

    public boolean canCross(int[] a) {
        Set<Integer> positions = Arrays.stream(a).boxed().collect(Collectors.toSet());
        Map<Key, Boolean> allResults = new HashMap<>();
        return dfs(a[0], 1, positions, allResults, a[a.length - 1]);//lastPosition实参传有问题, 应传最后一个数组元素
    }

    private boolean dfs(int position, int jump, Set<Integer> positions, Map<Key, Boolean> allResults, int lastPosition) {
        Key key = new Key(position, jump);
        if (allResults.containsKey(key)) {
            return allResults.get(key);
        }

        boolean result = false;

        if (position == lastPosition) {
            result = true;
        } else {
            int nextPosition = position + jump;
            if (positions.contains(nextPosition)) {
                result = (jump - 1 > 0 && dfs(nextPosition, jump - 1, positions, allResults, lastPosition)
                        || dfs(nextPosition, jump, positions, allResults, lastPosition)
                        || dfs(nextPosition, jump + 1, positions, allResults, lastPosition));
            }
        }
        allResults.put(key, result);

        return result;
    }

    private class Key {
        int _position;
        int _jump;
        public Key(int position, int jump) {
            _position = position;
            _jump = jump;
        }

        @Override
        public boolean equals(Object that) {
            return that != null && that instanceof Key
                    && ((Key)that)._position == _position && ((Key)that)._jump == _jump;
        }

        @Override
        public int hashCode() {
            return 31 * _position + _jump;
        }
    }

}