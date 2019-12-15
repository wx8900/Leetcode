package onsite.trade;

import sun.rmi.runtime.Log;

import java.util.*;
import java.util.logging.Level;

/**
 * This class draws a bar chart
 *
 * @author Jack
 * @version V1.0
 * @date 2019/12/2 22:59
 */
public class ShipmentManagementImpl implements ShipmentManagementInterface {
    Log log = Log.getLog("ShipmentManagementImpl", "", 1);


    @Override
    public void split(Goods goods, int splitNumber) {
        if (goods == null || goods.getTons() <= 0 || splitNumber <= 0) {
            log.log(Level.SEVERE, "Illegal Argument Exception!!! [goods] : "
                    + goods + ", [splitNumber] :" + splitNumber);
        }

        int totalQuantity = goods.getTons();
        /** 给每个Shipment分配的送货量的比例 */
        List<Integer> ratios = getRandomNumber(totalQuantity, splitNumber);
        ratios.forEach(x -> System.out.println("ratio : " + x));

        List<Shipment> shipmentList = new ArrayList<>(splitNumber);
        for (int i = 0; i < ratios.size(); i++) {
            Integer ratio = ratios.get(i);
            Shipment ship = new Shipment(String.valueOf(i + 1), ratio * 10, ratio,null);
            shipmentList.add(ship);
        }

        goods.setShipmentList(shipmentList);
    }

    @Override
    public void merge(Goods goods, List ids) {
        if (goods == null || goods.getShipmentList() == null || goods.getShipmentList().size() <= 0) {
            log.log(Level.SEVERE, "Illegal Argument Exception!!! [Goods] :" + goods);
        }

        if (ids == null || ids.size() <= 1) {
            log.log(Level.SEVERE, "Illegal Argument Exception!!! " +
                    " [ids] :" + ids);
        }

        Integer sum = 0;
        List<String> mergeIds = new ArrayList<>();
        List<Shipment> resultList = new ArrayList<>();
        Set<Integer> set = new HashSet<>(ids);

        for (int j = 0; j < goods.getShipmentList().size(); j++) {
            Shipment shipment = goods.getShipmentList().get(j);
            if (!set.contains(shipment.getId())) {
                resultList.add(shipment);
            } else {
                for (int i = 0; i < ids.size(); i++) {
                    String targetMergeId = (String) ids.get(i);
                    if (targetMergeId.equals(shipment.getId())) {
                        sum += shipment.getQuantity();
                        mergeIds.add(targetMergeId);
                    }
                }
            }
        }

        Shipment mergedShipment = new Shipment();
        mergedShipment.setId(new String("mergedShipment" + 1));
        mergedShipment.setQuantity(sum);
        mergedShipment.setMergeIds(mergeIds);
        resultList.add(mergedShipment);

        goods.setShipmentList(resultList);
    }

    @Override
    public void changeRootQuantity(Goods goods, int changedQuantity) {
        if (goods == null || goods.getShipmentList() == null || goods.getShipmentList().size() <= 0) {
            log.log(Level.SEVERE, "Illegal Argument Exception!!! [Goods] :" + goods);
        }
        if (goods.getTons() <= 0) {
            log.log(Level.SEVERE, "Illegal Argument Exception!!! [goods.getTons()] :" + goods.getTons());
        }

        List<Shipment> resultList = new ArrayList<>();
        List<Shipment> shipmentList = goods.getShipmentList();
        for (int i = 0; i < shipmentList.size(); i++) {
            Shipment shipment = shipmentList.get(i);
            /*float change = changedQuantity / goods.getTons();
            shipment.setQuantity(shipment.getQuantity() * change);*/
            shipment.setQuantity(shipment.getRatio() * (changedQuantity / 10));
            resultList.add(shipment);
        }

        goods.setShipmentList(resultList);
    }

    public List<Integer> getRandomNumber(int goodsQuantity, int splitNumber) {
        List<Integer> res = new ArrayList<>();
        Random rand = new Random();
        int temp = goodsQuantity / 10;
        for (int i = 1, j; i < splitNumber; i++) {
            j = rand.nextInt(temp - 1) + 1;
            if (j > temp - (splitNumber - i)) {
                j = temp - (splitNumber - i);
            } else if (j <= 0) {
                j = 1;
            }
            temp -= j;
            res.add(j);
        }
        res.add(temp);

        return res;
    }
}
