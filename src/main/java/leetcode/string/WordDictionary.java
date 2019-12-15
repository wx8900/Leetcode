package leetcode.string;

import java.util.*;

public class WordDictionary {
    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        long startTime1 =System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            obj.addWord("addWord");
        }
        long endTime1 =System.currentTimeMillis();
        System.out.println("构建字典运行时间："+(endTime1-startTime1)+" ms !");

        List<String> array = new ArrayList<>();
        for (int i = 0, j = 1; i < 26 && j < 26; i++, j++) {
            array.add((char) (i + 97) + "" + (char) (j + 97));
        }
        System.out.println("输入查询字符串："+ array);

        long startTime2 =System.currentTimeMillis();
        boolean searchResult = false;
        for (int j = 0, len =  array.size() - 1; j < len; j++) {
            for (int i = 0; i < 100000000; i++) {
                searchResult = obj.search(array.get(j));

            }
        }
        long endTime2 =System.currentTimeMillis();
        //查询运行时间：15436 ms
        System.out.println("searchResult ==== " + searchResult + ", 查询运行时间："+(endTime2-startTime2)+" ms !");
    }

    Map<String, Integer> _map = null;
    Set<Integer> _set = null;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        _map = new HashMap<>();
        _set = new HashSet<>();
    }

    /**
     * Adds a word into the data structure.
     */
    /*public void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        if (!_map.containsKey(word)) {
            _map.put(word, word.length());
        }
    }*/
    // save data in Set
    public void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        final int n = word.length();
        if (!_set.contains(n)) {
            _set.add(n);
        }
        if (!_map.containsKey(word)) {
            _map.put(word, n);
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        int index = word.indexOf('.');
        if (index == -1) {
            return _map.containsKey(word);
        } else {
            final int length = word.length();
            if (_set.contains(length)) {
                for (Map.Entry<String, Integer> entry : _map.entrySet()) {
                    Integer keyLength = entry.getValue();
                    if (length == keyLength) {
                        if (isEquals(entry.getKey(), word, length)) {
                            return true;
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            } else {
                return false;
            }
            // for more efficient
            /*if (_map.containsValue(length)) {
                for (String key : _map.keySet()) {
                    if (length == key.length()) {
                        if (isEquals(key, word, length)) {
                            return true;
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            } else {
                return false;
            }*/
        }
        return false;
    }

    private static boolean isEquals(String key, String word, int length) {
        char[] keys = key.toCharArray();
        for (int i = 0; i < length; i++) {
            char ch = word.charAt(i);
            if ('.' == ch) {
                continue;
            }
            if (keys[i] != ch) {
                return false;
            }
        }
        return true;
    }

}