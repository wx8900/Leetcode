package systemdesign.expedia.version3;

/**
 * @ClassName TicTacToeGame
 * @Description
 * @Author Jeff
 * @Date 2019/3/24 13:14
 * @Version V1.0
 */
public class TicTacToeGame {

    private Player currentPlayer;

    public TicTacToeGame() {}

    /*public static void main(String[] args) {
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        int rowLength = 3;
        ChessBoard chessBoard = new ChessBoard(rowLength);
        Player personPlayer = new Player(1, Constant.PLAYER_PERSON);
        Player computerPlayer = new Player(-1, Constant.PLAYER_COMPUTER);
        Rule rule = new Rule();
        ticTacToeGame.startGame(chessBoard, personPlayer, computerPlayer, rule);
    }

    private void startGame(ChessBoard chessBoard, Player personPlayer, Player computerPlayer, Rule rule) {
        System.out.print(Constant.WELCOME_FIRST);
        Scanner in = new Scanner(System.in);
        String firsthand = in.nextLine();
        if (Constant.FIRST_HAND_YES.equalsIgnoreCase(firsthand)) {
            currentPlayer = personPlayer;
        } else {
            currentPlayer = computerPlayer;
        }
        displayDialogue(chessBoard, personPlayer, computerPlayer, rule);
    }

    private void displayDialogue(ChessBoard chessBoard, Player personPlayer, Player computerPlayer, Rule rule) {
        while () {

        }
    }*/
}
