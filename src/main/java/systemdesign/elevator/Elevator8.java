package systemdesign.elevator;

import java.util.*;

/**
 * Elevator New Design
 *
 * @author Jeff
 * @date   01/08/2019
 *
 * 电梯是有2种信号控制的：
 *  1. 内部信号：乘客在电梯内按按钮；按的楼层按钮都加入Request List中。
 *     1.1 按了内部信号，且与电梯运行方向一样，才stop和开门；
 *     1.2 如果方向不一样，暂时忽略该信号，加入Request List中。
 *  2. 外部信号：乘客在每层楼的电梯门外的入口处按按钮。按的上、下按钮只是去Call 电梯到这层。
 *     2.1 按了外部信号，且与电梯运行方向一样，才stop和开门；
 *     2.2 如果方向不一样，暂时忽略该信号，加入Request List中。
 */
public class Elevator8 {
    // states
    public static int MAINTENANCE = 0;
    public static int STAND = 1;
    public static int UP = 2;
    public static int DOWN = 3;

    private int minFloor;
    private int maxFloor;
    private Queue<Integer> requestQueue = new LinkedList<>();
    private int currentFloor = 0;
    private int currentState = 0;
    private int startFloor = 0;
    private int endFloor = 0;

    public void openDoor() {
        System.out.println("...... Open Door ...... ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        closeDoor();
    }

    public void closeDoor() {
        System.out.println("......  Close Door ...... ");
    }

    // inside an elevator
    public void addDestinationFloor(int targetFloor) {
        int curState = getCurrentState();
        int curFloor = getCurrentFloor();
        if (curFloor == targetFloor) {
            stop();
        }
        if (curFloor < targetFloor && UP == curState) {
            up(targetFloor);
        } else {
            requestQueue.offer(targetFloor);
        }
        if (curFloor > targetFloor && DOWN == curState) {
            down(targetFloor);
        } else {
            requestQueue.offer(targetFloor);
        }
    }

    /**
     * outside an elevator
     *
     * @param waitFloor
     * @param goUp
     */
    public void addWaitingFloor(int waitFloor, boolean goUp) {
        int curState = getCurrentState();
        int curFloor = getCurrentFloor();
        System.out.println("curState : "+(2==curState? "UP" : "DOWN") +" , curFloor : " +curFloor);
        // call elevator to this floor
        if (MAINTENANCE == curState) {
            System.out.println("This elevator is not available !");
        }
        // if the elevator is stand state, call this elevator goes to this floor
        else {
            if (curFloor == waitFloor) {
                stop();
            }
            if (curFloor < waitFloor && goUp) {
                up(waitFloor);
            } else {
                requestQueue.offer(waitFloor);
            }
            if (curFloor > waitFloor && !goUp) {
                down(waitFloor);
            } else {
                requestQueue.offer(waitFloor);
            }
        }
    }

    public void up(int targetFloor) {
        setCurrentState(UP);
        int tFloor = targetFloor;
        if (getEndFloor() != 0) {
            tFloor = getEndFloor();
        }
        // Check if it need to stop when arriving each floor
        while (tFloor != getCurrentFloor()) {
            int curFloor = getCurrentFloor();
            System.out.println("GO up, current is " + curFloor +"th floor.");
            if (needStop(tFloor, curFloor)) {
                System.out.println("GO up, elevator stop allow .");
                checkFloorExistRequest(curFloor, UP);
            }
            currentFloor++;
        }
        if (requestQueue.isEmpty()) {
            setCurrentState(STAND);
            endFloor = 0;
            startFloor = 0;
            System.out.println("The state of this elevator is STAND !");
        }
    }

    public void down(int targetFloor) {
        setCurrentState(DOWN);
        // Check if it need to stop when arriving each floor
        while (targetFloor != getCurrentFloor()) {
            int curFloor = getCurrentFloor();
            System.out.println("====>GO down, current is " + curFloor +"th floor.");
            if (needStop(targetFloor, curFloor)) {
                System.out.println("====>GO down, elevator stop allow .");
                checkFloorExistRequest(curFloor, DOWN);
            }
            currentFloor--;
        }
        if (requestQueue.isEmpty()) {
            setCurrentState(STAND);
            endFloor = 0;
            startFloor = 0;
            System.out.println("=============The state of the elevator is STAND !=============");
        }
    }

    private boolean checkDirectionEquals(int targetFloor, int currentFloor) {
        int currentState = getCurrentState();
        if (currentFloor == targetFloor) {
            return true;
        } else if (currentFloor < targetFloor) {
            return UP == currentState;
        } else {
            return DOWN == currentState;
        }
    }

    /**
     *  Return true only if meet both belows conditions:
     *     1. if they are the same direction
     *     2. current floor exists in request Queue
     */
    private boolean needStop(int targetFloor, int currentFloor) {
        System.out.println("Current floor is " + currentFloor);
        if (checkDirectionEquals(targetFloor, currentFloor)) {
            if (!requestQueue.isEmpty()) {
                if (requestQueue.contains(currentFloor)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *  check if the current floor exist in request Set
     */
    private void checkFloorExistRequest(int currentFloor, int curState) {
        // clean this floor from the request list
        if (!requestQueue.isEmpty()) {
            if (requestQueue.contains(currentFloor)) {
                int head = requestQueue.poll();
                if (!requestQueue.isEmpty()) {
                    int next = requestQueue.peek();
                    System.out.println("The requestQueue poll is " + head + ", next is " +next);
                    if (head == currentFloor) {
                        stop();
                        if (next > head && UP == curState) {
                            mergeFloor(next);
                            System.out.println("Merge floors to up direction !");
                        }
                        if (next < head && DOWN == curState) {
                            mergeFloor(next);
                            System.out.println("Merge floors to down direction !");
                        }
                    }
                } else {
                    stop();
                    return;
                }
            }
        } else {
            stop();
            return;
        }
    }

    /**
     *  Merge two adjacent trips into one long trip (2->5->9 merge: 2->9)
     */
    private void mergeFloor(int nextFloor) {
        endFloor = nextFloor;
    }

    public void stop() {
        System.out.println("...... Stop ...... ");
        openDoor();
    }

    public int schedule() {
        // more elevators
        return 0;
    }

    public Elevator8(int minFloor, int maxFloor, Queue<Integer> requestQueue, int currentFloor, int currentState) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.requestQueue = requestQueue;
        this.currentFloor = currentFloor;
        this.currentState = currentState;
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

    public Queue<Integer> getRequestQueue() {
        return requestQueue;
    }

    public void setRequestQueue(Queue<Integer> requestQueue) {
        this.requestQueue = requestQueue;
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

    public int getStartFloor() {
        return startFloor;
    }

    public void setStartFloor(int startFloor) {
        this.startFloor = startFloor;
    }

    public int getEndFloor() {
        return endFloor;
    }

    public void setEndFloor(int endFloor) {
        this.endFloor = endFloor;
    }
}
