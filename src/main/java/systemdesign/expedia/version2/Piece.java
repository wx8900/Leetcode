package systemdesign.expedia.version2;

/**
 * @author Jeff
 * @version 1.0
 * @date 03/20/2019
 * @apiNote Design
 */
public class Piece {
    private int x;
    private int y;
    private Player movedByPlayer;
    private String type;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {

    }

    /**
     * 为什么不能用 ？？？
     *
     * @param chessBoard
     * @param piece
     * @return
     */
    /*public boolean checkCanMove (ChessBoard chessBoard, Piece piece) {
        int rowLength = chessBoard.getRowLength();
        if (piece.x < 0 || piece.x >= rowLength
                || piece.y < 0 || piece.y >= rowLength) {
            return false;
        }
        // bug here : visited is java.lang.NullPointerException because visited is not init
        boolean[][] visited = chessBoard.getVisited();
        if (visited[piece.x][piece.y] == true) {
            return false;
        }
        return true;
    }*/
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Player getMovedByPlayer() {
        return movedByPlayer;
    }

    public void setMovedByPlayer(Player movedByPlayer) {
        this.movedByPlayer = movedByPlayer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
