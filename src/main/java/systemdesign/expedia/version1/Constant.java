package systemdesign.expedia.version1;

/**
 * @author  Jeff Cai
 *
 * @date    03/19/2019
 * @version 1.0
 *
 */
public class Constant {

    /**
      * int
      */
    public static final int NUMBER_ZERO_REMAINDER = 0;
    public static final int NUMBER_EVEN_DIVISOR = 2;
    public static final int PLAYER_ID_ONE = 1;
    public static final int PLAYER_ID_ONE_NEG = -1;
    public static final int NUMBER_NO_END = -100;
    public static final int NUMBER_ZERO_DRAW = 0;

    /**
      * input information
      */
    public static final String PLAYER_PERSON = "Player X";
    public static final String PLAYER_COMPUTER = "Player O (Computer)";
    public static final String WELCOME_FIRST = "Would you like to have the first turn? <Y/N>: ";
    public static final String FIRST_HAND_YES = "Y";
    public static final String MOVE_YOUR = ", your move: ";
    public static final String MOVE_MARKING = " is marking his move:";
    public static final String COORDINATE_X = "X Coordinate: ";
    public static final String COORDINATE_Y = "Y Coordinate: ";

    /**
      * alert
      */
    public static final String ALERT_INVALID_MOVE = "Invalid move. Try again!";
    public static final String ALERT_EXIST_PIECE = "The position that you input exists a piece. Try again!";

    /**
      * result
      */
    public static final String STRING_DRAW = "Unfortunately! The game ends in a draw.";
    public static final String STRING_CONG = "Game Over. Congratulation! ";
    public static final String STRING_WON = " won!";
}
