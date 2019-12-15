package onsite.trade;

import java.util.List;

/**
 * This interface draws a bar chart
 *
 * @author Jack
 * @version V1.0
 * @date 2019/12/2 22:54
 */
public interface ShipmentManagementInterface {

    void split(Goods rootQuantity, int splitNumber);

    void merge(Goods goods, List<String> ids);

    void changeRootQuantity(Goods goods, int changedQuantity);

}
