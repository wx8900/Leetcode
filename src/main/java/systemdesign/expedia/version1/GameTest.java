package systemdesign.expedia.version1;

import java.util.Scanner;

/**
 * @author Jeff Cai
 *
 * @date  03/18/2019
 * @version 1.0
 * @apiNote  Use OOD to design class and to write code
 *
 * @date  03/19/2019
 * @version 2.0
 * @apiNote
 * (1) Create a computer player object to move the chess randomly
 * (2) Fix a bug. When the last step of a walking though game is the same step(last step) to win the game,
 * code determines in drew(bug). However, the fact result of the game should be I/computer win.
 *
 * @date  03/19/2019 07:38 AM
 * @version 3.0
 * @apiNote Extract code for three new smaller methods (startNewGame, getInputInfo, doWhileLoop)
 *
 * @date  03/19/2019 10:50 AM
 * @version 4.0
 * @apiNote (1) Create a new class: Position
 *          (2) Delete no use input parameters and use Position as input
 *          (3) Find a performance issue, when computer player need to move, it always go the visited position,===> need add cache
 */
public class GameTest {

    public static void main (String[] args) {
        int min = 0;
        int sizeOfBoard = 3;

        TicTacToeBoard ticTacToeBoard = new TicTacToeBoard(sizeOfBoard);
        Player personPlayer = new Player(Constant.PLAYER_ID_ONE, Constant.PLAYER_PERSON);
        ComputerPlayer computerPlayer = new ComputerPlayer(Constant.PLAYER_ID_ONE_NEG,
                Constant.PLAYER_COMPUTER, min, sizeOfBoard);

        startNewGame(sizeOfBoard, ticTacToeBoard, personPlayer, computerPlayer);
    }

    /**
     *
     * @param sizeOfBoard
     * @param ticTacToeBoard
     * @param personPlayer
     * @param computerPlayer
     */
    private static void startNewGame(int sizeOfBoard, TicTacToeBoard ticTacToeBoard,
                                     Player personPlayer, ComputerPlayer computerPlayer) {
        int round = 0;
        InputInfo info = getInputInfo(sizeOfBoard, personPlayer, computerPlayer);
        doWhileLoop(ticTacToeBoard, round, info);
    }

    /**
     *
     * @param ticTacToeBoard
     * @param round
     * @param info
     */
    private static void doWhileLoop(TicTacToeBoard ticTacToeBoard, int round, InputInfo info) {
        Position p = new Position();
        Player currentPlayer;
        do {
            CurrentPlayerAndPosition inputValues = new CurrentPlayerAndPosition().invoke(ticTacToeBoard, round, info);
            p.setX(inputValues.getP().getX());
            p.setY(inputValues.getP().getY());
            currentPlayer = inputValues.getCurrentPlayer();
            if (ticTacToeBoard.checkBorder(p)) {
                round++;
            }
        } while (ticTacToeBoard.determineWinner(p, round, currentPlayer) == Constant.NUMBER_NO_END);
    }

    /**
     *
     * @param sizeOfBoard
     * @param personPlayer
     * @param computerPlayer
     * @return
     */
    private static InputInfo getInputInfo(int sizeOfBoard, Player personPlayer, ComputerPlayer computerPlayer) {
        System.out.print(Constant.WELCOME_FIRST);
        Scanner in = new Scanner(System.in);
        String firsthand = in.nextLine();
        InputInfo info = new InputInfo();
        info.setIn(in);
        info.setFirsthand(firsthand);
        info.setSizeOfBoard(sizeOfBoard);
        info.setPersonPlayer(personPlayer);
        info.setComputerPlayer(computerPlayer);
        return info;
    }
}
