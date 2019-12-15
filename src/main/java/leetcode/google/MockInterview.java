package leetcode.google;

public class MockInterview {

    public static void main(String[] args) {
        MockInterview mock = new MockInterview();
        int[][] cost = new int[4][6];
        cost[0][0] = 2;
        cost[0][1] = 2;
        cost[0][2] = 1;
        cost[0][3] = 1;
        cost[0][4] = 8;
        cost[0][5] = 4;

        cost[1][0] = 5;
        cost[1][1] = 6;
        cost[1][2] = 3;
        cost[1][3] = 6;
        cost[1][4] = 7;
        cost[1][5] = 5;

        cost[2][0] = 2;
        cost[2][1] = 4;
        cost[2][2] = 1;
        cost[2][3] = 5;
        cost[2][4] = 3;
        cost[2][5] = 9;

        cost[3][0] = 3;
        cost[3][1] = 2;
        cost[3][2] = 3;
        cost[3][3] = 8;
        cost[3][4] = 7;
        cost[3][5] = 4;

        System.out.println(mock.minCost(cost));

    }

    public int minCost(int[][] cost) {
        final int n = cost.length;
        final int m = cost[0].length;
        int minCost = 0;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(!visited[i][j]);
                if (!visited[i][j]) {
                    minCost = Math.min(minCost, dfs(i, j, visited, cost));
                }
            }
        }
        return minCost;
    }

    private int dfs(int i, int j, boolean[][] visited, int[][] cost) {
        if ((i < 0 || i >= cost.length)
                ||(j < 0 || j >= cost[0].length)
                ||(visited[i][j])) {
            return 0;
        }
        visited[i][j] = true;

        int result = 1;
        result += dfs(i, j - 1, visited, cost);
        result += dfs(i, j + 1, visited, cost);
        result += dfs(i - 1, j, visited, cost);
        result += dfs(i + 1, j, visited, cost);
        return result;
    }
}
