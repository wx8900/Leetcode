package leetcode.facebook;

public class NumberofIslands {

    public static void main(String[] args) {
        NumberofIslands num = new NumberofIslands();
        char[][] grid = new char[5][4];
        grid[0][0] = '1';
        grid[1][0] = '1';
        grid[2][0] = '1';
        grid[3][0] = '1';
        grid[4][0] = '0';
        grid[0][1] = '1';
        grid[1][1] = '1';
        grid[2][1] = '0';
        grid[3][1] = '1';
        grid[4][1] = '0';
        grid[0][2] = '1';
        grid[1][2] = '1';
        grid[2][2] = '0';
        grid[3][2] = '0';
        grid[4][2] = '0';
        grid[0][3] = '0';
        grid[1][3] = '0';
        grid[2][3] = '0';
        grid[3][3] = '0';
        grid[4][3] = '0';
        System.out.println("=======Result======"+num.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return count;
        }

        final int row = grid.length;
        final int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, visited, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col, boolean[][] visited, char[][] grid) {
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;

        // go up
        if (col - 1 >= 0 && grid[row][col - 1] == '1') { // IndexOutOfBoundsException
            dfs(row, col - 1, visited, grid);
        }
        // go down
        if (col + 1 >= 0 && col + 1 < grid[0].length && grid[row][col + 1] == '1') {
            dfs(row, col + 1, visited, grid);
        }
        // go left
        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
            dfs(row - 1, col, visited, grid);
        }
        // go right
        if (row + 1 >= 0 && row + 1 < grid.length && grid[row + 1][col] == '1') {
            dfs(row + 1, col, visited, grid);
        }
    }
}
