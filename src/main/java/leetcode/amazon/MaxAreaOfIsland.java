package leetcode.amazon;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        MaxAreaOfIsland num = new MaxAreaOfIsland();
        int[][] grid = new int[5][4];
        grid[0][0] = 1;
        grid[1][0] = 1;
        grid[2][0] = 0;
        grid[3][0] = 0;
        grid[4][0] = 0;
        grid[0][1] = 1;
        grid[1][1] = 1;
        grid[2][1] = 0;
        grid[3][1] = 0;
        grid[4][1] = 0;
        grid[0][2] = 0;
        grid[1][2] = 0;
        grid[2][2] = 0;
        grid[3][2] = 1;
        grid[4][2] = 1;
        grid[0][3] = 0;
        grid[1][3] = 0;
        grid[2][3] = 0;
        grid[3][3] = 1;
        grid[4][3] = 1;
        System.out.println("=======Result======"+num.maxAreaOfIsland(grid));
    }


    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int sum = 0;
        final int n = grid.length;
        final int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    //System.out.println(dfs(i, j, grid));
                    sum = Math.max(sum, dfs(i, j, visited, grid));
                }
            }
        }
        return sum;
    }

    private int dfs(int row, int col, boolean[][] visited, int[][] grid) {
        if (visited[row][col]) {
            return 0;
        }
        visited[row][col] = true;
        int result = 1;

        if (row + 1 < grid.length && grid[row + 1][col] == 1) { // right
            result += dfs(row + 1, col, visited, grid);
        }
        if (row - 1 >= 0 && grid[row - 1][col] == 1) { // left
            result += dfs(row - 1, col, visited, grid);
        }
        if (col - 1 >= 0 && grid[row][col - 1] == 1) { // up
            result += dfs(row, col - 1, visited, grid);
        }
        if (col + 1 < grid[0].length && grid[row][col + 1] == 1) { // down
            result += dfs(row, col + 1, visited, grid);
        }

        return result;
    }

//    private int dfs2(int i, int j, int[][] grid) {
//        int result = 0;
//        if ((i < 0 || i >= grid.length)
//                || (j < 0 || j >= grid[0].length)
//                || (grid[i][j] != 1)) {
//            return 0;
//        }
//        grid[i][j] = 2;
//
//        // up
//        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
//            result += dfs(i, j - 1, grid);
//        }
//        // down
//        if (j + 1 < grid.length && grid[i][j + 1] == 1) {
//            result += dfs(i, j + 1, grid);
//        }
//        // left
//        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
//            result += dfs(i - 1, j, grid);
//        }
//        // right
//        if (i + 1 < grid[0].length && grid[i + 1][j] == 1) {
//            result += dfs(i + 1, j, grid);
//        }
//        System.out.println("dfs : " + dfs(i, j, grid));
//        System.out.println("result : " + result);
//
//        return result;
//    }
}
