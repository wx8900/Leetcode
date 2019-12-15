package systemdesign.expedia.version3;

/**
 * @ClassName ChessBoard
 * @Description
 * @Author Jeff
 * @Date 2019/3/24 13:14
 * @Version V1.0
 */
public class ChessBoard {
    private int rowLength;
    private int steps;
    private int[] rows;
    private int[] cols;
    private int diagonal, antiDiagonal;
    private int[][] visited;

    public ChessBoard() {}

    public ChessBoard(int rowLength) {
        this.rowLength = rowLength;
    }

    public int getRowLength() {
        return rowLength;
    }

    public void setRowLength(int rowLength) {
        this.rowLength = rowLength;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
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

    public int[][] getVisited() {
        return visited;
    }

    public void setVisited(int[][] visited) {
        this.visited = visited;
    }
}
