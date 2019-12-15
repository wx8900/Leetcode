package systemdesign.elevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 从Elevator9优化过来：
 *   1. 把2个Queue变为1个LinkedList来保存请求信息
 *   2. Stand状态下，电梯被call到乘客wait的层后，由于知道乘客按的是向上或向下的箭头，问题简化为：
 *      假设：乘客wait时按的箭头方向，和他们进入电梯后按的楼层方向一致（不会出现临时改变意见）
 *          取得requestList的最高和最低楼层，和当前层比较：
 *              当前层在【最低层， 最高层】之间的，按照wait的时候按的向上的箭头按钮，调用up()到比当前层高的stop层，直到最高层，然后反向下降到最低层。
 *              当前层 < 最低层，向上的箭头按钮，调用up()到比当前层高的stop层，直到最高层。
 *              当前层 > 最高层，向下的箭头按钮，调用down()到比当前层低的stop层，直到最低层。
 *   3. 简化开门关门动作
 *   4. 修改needStop的判断条件
 *   5. 方法可以提取的都提取出来
 *   6. 修复同一层楼，重复开门2次的Bug
 *
 *   没完成的部分：UP == curState 和 DOW == curStateN的代码写的不对，需要修改
 *
 * @author Jack
 * @date 1/13/2019
 *
 */
public class Elevator13 {
    public static final int MAINTENANCE = 0;
    public static final int STAND = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;
    public static final int CLOSE_DOOR_TIME = 1000;
    public static final int defaultStandFloor = 1;

    private int minFloor;
    private int maxFloor;
    private int currentFloor;
    private int currentState;
    private int currentLoadWeight;
    private int targetFloor;
    private List<Integer> requestList = new LinkedList<>();


    /////////////////////////////////////////////////////////////////////

    public void addWaitingFloor(int waitFloor, boolean goUp) {
        int curState = getCurrentState();
        int curFloor = getCurrentFloor();
        System.out.println("curState is "+curState+", curFloor is "+curFloor);
        if (MAINTENANCE == curState) {
            System.out.println("This elevator is not available !");
        } else if (STAND == curState) {
            setCurrentLoadWeight(0);
            if (curFloor == waitFloor) {
                stop();
                personComeIn();
                moveTargetFloorInside(goUp);
            } else if (curFloor < waitFloor) {
                up(waitFloor, goUp);
            } else {
                down(waitFloor, goUp);
            }
        } else if (UP == curState) {  // Bug
            setCurrentLoadWeight(100);
            int curFl = getCurrentFloor();
            if (!goUp) {
                requestList.add(waitFloor);
                if (curFl < waitFloor) {
                    up(waitFloor, goUp);
                } else {
                    down(waitFloor, goUp);
                }
            } else {
                requestList.add(waitFloor);
                if (curFl < waitFloor) {
                    up(waitFloor, goUp);
                } else {
                    down(waitFloor, goUp);
                }
            }
        } else if (DOWN == curState) {  // Bug
            setCurrentLoadWeight(100);
            if (goUp) {
                requestList.add(waitFloor);
            } else {
                requestList.add(waitFloor);
            }
        }
    }

    private boolean checkElevatorScope(int targetFloor) {
        if (targetFloor < getMinFloor() || targetFloor > getMaxFloor()) {
            System.out.println(" The "+targetFloor+"th floor is out of the range of this elevator!!!");
            return true;
        }
        return false;
    }

    private void up(int targetFloor, boolean goUp) {
        if (checkElevatorScope(targetFloor)) {
            return;
        }
        setCurrentState(UP);
        setTargetFloor(targetFloor);
        System.out.println("requestList "+requestList);
        //System.out.println("Up, target floor is "+targetFloor);
        while (currentFloor != targetFloor) {
            System.out.println("Up, curFloor is "+currentFloor);
            if (needStop(currentFloor, UP)) {
                stop();
            }
            if (currentFloor < targetFloor) {
                currentFloor++;
            }
        }

        if (currentFloor == targetFloor) {
            System.out.println("Up, curFloor is "+currentFloor);
            stop();
            processArriveTargetFloor(goUp, targetFloor);
        }
    }

    private void down(int targetFloor, boolean goUp) {
        if (checkElevatorScope(targetFloor)) {
            return;
        }
        setCurrentState(DOWN);
        setTargetFloor(targetFloor);
        while (currentFloor != targetFloor) {
            System.out.println("Down, curFloor is "+currentFloor);
            if (needStop(currentFloor, DOWN)) {
                stop();
            }
            if (currentFloor > targetFloor) {
                currentFloor--;
            }
        }

        if (currentFloor == targetFloor) {
            System.out.println("Down, curFloor is "+currentFloor);
            stop();
            processArriveTargetFloor(goUp, targetFloor);
        }
    }

    private boolean needStop(int currentFloor, int state) {
        boolean res = false;
        if (requestList != null && requestList.size() > 0) {
            int curWeight = getCurrentLoadWeight();
            for (int i = 0, size = requestList.size(); i < size; i++) {
                int temp = requestList.get(i);
                if (curWeight > 0 && currentFloor == temp) {
                    res = true;
                }
                if (UP == state && currentFloor > temp) {
                        continue;
                }
                if (DOWN == state && currentFloor < temp) {
                        continue;
                }
            }
            if (curWeight > 0 && res) {
                int index = requestList.indexOf(currentFloor);
                requestList.remove(index);
            }
        }
        return res;
    }

    private void processArriveTargetFloor(boolean goUp, int targetFloor) {
        if (getCurrentLoadWeight() == 0) {
            personComeIn();
            if (!requestList.isEmpty()) {
                // 同一层楼开门2次
                int index = requestList.indexOf(targetFloor);
                if (index != -1) {
                    requestList.remove(index);
                }
            }
            moveTargetFloorInside(goUp);
        } else {
            if (!requestList.isEmpty()) {
                int index = requestList.indexOf(currentFloor);
                requestList.remove(index);
                if (!requestList.isEmpty()) {
                    int target = requestList.get(requestList.size() - 1);
                    if (currentFloor < target) {
                        up(target, goUp);
                    } else {
                        down(target, goUp);
                    }
                } else {
                    readyToStand(goUp);
                }
            }
        }
    }

    /**
     * up() 和 down()方法都调用这个方法，所以电梯行驶有UP和DOWN的方向，是否应该考虑？
     * 好像没影响，没有写很多Test Case去测试
     * @param goUp
     */
    private void moveTargetFloorInside(boolean goUp) {
        if (requestList != null && requestList.size() > 0) {
            int last = requestList.size() - 1;
            int high = requestList.get(last);
            int low = requestList.get(0);
            if (goUp) {
                if (currentFloor < high) {
                    up(high, goUp);
                } else {
                    down(low, goUp);
                }
            } else {
                if (currentFloor > low) {
                    down(low, goUp);
                } else {
                    up(high, goUp);
                }
            }
        }
    }

    private void readyToStand(boolean goUp) {
        int defaultFloor = defaultStandFloor;
        if (currentFloor > defaultFloor) {
            down(defaultFloor, goUp);
        } else {
            up(defaultFloor, goUp);
        }
        setCurrentState(STAND);
        setCurrentLoadWeight(0);
        System.out.println("******The elevator is going to "+defaultFloor+" floor and is STAND state.");
    }

    private void stop() {
        try {
            Thread.sleep(CLOSE_DOOR_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("====> Elevator stop at " + currentFloor+" floor !");
    }

    private void personComeIn() {
        setCurrentLoadWeight(200);
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(8);
        list.add(10);
        list.add(4);
        list.add(6);
        Collections.sort(list);
        requestList = list;
    }

    //////////////////////////////////////////////////////////////////////

    public Elevator13(int minFloor, int maxFloor, int currentState) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.currentState = currentState;
        this.currentFloor = defaultStandFloor;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public void setMinFloor(int minFloor) {
        this.minFloor = minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    public int getCurrentLoadWeight() {
        return currentLoadWeight;
    }

    public void setCurrentLoadWeight(int currentLoadWeight) {
        this.currentLoadWeight = currentLoadWeight;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public void setTargetFloor(int targetFloor) {
        this.targetFloor = targetFloor;
    }
}