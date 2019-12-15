package oaphone.walmart;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeff
 * @version V2.0
 * @date 2019/4/24 17:53
 * 1 2 3 4 S O B 6 7 8 9 C K 5 6 A M N V L (spiral)
 * 1 2 3 4 S O B 6 7 8 9 C K 5 6 A M N V L
 */
public class PrintMatrixII {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '2', '3', '4'},
                {'5', '6', 'A', 'S'},
                {'K', 'L', 'M', 'O'},
                {'C', 'V', 'N', 'B'},
                {'9', '8', '7', '6'}
        };
        int rowInit = 0, rowLen = matrix.length;
        int colInit = 0, colLen = matrix[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        List<Character> result = new ArrayList<>();
        PrintMatrixII printMatrixII = new PrintMatrixII();
        printMatrixII.printMatrixII(matrix, visited, result, rowInit, rowLen, colInit, colLen);
        result.forEach(x -> System.out.print(x+ " "));
    }

    private void printMatrixII(
            char[][] matrix, boolean[][] visited, List<Character> result,
            int rowInit, int rowLen, int colInit, int colLen) {

        for (int j = colInit; j < colLen; j++) {
            int i = rowInit;
            if (!visited[i][j]) {
                result.add(matrix[i][j] );
                visited[i][j] = true;
            }
        }

        for (int i = rowInit; i < rowLen; i++) {
            int j = colLen - 1;
            if (!visited[i][j]) {
                result.add(matrix[i][j]);
                visited[i][j] = true;
            }
        }

        for (int j = colLen - 1; j >= colInit; j--) {
            int i = rowLen - 1;
            if (!visited[i][j]) {
                result.add(matrix[i][j]);
                visited[i][j] = true;
            }
        }

        for (int i = rowLen - 1; i >= rowInit; i--) {
            int j = colInit;
            if (!visited[i][j]) {
                result.add(matrix[i][j]);
                visited[i][j] = true;
            }
            if (i == 0) {
                // rowLen + 1 和 colLen + 1 写错了，应该是 rowLen - 1 和 colLen - 1
                printMatrixII(matrix, visited, result,
                        rowInit + 1, rowLen - 1,
                        colInit + 1, colLen - 1);
            }
        }
    }

}
