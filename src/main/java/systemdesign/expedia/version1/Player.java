package systemdesign.expedia.version1;

/**
 * @author Jeff Cai
 *
 * @date  03/18/2019
 * @version 1.0
 *
 */
public class Player {

    private int id = 0;
    private String name = "";

    public Player() {}

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
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
}
