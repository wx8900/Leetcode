package systemdesign.expedia.version1;
/**
 * @author  Jeff Cai
 *
 * @date    03/19/2019 10:50 AM
 * @version 1.0
 *
 */
public class Position {
    private int x;
    private int y;

    public Position() {}

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

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
}
