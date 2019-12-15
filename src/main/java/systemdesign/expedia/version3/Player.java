package systemdesign.expedia.version3;

/**
 * @ClassName Player
 * @Description
 * @Author Jeff
 * @Date 2019/3/24 13:15
 * @Version V1.0
 */
public class Player {
    private int id;
    private String name;
    private boolean firstHand;

    public Player(int id, String name, boolean firstHand) {
        this.id = id;
        this.name = name;
        this.firstHand = firstHand;
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

    public boolean isFirstHand() {
        return firstHand;
    }

    public void setFirstHand(boolean firstHand) {
        this.firstHand = firstHand;
    }
}
