package onsite.microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeff
 * @version V2.0
 * @description
 * @date 2019/3/29 21:40        Chat Robats Team
 * <p>
 * 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10
 * 1  2  3  4  8  12  16  15  14  13  9  5  6  7  11  10
 */
public class PrintMatrix {

    static boolean[][] visited;

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        visited = new boolean[rowLength][colLength];
        List<Integer> result = new ArrayList<>();
        PrintMatrix pm = new PrintMatrix();
        List<Integer> list = pm.printNumberInMatrix(matrix, visited,
                result, 0, rowLength, 0, colLength);
        list.forEach(x -> System.out.print(x + " "));
    }

    private List<Integer> printNumberInMatrix(
            int[][] matrix, boolean[][] visited, List<Integer> result,
            int rowInit, int rowLength, int colInit, int colLength) {

        // left to right
        for (int j = colInit; j < colLength; j++) {
            if (!visited[colInit][j]) {
                result.add(matrix[colInit][j]);
                visited[colInit][j] = true;
            }
        }

        // up to down
        for (int i = rowInit; i < rowLength; i++) {
            if (!visited[i][rowLength - 1]) {
                result.add(matrix[i][rowLength - 1]);
                visited[i][rowLength - 1] = true;
            }
        }

        // right to left
        for (int j = colLength - 1; j >= colInit; j--) {
            if (!visited[colLength - 1][j]) {
                result.add(matrix[colLength - 1][j]);
                visited[colLength - 1][j] = true;
            }
        }

        // down to up
        for (int i = rowLength - 1; i >= rowInit; i--) {
            if (!visited[i][rowInit]) {
                result.add(matrix[i][rowInit]);
                visited[i][rowInit] = true;
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
