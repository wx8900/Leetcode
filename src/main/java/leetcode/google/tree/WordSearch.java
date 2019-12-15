package leetcode.google.tree;

public class WordSearch {
    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = new char[][] {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        System.out.print("================" + ws.exist(board, "ABCCED"));

    }

    public boolean exist(char[][] board, String word) {
        BooleanWrapper result = new BooleanWrapper();// 要new出来一个新类,才能使用
        boolean[][] visited = new boolean[board.length][board[0].length];//要先new出二位数组,并给长度[SIZE][SIZE]

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 忘记加判断条件: 用word的第一个字母去search开始调用bfs的坐标位置
                if (board[i][j] == word.charAt(0)) {
                    bfs(i, j, 0, board, word, visited, result);
                    if (result.get()) {
                        return true;
                    }
                }
                // 忘记加判断条件
            }
        }
        return false;
    }

    // 11/20/2017  # 2.3 template (no height, no global variable, no prevIndex)
    private void bfs(int row, int col, int index, char[][] board, String word, boolean[][] visited, BooleanWrapper result) {
        // entering the node
        visited[row][col] = true;
        // 1. op at node. arrive at the leave
        if (index == word.length() - 1) {
            result.set(true);
            System.out.println("========== Leaf ########### Leaf ==========");
            //return;
        }
        // 2. push children to sys stack
        // up
        if (!result.get() && row - 1 >= 0 && !visited[row - 1][col]
                && word.charAt(index + 1) == board[row - 1][col]) {
            bfs(row - 1, col, index + 1, board, word, visited, result); // 传入的index要 + 1
            System.out.println("==========if 1 ==========");
        }
        // down
        if (!result.get() && row + 1 < board.length && !visited[row + 1][col]
                && word.charAt(index + 1) == board[row + 1][col]) {
            bfs(row + 1, col, index + 1, board, word, visited, result);
            System.out.println("==========if 2 ==========");
        }
        // left
        if (!result.get() && col - 1 >= 0 && !visited[row][col - 1]
                && word.charAt(index + 1) == board[row][col - 1]) {
            bfs(row, col - 1, index + 1, board, word, visited, result);
            System.out.println("==========if 3 ==========");
        }
        // right
        if (!result.get() && col + 1 < board[0].length && !visited[row][col + 1]
                && word.charAt(index + 1) == board[row][col + 1]) {
            bfs(row, col + 1, index + 1, board, word, visited, result);
            System.out.println("==========if 4 ==========");
        }
        // leaving the node
        visited[row][col] = false;
    }

    class BooleanWrapper {   // 用来解决result的值向外面传的问题
        private boolean _val; // 是private的, 不需要初始化为false
        public void set(boolean val) { // 忘记写void
            _val = val;
        }
        public boolean get() {
            return _val;
        }
    }

}
