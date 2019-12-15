package oaphone.amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Jeff 在10/01/2018做的亚马逊OA -- SubstringK
 * 分4种情况讨论：
 *  T: O(n)   n is the length of input string
 */
public class StringK {
    public List<String> subStringKDist(String inputStr, int num) {
        Set<String> resultSet = new HashSet<>();
        if (inputStr.length() < num) {
            return new ArrayList<>();

        }
        int start = 0;
        int[] map = new int[256];    // map<char, index>
        for (int i = 0; i < 256; i++) {
            map[i] = -1;

        }
        for (int i = 0; i < inputStr.length(); i++) {
            if (map[inputStr.charAt(i)] != -1) {
                int newStart = map[inputStr.charAt(i)] + 1;
                for (int j = start; j < newStart; j++) {
                    map[inputStr.charAt(j)] = -1;
                }
                start = newStart;
            } else {
                if (i == start + num - 1) {
                    resultSet.add(inputStr.substring(start, i + 1));
                    map[inputStr.charAt(start++)] = -1;
                }
            }
            map[inputStr.charAt(i)] = i;
        }

        return new ArrayList<>(resultSet);

    }

    public static void main(String[] args){  //knaga
        StringK stringK = new StringK();
        System.out.println(stringK.subStringKDist("awaglknagaaaaaawunagwkwagl", 4));
    }
}