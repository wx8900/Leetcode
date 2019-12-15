package systemdesign.expedia.version2;

import systemdesign.expedia.version1.Constant;

/**
 * @author Jeff
 * @version 3.0
 * @date 03/20/2019
 * @apiNote Design
 * @date 03/20/2019 10:00 AM (HCL Offer comes)
 * @apiNote Implement method determineWinner
 * @date 03/21/2019 1:00 AM
 * @apiNote
 */
public class Rule {
    /**
     * 走在格子内部 / 走在格子的线上, 用来区别是国际象棋（包括TicTacToe）还是中国象棋
     * useNewPieceEachWalk
     */
    private boolean walkInBlock;

    /**
     * 只能向前走
     */
    private boolean onlyGoForward;

    /**
     * 只走直线 / 只走斜线
     */
    private boolean walkwithStraightLine;

    /**
     * 一次最多走几步
     */
    private int stepsEachWalk;

    /**
     * 走的规则：走“日”字形，走“田”字形
     */
    private int walkRules;

    public Rule() {
    }

    /**
     * has 3 bugs
     *
     * @param chessBoard
     * @param player
     * @param piece
     * @return
     */
    public int determineWinner(ChessBoard chessBoard, Player player, Piece piece) {
        // bug here: didn't sign piece is visited
        chessBoard.getVisited()[piece.getX()][piece.getY()] = true;
        int[] rows = chessBoard.getRows();
        int[] cols = chessBoard.getCols();
        int diagonal = chessBoard.getDiagonal();
        int antiDiagonal = chessBoard.getAntiDiagonal();
        int rowLength = chessBoard.getRowLength();

        int sign = player.getId() == 1 ? 1 : -1;
        // bug here: rows is java.lang.NullPointerException, not init
        rows[piece.getX()] += sign;
        cols[piece.getY()] += sign;
        if (piece.getX() == piece.getY()) {
            diagonal += sign;
        }
        if (piece.getX() == (rowLength - 1 - piece.getY())) {
            antiDiagonal += sign;
        }

        // bug here: rows, cols得到新的值，没有更新到chessBoard的全局变量中，导致次数统计算错，玩家一直没有显示赢（事实上已经赢了)
        chessBoard.setRows(rows);
        chessBoard.setCols(cols);
        chessBoard.setDiagonal(diagonal);
        chessBoard.setAntiDiagonal(antiDiagonal);

        if (rowLength == rows[piece.getX()] || rowLength == cols[piece.getY()]
                || rowLength == diagonal || rowLength == antiDiagonal) {
            Player currentPlayer = piece.getMovedByPlayer();
            System.out.println(currentPlayer.getName() + " won the game!");
            return currentPlayer.getId();
        } else {
            if (chessBoard.getStepCount() == rowLength * rowLength) {
                if (checkDraw(chessBoard)) {
                    return 0;
                }
            }
            return Constant.NUMBER_NO_END;
        }
    }

    /**
     * @param chessBoard: the length of chess board
     * @return true if the game ends in a draw, otherwise return false
     */
    private boolean checkDraw(ChessBoard chessBoard) {
        int rowLength = chessBoard.getRowLength();
        int count = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                if (chessBoard.getVisited()[i][j]) {
                    count++;
                }
            }
        }
        if (count == rowLength * rowLength) {
            System.out.println(Constant.STRING_DRAW);
            return true;
        }
        return false;
    }

    public int moveRules(Piece piece) {
        if ("Line".equalsIgnoreCase(piece.getType())) {
            // to do : walkwithStraightLine
        }

        return 0;
    }

}
