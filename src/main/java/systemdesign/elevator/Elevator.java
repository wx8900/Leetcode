package systemdesign.elevator;

import java.util.List;

/**
 * Elevator class
 *
 * @author Jeff
 * @date   01/07/2019
 */

public class Elevator {
    private int id;
    private String name;
    private int maxWeight;
    private int curLayer;

    public void up(Building building, int targetLayer) {
        if (curLayer <= building.getMaxLayer()
                && curLayer < targetLayer) {
            if (curLayer != 0) {
                System.out.println("Go up, curLayer: ^^^^^^  "+curLayer);
                curLayer++;
            } else {
                ++curLayer; // American English don't have the 0 layer, the ground floor == the first floor
            }
            up(building, targetLayer);
        } else {
            stop(building, targetLayer);
        }
    }

    public void down(Building building, int targetLayer) {
        if (curLayer >= building.getMinLayer()
                && curLayer > targetLayer) {
            if (curLayer != 0) {
                System.out.println("Go down, curLayer: VVVVVV  "+curLayer);
                curLayer--;
            } else {
                --curLayer; // American English don't have the 0 layer, the ground floor == the first floor
            }
            down(building, targetLayer);
        } else {
            stop(building, targetLayer);
        }
    }

    public void stop(Building building, int targetLayer) {
        if (curLayer == targetLayer) {
            System.out.println("The "+this.getName()+" elevator of "+building.getName()+" stops at the "
                    +targetLayer+"th layer !");
        }
    }

    public void move(Building building, Elevator elevator, List<Person> list,
                             int startLayer, int targetLayer) {
        System.out.println(" ================ One task starting ================ ");
        // check the input layer valid
        int minLayer = building.getMinLayer(), maxLayer = building.getMaxLayer();
        if (startLayer < minLayer || startLayer > maxLayer
                || targetLayer < minLayer || targetLayer > maxLayer) {
            System.out.println(" ****** The input layer is invalid ! Please input again. ****** ");
            return;
        }

        // check the weight of all passager
        int taskWeight = 0;
        for (int i = 0, size = list.size(); i < size; i++) {
            taskWeight += list.get(i).getWeight();
        }
        System.out.println("The max weight of the "+elevator.getName()+" elevator is " + elevator.getMaxWeight()
                +" KG. \n this task weight of the "+elevator.getName()+" elevator is " + taskWeight + " KG.");
        if (taskWeight <= 0 || taskWeight > elevator.getMaxWeight()) {
            elevator.alarmAlert();
            return;
        }

        // init the start layer
        int curLayer = elevator.getCurLayer();
        if (curLayer != startLayer) {
            elevator.setCurLayer(startLayer);
        }

        if (targetLayer == curLayer) {
            elevator.stop(building, targetLayer);
        } else if (targetLayer > curLayer) {
            elevator.up(building, targetLayer);
        } else {
            elevator.down(building, targetLayer);
        }
    }

    public void alarmAlert() {
        System.out.println(" ********* This elevator is overweight. ********* ");
    }

    public Elevator(int id, String name, int maxWeight, int curLayer) {
        this.id = id;
        this.name = name;
        this.maxWeight = maxWeight;
        this.curLayer = curLayer;
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

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getCurLayer() {
        return curLayer;
    }

    public void setCurLayer(int curLayer) {
        this.curLayer = curLayer;
    }
}