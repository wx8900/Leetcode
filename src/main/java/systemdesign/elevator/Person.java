package systemdesign.elevator;

/**
 * Person class
 *
 * @author Jeff
 * @date 01/07/2019
 */

public class Person {
    private int id;
    private String name;
    private int weight;
    private int targetFloor;

    public Person(int id, String name, int weight, int targetFloor) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.targetFloor = targetFloor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public void setTargetFloor(int targetFloor) {
        this.targetFloor = targetFloor;
    }
}