package leetcode.graph;

import java.util.*;
import java.util.stream.Collectors;

public class WordBreak {

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        String s = "abcd";
        List<String> wordDict = Arrays.asList("a", "abc", "b", "cd");
        System.out.println(wb.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = wordDict.stream().collect(Collectors.toSet());
        Map<Key, Boolean> allResults = new HashMap<>();
        return dfs(0, s.length(), s, wordSet, allResults);
    }

    private boolean dfs(int startIndex, int endIndex, String s, Set<String> wordSet, Map<Key, Boolean> allResults) {
        if (allResults.containsKey(new Key(startIndex, endIndex))) {
            return allResults.get(new Key(startIndex, endIndex));
        }

        boolean result = false;
        if (startIndex == endIndex) {
            return true;
        } else {
            for (int i = startIndex; i < endIndex; i++) {
                String newWord = s.substring(startIndex, i + 1);
                if (wordSet.contains(newWord)) {
                    result = dfs(i + 1, endIndex, s, wordSet, allResults);
                }
            }
        }
        allResults.put(new Key(startIndex, endIndex), result);
        return result;
    }

    private class Key {
        int _startIndex;
        int _endIndex;
        public Key (int startIndex, int endIndex) {
            _startIndex = startIndex;
            _endIndex = endIndex;
        }
        @Override
        public boolean equals (Object that) {
            return that != null && that instanceof Key
                    && ((Key)that)._startIndex == _startIndex && ((Key)that)._endIndex == _endIndex;
        }

        @Override
        public int hashCode () {
            return 31 * _startIndex + _endIndex;
        }
    }

}
