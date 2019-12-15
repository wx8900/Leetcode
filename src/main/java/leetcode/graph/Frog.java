package leetcode.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Frog {
    public static void main(String[] args) {
        Frog fg = new Frog();
        int[] a = new int[]{0, 1, 3, 5, 6, 8, 12, 17};
        long startTime1 =System.currentTimeMillis();
        System.out.println(fg.canCross(a));
        long endTime1 =System.currentTimeMillis();
        System.out.println("运行时间："+(endTime1-startTime1)+" ms !");
    }

    private boolean canCross(int[] a) {
        Set<Integer> positions = Arrays.stream(a).boxed().collect(Collectors.toSet());
        Map<Key, Boolean> allResult = new HashMap<>();
        return dfs(a[0], 1, positions, allResult, a[a.length - 1]);
    }

    private boolean dfs(int position, int jump, Set<Integer> positions, Map<Key, Boolean> allResult, int lastPosition) {
        Key key = new Key(position, jump);
        if (allResult.containsKey(key)) {
            return allResult.get(key);
        }

        boolean result = false;
        if (position == lastPosition) {

            result = true;
        } else {
            int nextPosition = position + jump; // 这里要定义为nextPosition, 不要写nextJump
            if (positions.contains(nextPosition)) { // 下面一行是jump - 1 > 0, 错误写法是 nextJump - 1 > 0
                result = (jump - 1 > 0 && dfs(nextPosition, jump - 1, positions, allResult, lastPosition)
                        || dfs(nextPosition, jump, positions, allResult, lastPosition)
                        || dfs(nextPosition, jump + 1, positions, allResult, lastPosition));
            }
        }
        allResult.put(key, result);

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
        public boolean equals (Object that) {
            return that != null && that instanceof Key
                    && ((Key)that)._position == _position && ((Key)that)._jump == _jump;
        }

        @Override
        public int hashCode () {
            return 31 * _position + _jump;
        }
    }
}
