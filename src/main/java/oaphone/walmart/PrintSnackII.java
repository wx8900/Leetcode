package oaphone.walmart;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeff
 * @version V2.0
 * @date 2019/4/24 17:47
 * 1 2 3 4 S A 6 5 K L M O B N V C 9 8 7 6 (snake)
 * 1 2 3 4 S A 6 5 K L M O B N V C 9 8 7 6
 *
 */
public class PrintSnackII {

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '2', '3', '4'},
                {'5', '6', 'A', 'S'},
                {'K', 'L', 'M', 'O'},
                {'C', 'V', 'N', 'B'},
                {'9', '8', '7', '6'}
        };
        PrintSnackII printSnackII = new PrintSnackII();
        List<Character> result = printSnackII.printSanckII(matrix);
        result.forEach(x -> System.out.print(x));
    }

    private List<Character> printSanckII(char[][] matrix) {
        List<Character> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    res.add(matrix[i][j]);
                }
            } else {
                for (int j = matrix[0].length - 1; j >= 0; j--) {
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }

}
