package ooddesign.microsoft;

public class ChessGame {
    public static final int GO_STRAIGHT_LINE = 0;
    public static final int GO_SLASH = 1;

    public static void main (String[] args) {
        ChessBoard chessBoard = new ChessBoard(5, 5);
        chessBoard.updatePos(1,0,true); // a piece exist in the board
        // assume walk one step for one time of a piece
        // type 1: go 45 degree line; type 0: go straight line
        Piece piece = new Piece(2, 2, GO_SLASH);
        ChessGame chessGame = new ChessGame();
        chessGame.move(chessBoard, piece);
    }

    private String move(ChessBoard board, Piece p) {
        Piece pieceResult = new Piece(0, 0, GO_STRAIGHT_LINE);
        if (board == null || board.row == 0 || board.col == 0
                || p.x < 0 || p.x >= board.row || p.y < 0 || p.y >= board.col) {
            return pieceResult.toString();
        }

        if (p.type == GO_STRAIGHT_LINE) {
            // go right
            if (board.canAdd(p.x + 1, p.y)) {
                board.updatePos(p.x + 1, p.y, true);
                pieceResult = new Piece(p.x + 1, p.y, GO_STRAIGHT_LINE);
            }
            // go left
            else if (board.canAdd(p.x - 1, p.y)) {
                board.updatePos(p.x - 1, p.y, true);
                pieceResult = new Piece(p.x - 1, p.y, GO_STRAIGHT_LINE);
            }
            // go up
            else if (board.canAdd(p.x, p.y + 1)) {
                board.updatePos(p.x, p.y + 1, true);
                pieceResult = new Piece(p.x, p.y + 1, GO_STRAIGHT_LINE);
            }
        } else if (p.type == GO_SLASH) {
            if (board.canAdd(p.x + 1, p.y + 1)) {
                board.updatePos(p.x + 1, p.y + 1, true);
                pieceResult = new Piece(p.x + 1, p.y + 1, GO_SLASH);
            } else if (board.canAdd(p.x + 1, p.y - 1)) {
                board.updatePos(p.x + 1, p.y - 1, true);
                pieceResult = new Piece(p.x + 1, p.y - 1, GO_SLASH);
            } else if (board.canAdd(p.x - 1, p.y - 1)) {
                board.updatePos(p.x - 1, p.y - 1, true);
                pieceResult = new Piece(p.x - 1, p.y - 1, GO_SLASH);
            } else if (board.canAdd(p.x - 1, p.y + 1)) {
                board.updatePos(p.x - 1, p.y + 1, true);
                pieceResult = new Piece(p.x - 1, p.y + 1, GO_SLASH);
            }
        }

        if (p.x == board.row - 1 || p.y == board.col - 1) {
            return pieceResult.toString();
        } else {
            board.updatePos(p.x, p.y, false);
            move(board, pieceResult);
        }

        return pieceResult.toString();
    }

    private static class ChessBoard {
        private int row;
        private int col;
        private int[][] hasPiece;

        public ChessBoard( int r,  int c) {
            this.row = r;
            this.col = c;
            hasPiece = new int[row][col];
            System.out.println("board row: "+ row + ", board col: "+ col);
            for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    // 0 means no piece in this point
                    hasPiece[i][j] = 0;
                }
            }
        }

        public boolean canAdd(int x, int y) {
            if (x < 0 || x >= row || y < 0 || y >= col) {
                return false;
            }
            if (hasPiece[x][y] != 0) {
                return false;
            }
            System.out.println("x : "+ x + ", y : "+y);
            return true;
        }

        // arriveAtPosition: true if arrive at the point; false if leaving the point
        public void updatePos(int x, int y, boolean arriveAtPosition) {
            if (x < 0 || x >= row || y < 0 || y >= col) {
                return;
            }
            if (arriveAtPosition) {
                hasPiece[x][y] = 1;
            } else {
                hasPiece[x][y] = 0;
            }
        }
    }

    private static class Piece {
        private int x;
        private int y;
        private int type;

        public Piece( int x,  int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        @Override
        public String toString() {
            return String.format(" x : " + x + ", y : " + y);
        }
    }
}