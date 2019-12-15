package onsite.trade;

import java.util.List;

/**
 * 货物类
 *
 * @author Jack
 * @version V1.0
 * @date 2019/12/2 23:02
 */
public class Goods {

    private String id;

    private String name;

    private Integer tons;

    private List<Shipment> shipmentList;

    public Goods(String id, String name, Integer tons, List<Shipment> shipmentList) {
        this.id = id;
        this.name = name;
        this.tons = tons;
        this.shipmentList = shipmentList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTons() {
        return tons;
    }

    public void setTons(Integer tons) {
        this.tons = tons;
    }

    public List<Shipment> getShipmentList() {
        return shipmentList;
    }

    public void setShipmentList(List<Shipment> shipmentList) {
        this.shipmentList = shipmentList;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tons=" + tons +
                ", shipmentList=" + shipmentList +
                '}';
    }
}
