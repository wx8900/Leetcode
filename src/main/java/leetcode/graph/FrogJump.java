package leetcode.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FrogJump {
    public static void main(String[] args) {
        FrogJump fg = new FrogJump();
        int[] a = new int[]{0, 1, 3, 5, 6, 8, 12, 17};
        long startTime1 =System.currentTimeMillis();
        System.out.println(fg.canCross(a));
        long endTime1 =System.currentTimeMillis();
        System.out.println("运行时间："+(endTime1-startTime1)+" ms !");
    }

    private boolean canCross(int[] a) {
        Set<Integer> positions = Arrays.stream(a).boxed().collect(Collectors.toSet());
        Map<Key, Boolean> allResults = new HashMap<>();
        return dfs(a[0],1, positions, allResults, a[a.length - 1]);
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

        for (Map.Entry entry : allResults.entrySet()) {
            Key keyEntry = (Key)entry.getKey();
            //if (keyEntry._position == 8) {
                System.out.println("position == " + keyEntry._position+" , jump == "+ keyEntry._jump+" , ===Value=== "+entry.getValue());
            //}
        }
        System.out.println("====== allResult.size() ====== " + allResults.size());
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