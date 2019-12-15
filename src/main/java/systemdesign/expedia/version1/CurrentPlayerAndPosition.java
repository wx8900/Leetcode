package systemdesign.expedia.version1;

/**
 * @author Jeff Cai
 *
 * @date  03/18/2019
 * @version 1.0
 *
 * @date  03/19/2019
 * @version 2.0
 * @apiNote
 *        (1) Add number.
 *        (2) Move "while (!ticTacToe.checkBorder(a, b, number)) {...}" code from GameTest to GetValuesFromConsole class
 *        (3) Put 6 parameters into a class InputInfo
 *        (4) Extract code for three new smaller methods
 *
 * @date     03/19/2019 11:49 AM
 * @version  3.0
 * @apiNote  (1) Add Position in this class
 *           (2) Merge two methods invoke() and retryInput()
 */
public class CurrentPlayerAndPosition {

    private Player currentPlayer;
    private Position p = new Position();

    public CurrentPlayerAndPosition() {}

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Position getP() {
        return p;
    }

    public void setP(Position p) {
        this.p = p;
    }

    public CurrentPlayerAndPosition invoke(TicTacToeBoard ticTacToeBoard, int round, InputInfo inputInfo) {
        getCurrentPlayer(round, inputInfo);
        getInputPosition(inputInfo);
        //if move over board or move to visited position, let user retry input
        while (!ticTacToeBoard.checkBorder(p)) {
            invoke(ticTacToeBoard, round, inputInfo);
        }
        return this;
    }

    /**
     *
     * @param round
     * @param inputInfo
     */
    private void getCurrentPlayer(int round, InputInfo inputInfo) {
        boolean firstHandYes = Constant.FIRST_HAND_YES.equalsIgnoreCase(inputInfo.getFirsthand());
        Player personPlayer = inputInfo.getPersonPlayer();
        ComputerPlayer computerPlayer = inputInfo.getComputerPlayer();
        if (round % Constant.NUMBER_EVEN_DIVISOR == Constant.NUMBER_ZERO_REMAINDER) {
            currentPlayer = (firstHandYes ? personPlayer : computerPlayer);
            System.out.println(currentPlayer.getName() + Constant.MOVE_YOUR );
        } else {
            currentPlayer = (firstHandYes ? computerPlayer : personPlayer);
            System.out.println(currentPlayer.getName() + Constant.MOVE_MARKING);
        }
    }

    /**
     *
     * @param inputInfo
     */
    private void getInputPosition(InputInfo inputInfo) {
        if (currentPlayer == inputInfo.getPersonPlayer()) {
            System.out.print(Constant.COORDINATE_X);
            p.setX(inputInfo.getIn().nextInt());
            System.out.print(Constant.COORDINATE_Y);
            p.setY(inputInfo.getIn().nextInt());
        } else if (currentPlayer == inputInfo.getComputerPlayer()) {
            p.setX(inputInfo.getComputerPlayer().getRealRandom());
            System.out.println(Constant.COORDINATE_X + p.getX());
            p.setY(inputInfo.getComputerPlayer().getRealRandom());
            System.out.println(Constant.COORDINATE_Y + p.getY());
        }
    }
}
