package oaphone.microsoft;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class draws a bar chart
 *
 * @author Jeff
 * @version V1.0
 * @date 5/13/19 23:26
 */
public class Test {
    public static void main(String[] args) {
        Map<Character, Set> map = new HashMap<>();
        Set set = new HashSet<>();
        set.add('B');
        set.add('C');
        map.put('A', set);
        set = new HashSet<>();
        set.add('C');
        set.add('D');
        map.put('B', set);
        set = new HashSet<>();
        set.add('C');
        map.put('D', set);
        char[] array = new char[]{'A', 'B', 'C', 'D'};
        //printDependency(array, map);
    }

    /*public static void printDependency(char[] array, Map<Character, Set> map) {
        int[] count = new int[array.length];
        int i = 0;
        char first;
        for (Map.Entry<Character, Set> entry : map.entrySet()) {
            Set value = entry.getValue();
            int size = value.size();
            count[i] = size;
            if(size == 0) {
                first = 
            }
            i++;
        }
        for (Map.Entry<Character, Set> entry : map.entrySet()) {
            Set value = entry.getValue();

        }

    }*/

}
