package systemdesign.expedia.version2;

/**
 * @author Jeff
 * @version 1.0
 * @date 03/20/2019 10:57 AM
 * @apiNote Design
 */
public class DialogueUI {
    private int coordinateX;
    private int coordinateY;
    private String reminder;
    private Player currentPlayer;

    public DialogueUI() {
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
