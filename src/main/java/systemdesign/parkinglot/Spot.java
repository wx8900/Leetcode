package systemdesign.parkinglot;

/**
 * @author Jeff
 * @version V1.0
 * @description
 * @date 2019/4/6 07:50
 */
public class Spot {
    private int id;
    private boolean isEmpty;

    public Spot() {
    }

    public Spot(int id, boolean isEmpty) {
        this.id = id;
        this.isEmpty = isEmpty;
    }

    public int getId() {
        return id;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "id=" + id +
                ", isEmpty=" + isEmpty +
                '}';
    }
}
