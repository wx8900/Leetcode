package oaphone.indigoslate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jeff
 * @version V1.0
 * @description
 * @date 2019/3/30 00:25
 *
 * getBoldRanges( "BANANARANA-A-GOGO", ["ANA", "GO"] )
 * Might return:  [[1,5], [7,9], [13,16]]
 */
public class BoldRanges {
    public static void main(String[] args) {
        BoldRanges boldRanges = new BoldRanges();
        String inputString = "BANANARANA-A-GOGO";
        List<String> targetList = Arrays.asList("ANA", "GO");
        List<List<Integer>> res = boldRanges.getBoldRanges(inputString, targetList);
        for (int i = 0; i < res.size(); i++) {
            List<Integer> list = res.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.println("====>" + list.get(j));
            }
        }
    }

    public List<List<Integer>> getBoldRanges(String inputString, List<String> targetList){
        List<List<Integer>> result = new ArrayList<>();
        int[] temp = new int[inputString.length()];
        Arrays.fill(temp, 0);
        int indexI = 0, indexT = 0;
        int index;
        String tString = "";

        for (int i = 0, tSize = targetList.size(); i < tSize; i++) {
            tString = targetList.get(0); // test: fixed value
        }
        int len = inputString.length();
        for (; indexI < len; indexI++) {
            char cT = getTargetCharacter(tString, indexT);
            char cI = getInputCharacter(inputString, indexI);
            if (cT == cI) {
                temp[indexI] = 1;
                if (indexI < len) {
                    index = findMaxIndex(inputString, tString, indexI + 1, indexT + 1);
                    for (int i = indexI; i <= index; i++) {
                        temp[i] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " , ");
        }
        return result;
    }

    private int findMaxIndex(String inputString, String tString, int indexI, int indexT) {
        int index = -1;
        int tLength = tString.length();
        int count = 0;
        for (; count < tLength; indexI++) {
            char cI = inputString.charAt(indexI);
            char cT = getTargetCharacter(tString, indexT);
            if (cI == cT) {
                index = indexI;
                if (index < tLength) {
                    // 光写findMaxIndex是不能把最后一个值返回出来的，所以要写index = findMaxIndex(...)
                    index = findMaxIndex(inputString, tString, indexI + 1, indexT + 1);
                }
            }
            count++;
        }
        return index;
    }

    public char getInputCharacter(String inputString, int index) {
        char[] arrayI = inputString.toCharArray();
        return arrayI[index];
    }

    public char getTargetCharacter(String targetString, int index) {
        char[] arrayT = targetString.toCharArray();
        return arrayT[index];
    }

}
