package onsite.trade;

import java.util.List;

/**
 * 装船类
 *
 * @author Jack
 * @version V1.0
 * @date 2019/12/2 23:03
 */
public class Shipment {

    private String id;

    /**
     * 装货量
     */
    private Integer quantity;

    private Integer ratio;

    private List<String> mergeIds = null;

    public Shipment() {
    }

    public Shipment(String id, Integer quantity, Integer ratio, List<String> mergeIds) {
        this.id = id;
        this.quantity = quantity;
        this.ratio = ratio;
        this.mergeIds = mergeIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getRatio() {
        return ratio;
    }

    public void setRatio(Integer ratio) {
        this.ratio = ratio;
    }

    public List<String> getMergeIds() {
        return mergeIds;
    }

    public void setMergeIds(List<String> mergeIds) {
        this.mergeIds = mergeIds;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id='" + id + '\'' +
                ", quantity=" + quantity +
                ", mergeIds=" + mergeIds +
                '}';
    }
}
