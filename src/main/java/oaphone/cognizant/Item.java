package oaphone.cognizant;

import java.math.BigDecimal;

/**
 * @author Jeff
 * @version V2.0
 * @description
 * @date 2019/4/6 12:03
 * @description
 * @date 2019/4/6 12:03
 * @description
 */
public class Item {
    String name;
    int Qty;
    BigDecimal price;

    public Item(String name, int qty, BigDecimal price) {
        this.name = name;
        Qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return Qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", Qty=" + Qty +
                ", price=" + price +
                '}';
    }
}
