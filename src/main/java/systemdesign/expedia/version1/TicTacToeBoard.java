package systemdesign.expedia.version1;

/**
 * @author Jeff Cai
 *
 * @date     03/18/2019
 * @version  1.0
 *
 * @date     03/19/2019
 * @version  2.0
 * @apiNote  Fix a bug. When the last step of a walking though game is the same step(last step) to win the game,
 * code determines in drew(bug). It must call checkDrew() at the last step of a game
 *
 * @date     03/19/2019 12:00 AM
 * @version  3.0
 * @apiNote  (1) Modify parameter x and y to Position for each method
 *           (2) Don't move diagonal, antiDiagonal, rows, cols to determineWinner() because these parameters need to
 *           count for every call determineWinner() when looping
 */
public class TicTacToeBoard {

    private int diagonal, antiDiagonal;
    private int[] rows, cols;
    private boolean[][] visited;
    private int sizeOfBoard;
    private int multiply;

    public TicTacToeBoard(int n) {
        sizeOfBoard = n;
        multiply = sizeOfBoard * sizeOfBoard;
        diagonal = 0;
        antiDiagonal = 0;
        rows = new int[sizeOfBoard];
        cols = new int[sizeOfBoard];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }

    /**
     *
     * @param p: Position(x, y)
     * @return   false if the position of input is not valid or has visited!
     * @return   true if the position of input is valid
     */
    public boolean checkBorder(Position p) {
        if (p.getX() >= sizeOfBoard || p.getY() >= sizeOfBoard) {
            System.out.println(Constant.ALERT_INVALID_MOVE);
            return false;
        }
        if (visited[p.getX()][p.getY()] == true) {
            System.out.println(Constant.ALERT_EXIST_PIECE);
            return false;
        }
        return true;
    }

    /**
     *
     * @param p:       Position(x, y)
     * @param count:   the xth round of the game
     * @param player:  instance of Player
     * @return  1:     Player X won!
     * @return -1:     Player 0 (Computer) won!
     * @return  0:     game ends in a drew!
     * @return  other, continue;
     */
    public int determineWinner(Position p, int count, Player player) {
        visited[p.getX()][p.getY()] = true;
        countAppearNumber(player, p);

        return outputGameResult(count, player, Math.abs(rows[p.getX()]) == sizeOfBoard
                || Math.abs(cols[p.getY()]) == sizeOfBoard
                || Math.abs(diagonal) == sizeOfBoard
                || Math.abs(antiDiagonal) == sizeOfBoard);
    }

    /**
     *
     * @param player
     * @param p
     */
    private void countAppearNumber(Player player, Position p) {
        int sign = player.getId() == Constant.PLAYER_ID_ONE ? Constant.PLAYER_ID_ONE : Constant.PLAYER_ID_ONE_NEG;
        rows[p.getX()] += sign;
        cols[p.getY()] += sign;
        if(p.getX() == p.getY()) {
            diagonal += sign;
        }
        if(p.getX() == sizeOfBoard - 1 - p.getY()) {
            antiDiagonal += sign;
        }
    }

    /**
     * Must call checkDrew method at the last step of a game
     * @param count
     * @param player
     * @param b
     * @return
     */
    private int outputGameResult(int count, Player player, boolean b) {
        if(b) {
            System.out.print(Constant.STRING_CONG + player.getName() + Constant.STRING_WON);
            return player.getId();
        } else {
            if (count == multiply) {
                if (checkDrew(sizeOfBoard)) {
                    return Constant.NUMBER_ZERO_DRAW;
                }
            }
            return Constant.NUMBER_NO_END;
        }
    }

    /**
     *
     * @param n: the length of chess board
     * @return   true if the game ends in a drew, otherwise return false
     */
    private boolean checkDrew(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    count++;
                }
            }
        }
        if (count == multiply) {
            System.out.println(Constant.STRING_DRAW);
            return true;
        }
        return false;
    }
}