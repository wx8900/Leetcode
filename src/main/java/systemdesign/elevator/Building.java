package systemdesign.elevator;

/**
 * Building class
 *
 * @author Jeff
 * @date   01/07/2019
 */

public class Building {
    private int id;
    private String name;
    private int minLayer;
    private int maxLayer;

    /**
     *  American English don't have the 0 layer, the ground floor == the first floor
     */
    public Building(int id, String name, int minLayer, int maxLayer) {
        this.id = id;
        this.name = name;
        this.minLayer = minLayer;
        this.maxLayer = maxLayer;
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

    public int getMinLayer() {
        return minLayer;
    }

    public void setMinLayer(int minLayer) {
        this.minLayer = minLayer;
    }

    public int getMaxLayer() {
        return maxLayer;
    }

    public void setMaxLayer(int maxLayer) {
        this.maxLayer = maxLayer;
    }
}
