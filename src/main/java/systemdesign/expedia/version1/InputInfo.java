package systemdesign.expedia.version1;

import java.util.Scanner;

/**
 * @author  Jeff Cai
 *
 * @date    03/19/2019
 * @version 1.0
 *
 */
public class InputInfo {

    private Scanner in;
    private String firsthand;
    private int sizeOfBoard;
    private Player personPlayer;
    private ComputerPlayer computerPlayer;

    public InputInfo() {}

    public Scanner getIn() {
        return in;
    }

    public void setIn(Scanner in) {
        this.in = in;
    }

    public String getFirsthand() {
        return firsthand;
    }

    public void setFirsthand(String firsthand) {
        this.firsthand = firsthand;
    }

    public int getSizeOfBoard() {
        return sizeOfBoard;
    }

    public void setSizeOfBoard(int sizeOfBoard) {
        this.sizeOfBoard = sizeOfBoard;
    }

    public Player getPersonPlayer() {
        return personPlayer;
    }

    public void setPersonPlayer(Player personPlayer) {
        this.personPlayer = personPlayer;
    }

    public ComputerPlayer getComputerPlayer() {
        return computerPlayer;
    }

    public void setComputerPlayer(ComputerPlayer computerPlayer) {
        this.computerPlayer = computerPlayer;
    }
}
