package systemdesign.expedia.version2;

import systemdesign.expedia.version1.Constant;

import java.util.List;
import java.util.Scanner;

/**
 * Expedia Coding Question:
 * Write a simple console app for a tic-tac-toe game.
 * The gameplay should support 1 player versus the computer,
 * and the computer can simply choose random locations on its turn.
 * You can use either C# or Java, and you do not need to write a front-end UI.
 * Tests should be submitted along with the program code.
 *
 * @author Jeff
 * @author Jeff
 * @version 3.0
 * @date 03/20/2019
 * @date 03/21/2019 1:00 AM
 * @apiNote fix a few bugs
 * <p>
 * 任然有2个Bug：
 * （1） 走最后一步才赢的时候，会判断为平局，其实是有一方赢
 * （2） 半当中已经有一方赢，为什么还是要走到最后一步，判断为平局？
 */
public class TicTacToeTest {

    private static Player currentPlayer;
    private static int x;
    private static int y;

    public static void main(String[] args) {
        System.out.println("Start Game......");
        ChessBoard chessBoard = new ChessBoard(3);
        Player personPlayer = new Player(1, "Player Jack", false);
        Player computerPlayer = new Player(-1, "Player Computer", true);
        startGame(chessBoard, personPlayer, computerPlayer);
        System.out.println("End Game......");
    }

    /**
     * @param chessBoard
     * @param personPlayer
     * @param computerPlayer
     */
    private static void startGame(ChessBoard chessBoard, Player personPlayer, Player computerPlayer) {
        System.out.print(Constant.WELCOME_FIRST);
        chessBoard.setStepCount(0);
        Scanner in = new Scanner(System.in);
        String firsthand = in.nextLine();
        if (Constant.FIRST_HAND_YES.equalsIgnoreCase(firsthand)) {
            personPlayer.setFirstHand(true);
        } else {
            computerPlayer.setFirstHand(true);
        }
        executeWhileLoop(chessBoard, in, personPlayer, computerPlayer);
    }

    /**
     * @param chessBoard
     * @param in
     * @param personPlayer
     * @param computerPlayer
     */
    private static void executeWhileLoop(ChessBoard chessBoard, Scanner in, Player personPlayer, Player computerPlayer) {
        int stepCount;
        String reminder;
        Piece piece;
        Rule rule = new Rule();
        do {
            stepCount = chessBoard.getStepCount();
            reminder = getCurrentPlayer(personPlayer, computerPlayer, stepCount);
            DialogueUI dialogueUI = buildDialogueUI(chessBoard, in, reminder, personPlayer, computerPlayer);
            piece = new Piece(dialogueUI.getCoordinateX(), dialogueUI.getCoordinateY());
            piece.setMovedByPlayer(currentPlayer);
            // bug: didn't call board to get latest visited
            while (!chessBoard.checkBorder(piece)) {
                executeWhileLoop(chessBoard, in, personPlayer, computerPlayer);
            }
            // Bug here: 如果写stepCount++，在stepCount给chessBoard赋值时，还是传0，因为++是操作之后加1，下一次循环取出来还是0，修改为stepCount+1
            chessBoard.setStepCount(stepCount + 1);
            if (currentPlayer.equals(computerPlayer)) {
                updateUsedPiece(chessBoard, x, y);
            }
        } while (rule.determineWinner(chessBoard, currentPlayer, piece) == Constant.NUMBER_NO_END);
    }

    /**
     * @param personPlayer
     * @param computerPlayer
     * @param stepCount
     * @return
     */
    private static String getCurrentPlayer(Player personPlayer, Player computerPlayer, int stepCount) {
        String reminder;
        if (stepCount % Constant.NUMBER_EVEN_DIVISOR == Constant.NUMBER_ZERO_REMAINDER) {
            currentPlayer = personPlayer.isFirstHand() ? personPlayer : computerPlayer;
            reminder = Constant.MOVE_YOUR;
        } else {
            currentPlayer = personPlayer.isFirstHand() ? computerPlayer : personPlayer;
            reminder = Constant.MOVE_MARKING;
        }
        return reminder;
    }

    /**
     * bug here: currentPlayer didn't change in the reminder
     * currentPlayer need to set to the global variable
     *
     * @param in
     * @param reminder
     * @return
     */
    private static DialogueUI buildDialogueUI(ChessBoard chessBoard, Scanner in, String reminder,
                                              Player personPlayer, Player computerPlayer) {
        DialogueUI dialogueUI = new DialogueUI();
        dialogueUI.setReminder(currentPlayer.getName() + reminder);
        System.out.println(dialogueUI.getReminder());
        if (currentPlayer.equals(personPlayer)) {
            System.out.print(Constant.COORDINATE_X);
            dialogueUI.setCoordinateX(in.nextInt());
            System.out.print(Constant.COORDINATE_Y);
            dialogueUI.setCoordinateY(in.nextInt());
        } else if (currentPlayer.equals(computerPlayer)) {
            List<Piece> list = personPlayer.availablePositions(chessBoard);
            int random = personPlayer.getRealRandom(chessBoard);
            Piece piece = null;
            if (list.size() < chessBoard.getRowLength()) {
                piece = list.get(0);
            } else {
                piece = list.get(random);
            }
            x = piece.getX();
            y = piece.getY();
            dialogueUI.setCoordinateX(x);
            System.out.println(Constant.COORDINATE_X + x);
            dialogueUI.setCoordinateY(y);
            System.out.println(Constant.COORDINATE_Y + y);
            /*System.out.print(Constant.COORDINATE_X);
            dialogueUI.setCoordinateX(in.nextInt());
            System.out.print(Constant.COORDINATE_Y);
            dialogueUI.setCoordinateY(in.nextInt());*/
        }

        return dialogueUI;
    }

    private static void updateUsedPiece(ChessBoard chessBoard, int x, int y) {
        boolean[][] usedPieces = chessBoard.getVisited();
        usedPieces[x][y] = true;
        chessBoard.setVisited(usedPieces);
    }

}
