package leetcode.graph;

import java.util.*;

public class WordBreakII {

    public static void main(String[] args) {
        WordBreakII wb = new WordBreakII();
        List<String> result = new ArrayList<>();
        String s = "catsanddog";
        final int n = s.length();
        String[] dictList = {"cat", "cats", "and", "sand", "dog"};
        Set<String> wordDict = new HashSet<>(Arrays.asList(dictList));
        List<String> list = wb.wordBreak(s, n, 0, wordDict, result);
        for (String str: list) {
            System.out.println("====="+str);
        }

    }

    public List<String> wordBreak(String s, int length, int wordLengthSum, Set<String> wordDict, List<String> result) {
        List<String> tempList = new ArrayList<>();
        int j = 0;
        int start = 0;

        for (int i = 0; i < length; i ++) {
            String newWord = s.substring(start, start + j);
            if (wordDict.contains(newWord)) {
                start = i + 1;
                j = 0;
                int newLength = newWord.length();
                tempList.addAll(wordBreak(s.substring(start + j), newLength,length - newLength, wordDict, result));
                wordLengthSum += newWord.length();

            }
            j++;
        }

        if (length == wordLengthSum) {
            result.addAll(tempList);
        }

        return result;
    }

    /*public List<String> wordBreak(String s, int length, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        int j = 0;
        int start = 0;
        int wordLengthSum = 0;

        for (int i = 0; i < length; i ++) {
            j++;
            String newWord = s.substring(start, start + j);
            if (wordDict.contains(newWord)) {
                start = i + 1;
                j = 0;
                tempList.add(newWord);
                wordLengthSum += newWord.length();
            }
        }

        if (length == wordLengthSum) {
            result.addAll(tempList);
        }

        return result;
    }*/
}
