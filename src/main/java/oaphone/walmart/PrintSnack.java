package oaphone.walmart;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeff
 * @version V1.0
 * @date 2019/4/24 16:39
 * 1 2 3 4 S A 6 5 K L M O B N V C 9 8 7 6 (snake)
 * 1 2 3 4 S A 6 5 K L M O B N V C 9 8 7 6
 */
public class PrintSnack {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '2', '3', '4'},
                {'5', '6', 'A', 'S'},
                {'K', 'L', 'M', 'O'},
                {'C', 'V', 'N', 'B'},
                {'9', '8', '7', '6'}
        };
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        List<Character> result = new ArrayList<>();
        PrintSnack ps = new PrintSnack();
        List<Character> list = ps.printSnake(matrix,
                result, 0, rowLength, 0, colLength);
        list.forEach(x -> System.out.print(x + " "));
    }

    private List<Character> printSnake(
            char[][] matrix, List<Character> result,
            int rowInit, int rowLength, int colInit, int colLength) {
        for (int i = 0; i < rowLength; i++) {
            if (i % 2 == 0) {  // left to right
                for (int j = colInit; j < colLength; j++) {
                    result.add(matrix[i][j]);
                }
            } else { // right to left
                for (int j = colLength - 1; j >= colInit; j--) {
                    result.add(matrix[i][j]);
                }
            }
        }
        return result;
    }

}
