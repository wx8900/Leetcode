package leetcode.google.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueensProblem {

    public static void main(String[] args) {
        NQueensProblem np = new NQueensProblem();
        List<List<Integer>> list = np.solveNQueens(4);
        for (List<Integer> outside: list) {
            System.out.println("outside : " + outside);
            /*for (Integer inside: outside) {
                System.out.println(inside);
            }*/
        }
    }

    static boolean[] cols, pos45, neg45;

    public static List<List<Integer>> solveNQueens (int n) {
        cols = new boolean[n];
        pos45 = new boolean[2 * n - 1];
        neg45 = new boolean[2 * n - 1];

        List<List<Integer>> intRes = new ArrayList<>();
        for (int col = 0; col < n; col++) {
            intRes.addAll(helper(0, col, n));
        }
        return intRes;
    }

    private static void updateStatus(int row, int col, int n, boolean b) {
        cols[col] = b;
        pos45[row + col] = b;
        neg45[row - col + n - 1] = b;
    }

    private static List<List<Integer>> helper(int row, int col, int n) {
        List<List<Integer>> res = new ArrayList<>();

        updateStatus(row, col, n, true);

        if (row == n - 1) {
            List<Integer> list = new LinkedList<>();
            list.add(col);
            res.add(list);
        } else {
            int childRow = row + 1;

            for (int childCol = 0; childCol < n; childCol++) {
                if (!cols[childCol] && !pos45[childRow + childCol] && !neg45[childRow - childCol + n - 1]) {
                    List<List<Integer>> childRes = helper(childRow, childCol, n);

                    for (List<Integer> childList : childRes) {
                        childList.add(0, col);
                        res.add(childList);
                    }
                }
             }
        }

        updateStatus(row, col, n, false);

        return res;
    }
}