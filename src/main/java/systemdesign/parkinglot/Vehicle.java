package systemdesign.parkinglot;

/**
 * @author Jeff
 * @version V1.0
 * @description
 * @date 2019/4/6 07:51
 */
public class Vehicle {
    private SizeEnum size;
    private int id;
    private String licensePlate;
    private String colour;

    public Vehicle(int id, String licensePlate, String colour, SizeEnum s) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.colour = colour;
        this.size = s;
    }

    public Vehicle() {}

    public SizeEnum getSize() {
        return size;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "vehicle{" +
                "id=" + id +
                ", licensePlate='" + licensePlate + '\'' +
                ", colour='" + colour + '\'' +
                ", size=" + size +
                '}';
    }
}
