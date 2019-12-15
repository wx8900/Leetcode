package systemdesign.elevator;

import java.util.ArrayList;
import java.util.List;

/**
 * add private List<Integer> addPerson(List<Person> personList) to work
 *
 * @author  Jeff
 * @version V1.0
 * @date    6/16/19 12:16
 */
public class Elevator15 {

    public static final int STATE_MAINTAIN = 0;
    public static final int STATE_STAND = 1;
    public static final int STATE_UP = 2;
    public static final int STATE_DOWN = 3;
    public static final int MAX_WEIGHT = 200;
    public static final int CLOSE_DOOR_TIME = 3000;

    private int curFloor;
    private int defaultStandFloor;
    private int curState;
    private int curWeight;
    private List<Person> personList = new ArrayList<>();
    private List<Integer> requestList = new ArrayList<>();

    public Elevator15(int curFloor, int defaultStandFloor, int curState, int curWeight) {
        this.curFloor = curFloor;
        this.defaultStandFloor = defaultStandFloor;
        this.curState = curState;
        this.curWeight = curWeight;
    }

    public static void main(String[] str) {
        Elevator15 elevator14 = new Elevator15(1, 3, STATE_STAND, 0);
        elevator14.addWaitingFloor(7, true);
    }

    public int getCurFloor() {
        return curFloor;
    }

    public void setCurFloor(int curFloor) {
        this.curFloor = curFloor;
    }

    public int getDefaultStandFloor() {
        return defaultStandFloor;
    }

    public void setDefaultStandFloor(int defaultStandFloor) {
        this.defaultStandFloor = defaultStandFloor;
    }

    public int getCurState() {
        return curState;
    }

    public void setCurState(int curState) {
        this.curState = curState;
    }

    public int getCurWeight() {
        return curWeight;
    }

    public void setCurWeight(int curWeight) {
        this.curWeight = curWeight;
    }

    /**
     * 凡是有人操作的楼层都需要Up和Down的方向信息
     *
     * @param waitingFloor
     */
    private void addWaitingFloor(int waitingFloor, boolean isUp) {
        if (curFloor == waitingFloor) {
            openDoor();
            personChange();
        } else if (curFloor > waitingFloor) {
            down(waitingFloor);
        } else {
            up(waitingFloor);
        }
    }

    private void personChange() {
        Person p1 = new Person(11, "Tom", 180, 10);
        Person p2 = new Person(15, "Jim", 100, 10);
        personList.add(p1);
        personList.add(p2);
        requestList.add(p1.getTargetFloor());
        requestList.add(p2.getTargetFloor());
    }

    public void up(int targetFloor) {
        System.out.println("===> Up, current floor is " + curFloor);
        if (curFloor == targetFloor) {
            openDoor();
            return;
        } else if (curFloor < targetFloor) {
            curFloor++;
            up(targetFloor);
        }
    }

    /**
     * recursive up
     *
     * @param targetFloor
     */
    public void up(boolean isUp, List<Person> personList) {
        System.out.println("===> Up, current floor is " + curFloor);
        if (requestList.contains(curFloor)) {
            openDoor();
            if (personList.size() == 0) {
                addPerson(personList);
                if (isUp) {
                    //up(tarFloor, isUp, personList);
                } else {
                    //down(tarFloor, isUp, personList);
                }
            } else {
                removePerson();
                readyToStand();
            }
            return;
        }
        /*else if (curFloor < targetFloor) {
            curFloor++;
            up(targetFloor, isUp, personList);
        }*/
    }

    private void readyToStand() {
        if (curFloor > defaultStandFloor) {
            down(defaultStandFloor);
        } else {
            up(defaultStandFloor);
        }
        setCurState(STATE_STAND);
        setCurWeight(0);
        System.out.println("****** 电梯复位，回到电梯的默认停靠楼层 ： " + defaultStandFloor);
    }

    /*private int addPerson() {
        Person p1 = new Person(11, "Tom", 180, 10);
        //Person p2 = new Person(15, "Jim", 100, 10);
        int floor = 0;
        System.out.println("======> 乘客" + p1.getName() + "进入电梯");
        //System.out.println(" 乘客"+p2.getName()+"进入电梯");
        curWeight += p1.getWeight();
        //curWeight += p2.getWeight();
        if (checkPassengerWeight()) {
            requestFloorList.add(p1);
            //requestFloorList.add(p2);
            floor = p1.getTargetFloor();
            System.out.println("======> 重量没有超载，乘客在电梯内部按某个楼层的按钮 ： " + floor);
        } else {
            System.out.println("======> 提示：电梯超载！");
            stop();
        }
        return floor;
    }*/

    private List<Integer> addPerson(List<Person> personList) {
        List<Integer> floorList = new ArrayList<>();
        if (personList == null || personList.size() <= 0) {
            return floorList;
        }
        for (int i = 0; i < personList.size(); i++) {
            Person p = personList.get(i);
            System.out.println("======> 乘客" + p.getName() + "进入电梯");
            curWeight += p.getWeight();
            if (checkPassengerWeight()) {
                personList.add(p);
                requestList.add(p.getTargetFloor());
                floorList.add(p.getTargetFloor());
                System.out.println("======> 电梯没超载，乘客进入电梯后按了某个楼层的按钮 ： " + floorList);
            } else {
                System.out.println("======> 提示：电梯超载！请最后一个进入电梯的改乘下一个电梯！");
                stop();
                floorList.remove(p);
                requestList.remove(p.getTargetFloor());
                System.out.println("======> 最后一个进入的" + p.getName() + "退出了电梯。");
            }
        }
        return floorList;
    }

    private void stop() {
        try {
            Thread.sleep(CLOSE_DOOR_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("======> Elevator stop at " + curFloor+" floor !");
    }

    private int removePerson() {
        Person p1 = new Person(11, "Tom", 100, 10);
        int floor = p1.getTargetFloor();
        curWeight -= p1.getWeight();
        checkPassengerWeight();
        if (personList.size() > 0) {
            personList.remove(p1);
        }
        System.out.println("======> 乘客" + p1.getName() + "离开电梯");
        return floor;
    }

    private boolean checkPassengerWeight() {
        if (curWeight < MAX_WEIGHT) {
            return true;
        }
        return false;
    }

    public void down(int targetFloor) {
        System.out.println("***Down, current floor is " + curFloor);
        if (curFloor == targetFloor) {
            openDoor();
            return;
        } else if (curFloor > targetFloor) {
            curFloor--;
            down(targetFloor);
        }
    }

    /**
     * recursive down
     *
     * @param targetFloor
     */
    public void down(boolean isUp, List<Person> personList) {
        System.out.println("======>Down, current floor is " + curFloor);
        if (requestList.contains(curFloor)) {
            openDoor();
            // removePerson();
            if (!requestList.isEmpty()) {
                if (isUp) {
                    down(isUp, personList);
                } else {
                    up(isUp, personList);
                }
            } else {
                return;
            }
        }
        /*else if (curFloor > targetFloor) {
            curFloor--;
            down(isUp, personList);
        }*/
    }

    private void openDoor() {
        System.out.println("======> Open door at " + curFloor + " floor.");
    }

}
