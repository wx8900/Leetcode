package systemdesign.expedia.version2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Jeff
 * @version 1.0
 * @date 03/20/2019
 * @apiNote Design
 */
public class Player {
    private int id;
    private String name;
    private boolean computerPlayer;
    private boolean firstHand;

    private int waitingTime;
    private int score;
    private int level;

    public Player(int id, String name, boolean computerPlayer) {
        this.id = id;
        this.name = name;
        this.computerPlayer = computerPlayer;
    }

    public static void main(String[] args) {

    }

    public int getRealRandom(ChessBoard chessBoard) {
        int max = chessBoard.getRowLength();
        int ints = ThreadLocalRandom.current().nextInt(max);
        return ints;
    }

    /**
     * @param chessBoard
     * @return
     */
    public List<Piece> availablePositions(ChessBoard chessBoard) {
        List<Piece> availableList = new ArrayList<>();
        int rowLength = chessBoard.getRowLength();
        boolean[][] visited = chessBoard.getVisited();
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                if (visited[i][j] == false) {
                    availableList.add(new Piece(i, j));
                }
            }
        }
        return availableList;
    }

    public void move(ChessBoard chessBoard) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isComputerPlayer() {
        return computerPlayer;
    }

    public void setComputerPlayer(boolean computerPlayer) {
        this.computerPlayer = computerPlayer;
    }

    public boolean isFirstHand() {
        return firstHand;
    }

    public void setFirstHand(boolean firstHand) {
        this.firstHand = firstHand;
    }

}
