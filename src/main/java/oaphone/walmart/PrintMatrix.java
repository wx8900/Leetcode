package oaphone.walmart;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeff
 * @version V1.0
 * @date 2019/4/24 15:50
 * Input:
    1 2 3 4
    5 6 A S
    K L M O
    C V N B
    9 8 7 6
Output:A
    1 2 3 4 S O B 6 7 8 9 C K 5 6 A M N V L (spiral)
    1 2 3 4 S O B 6 7 8 9 C K 5 6 A M N V L
 */
public class PrintMatrix {

    static boolean[][] visited;

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
        visited = new boolean[rowLength][colLength];
        List<Character> result = new ArrayList<>();
        PrintMatrix pm = new PrintMatrix();
        List<Character> list2 = pm.printNumberInMatrix(matrix, visited,
                result, 0, rowLength, 0, colLength);
        list2.forEach(x -> System.out.print(x + " "));
    }

    private List<Character> printNumberInMatrix(
            char[][] matrix, boolean[][] visited, List<Character> result,
            int rowInit, int rowLength, int colInit, int colLength) {
        // left to right
        for (int j = colInit; j < colLength; j++) {
            int i = colInit;
            if (!visited[i][j]) {
                result.add(matrix[i][j]);
                visited[i][j] = true;
            }
        }
        // up to down
        for (int i = rowInit; i < rowLength; i++) {
            int j = colLength - 1;
            if (!visited[i][j]) {
                result.add(matrix[i][j]);
                visited[i][j] = true;
            }
        }
        // right to left
        for (int j = colLength - 1; j >= 0; j--) {
            int i = rowLength - 1;
            if (!visited[i][j]) {
                result.add(matrix[i][j]);
                visited[i][j] = true;
            }
        }
        // down to up
        for (int i = rowLength - 1; i >= rowInit; i--) {
            int j = rowInit;
            if (!visited[i][j]) {
                result.add(matrix[i][j]);
                visited[i][j] = true;
            }
            if (i == 0) {
                printNumberInMatrix(matrix, visited, result,
                        rowInit + 1, rowLength - 1,
                        colInit + 1, colLength - 1);
            }
        }
        return result;
    }
}