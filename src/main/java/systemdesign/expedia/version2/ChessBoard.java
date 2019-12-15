package systemdesign.expedia.version2;

import systemdesign.expedia.version1.Constant;

/**
 * @author Jeff
 * @version 1.0
 * @date 03/20/2019
 * @apiNote Design
 */
public class ChessBoard {
    private int rowLength;
    private int stepCount;

    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    private boolean[][] visited;

    public ChessBoard() {
    }

    public ChessBoard(int rowLength) {
        this.rowLength = rowLength;
        this.rows = new int[rowLength];
        this.cols = new int[rowLength];
        this.diagonal = 0;
        this.antiDiagonal = 0;
        // bug in following 6 lines : not init
        visited = new boolean[rowLength][rowLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                visited[i][j] = false;
            }
        }
    }

    /**
     * @param piece
     * @return true if the position of input is valid
     */
    public boolean checkBorder(Piece piece) {
        if (piece.getX() < 0 || piece.getX() >= rowLength || piece.getY() < 0 || piece.getY() >= rowLength) {
            System.out.println(Constant.ALERT_INVALID_MOVE);
            return false;
        }
        // bug here : visited is java.lang.NullPointerException because visited is not init
        if (visited[piece.getX()][piece.getY()] == true) {
            System.out.println(Constant.ALERT_EXIST_PIECE);
            return false;
        }
        return true;
    }

    public int getRowLength() {
        return rowLength;
    }

    public void setRowLength(int rowLength) {
        this.rowLength = rowLength;
    }

    public int getStepCount() {
        return stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public int[] getRows() {
        return rows;
    }

    public void setRows(int[] rows) {
        this.rows = rows;
    }

    public int[] getCols() {
        return cols;
    }

    public void setCols(int[] cols) {
        this.cols = cols;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    public int getAntiDiagonal() {
        return antiDiagonal;
    }

    public void setAntiDiagonal(int antiDiagonal) {
        this.antiDiagonal = antiDiagonal;
    }

    public boolean[][] getVisited() {
        return visited;
    }

    public void setVisited(boolean[][] visited) {
        this.visited = visited;
    }
}
