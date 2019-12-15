package onsite.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1122 {
    public static void main(String[] args) {
        Test1122 s = new Test1122();
        int[] input = new int[3];
        input[0] = 1;
        input[1] = 2;
        input[2] = 2;
        System.out.print(s.subsets(input));
    }

    public List<List<Integer>> subsets(int[] input){
        //your solution there
        if (input == null) {
            return new ArrayList<>();
        }

        Arrays.sort(input);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        result.add(empty);

        int size1 = 0; // point1
        int size2 = 0; // point2
        for(int i = 0; i < input.length; i++) {
            int start = 0;
            if (i == 0 || (i <= input.length - 2 && input[i] != input[i + 1])) {
                start = 0;
            } else {
                start = size2 + 1;
            }
            for (int j = start; j <= size1; j++) {
                List<Integer> newList = new ArrayList<>(result.get(j));
                newList.add(input[i]);
                result.add(newList);
            }
            size2 = size1;
            size1 = result.size() - 1;

        }
        return result;
    }
}
