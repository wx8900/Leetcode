package systemdesign.elevator;

import java.util.*;

/**
 *   This is the backup of Elevator9 Success Version!
 *
 */

public class Elevator10 {
    public static final int MAINTENANCE = 0;
    public static final int STAND = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;
    public static final int closeDoorTime = 1000;
    public static final int defaultStandFloor = 1;

    private int minFloor;
    private int maxFloor;
    private int currentFloor;
    private int currentState;
    private int currentLoadWeight = 0;
    private int targetFloor;
    private Queue<Integer> requestQueueUp = new LinkedList<>();
    private Queue<Integer> requestQueueDown = new LinkedList<>();

    /** Construction */
    public Elevator10(int minFloor, int maxFloor, int currentFloor,
                     int currentState, int targetFloor,
                     Queue<Integer> requestQueueUp, Queue<Integer> requestQueueDown) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.currentFloor = currentFloor;
        this.currentState = currentState;
        this.targetFloor = targetFloor;
        this.requestQueueUp = requestQueueUp;
        this.requestQueueDown = requestQueueDown;
    }

    public void addWaitingFloor2(int waitFloor, boolean goUp) {
        int curState = getCurrentState();
        int curFloor = getCurrentFloor();
        int originalTargetFloor = getTargetFloor();
        System.out.println("curState is "+curState+", curFloor is "+curFloor+" , init TargetFloor is "+originalTargetFloor);
        if (STAND == curState) {
            if (curFloor == waitFloor) {
                stop();
                openDoor();
            }
            // 优化的写法，goUp对于在Stand状态的电梯没任何影响
            if (curFloor < waitFloor) {
                up(waitFloor, originalTargetFloor);
            } else {
                down(waitFloor, originalTargetFloor);
            }
        }
        if (UP == curState) {
            if (goUp) {
                // 在电梯向上运行区间内
                if (waitFloor >= curFloor && waitFloor <= targetFloor) {
                    requestQueueUp.offer(waitFloor);
                }
                // 在电梯向上运行区间之上
                if (waitFloor > targetFloor && waitFloor <= maxFloor) {
                    targetFloor = waitFloor;
                    up(targetFloor, originalTargetFloor);
                    System.out.println("Up, new target floor is "+targetFloor);
                }
                // 在电梯向上运行区间之下
                if (waitFloor < curFloor && waitFloor >= minFloor) {
                    requestQueueDown.offer(waitFloor);
                }
            } else {
                // ??? need to add code
            }
        }
        if (DOWN == curState) {
            if (!goUp) {
                // 在电梯向下运行区间内
                if (waitFloor >= targetFloor && waitFloor <= curFloor) {
                    requestQueueDown.offer(waitFloor);
                }
                // 在电梯向下运行区间之上
                if (waitFloor > curFloor && waitFloor <= maxFloor) {
                    requestQueueUp.offer(waitFloor);
                }
                // 在电梯向下运行区间之下
                if (waitFloor < targetFloor && waitFloor >= minFloor) {
                    targetFloor = waitFloor;
                    down(targetFloor, originalTargetFloor);
                    System.out.println("Up, new target floor is "+targetFloor);
                }
            } else {
                // ??? need to add code
            }
        }
        System.out.println("Log : requestQueueUp is "+requestQueueUp+ ". RequestQueueDown is "+requestQueueDown);
    }

    public void addWaitingFloor(int waitFloor, boolean goUp) {
        int curState = getCurrentState();
        int curFloor = getCurrentFloor();
        int originalTargetFloor = getTargetFloor();
        System.out.println("curState is "+curState+", curFloor is "+curFloor+" , init TargetFloor is "+originalTargetFloor);
        if (MAINTENANCE == curState) {
            System.out.println("This elevator is not available !");
        }
        // if the elevator is stand state, call this elevator goes to this floor
        else if (STAND == curState) {
            setCurrentLoadWeight(0);
            if (curFloor == waitFloor) {
                stop();
                openDoor();
            }
            if (curFloor < waitFloor) {
                if (goUp) {
                    up(waitFloor, originalTargetFloor);
                } else {
                    requestQueueDown.offer(waitFloor);
                }
            } else {
                if (!goUp) {
                    down(waitFloor, originalTargetFloor);
                } else {
                    if (originalTargetFloor == waitFloor) {
                        stop();
                        openDoor();
                    } else if (originalTargetFloor < waitFloor) {
                        down(originalTargetFloor, originalTargetFloor);
                    } else {
                        down(waitFloor, originalTargetFloor);
                    }
                }
            }
        } else if (UP == curState) {
            setCurrentLoadWeight(100);
            if (goUp && curFloor <= originalTargetFloor) {
                if (originalTargetFloor == waitFloor) {
                    stop();
                    openDoor();
                } else if (originalTargetFloor < waitFloor) {
                    // merge floors if two adjacent trips have same direct.
                    targetFloor = waitFloor;
                    up(targetFloor, originalTargetFloor);
                    System.out.println("Up, new target floor is "+targetFloor);
                } else {
                    requestQueueDown.offer(waitFloor);
                }
            }
        } else if (DOWN == curState) {
            setCurrentLoadWeight(100);
            if (!goUp && originalTargetFloor <= curFloor) {
                if (originalTargetFloor == waitFloor) {
                    stop();
                    openDoor();
                } else if (waitFloor < originalTargetFloor) {
                    targetFloor = waitFloor;
                    down(targetFloor, originalTargetFloor);
                    System.out.println("Down, new target floor is "+targetFloor);
                } else {
                    requestQueueUp.offer(waitFloor);
                }
            }
        }
        System.out.println("Log : requestQueueUp is "+requestQueueUp+ ". RequestQueueDown is "+requestQueueDown);
    }

    private void up(int targetFloor, int originalTargetFloor) {
        setCurrentState(UP);
        setTargetFloor(targetFloor);
        System.out.println("Up, target floor is "+targetFloor);
        while (currentFloor != targetFloor) {
            System.out.println("Up, curFloor is "+currentFloor);
            if (needStop(currentFloor, originalTargetFloor, UP)) {
                stop();
                openDoor();
                //System.out.println("=========Before=========> requestQueueUp " + requestQueueUp +"========>, requestQueueDown " +requestQueueDown);
                if (!requestQueueUp.isEmpty()) {
                    requestQueueUp.poll();
                    //System.out.println("=========After=========> requestQueueUp " + requestQueueUp +"========>, requestQueueDown " +requestQueueDown);
                    if (requestQueueUp.isEmpty() && !requestQueueDown.isEmpty()) {
                        System.out.println("====> Has another request in requestQueueDown !!!" + requestQueueDown);
                        if (targetFloor <= originalTargetFloor) {
                            up(originalTargetFloor, originalTargetFloor);
                        }
                        /*else {  // ???
                            down(targetFloor, originalTargetFloor);
                        }*/
                    }
                }
            }
            if (currentFloor == originalTargetFloor) {
                if (requestQueueUp.isEmpty() && !requestQueueDown.isEmpty()) {
                    List<Integer> myList = new ArrayList<>(requestQueueDown);
                    int target = myList.get(myList.size() - 1).intValue();
                    down(target, target);
                }
            }
            if (getCurrentLoadWeight() > 0) {
                if (checkTwoQueueEmpty(requestQueueUp, requestQueueDown, originalTargetFloor)) {
                    return;
                }
            }
            if (currentFloor < originalTargetFloor) {
                currentFloor++;
            }
        }

        if (currentFloor == targetFloor) {
            System.out.println("UP, curFloor is "+currentFloor);
            stop();
            openDoor();
            if (0 == getCurrentLoadWeight()) {
                personComeIn();
                if (!requestQueueUp.isEmpty() || !requestQueueDown.isEmpty()) {
                    List<Integer> myList1 = new ArrayList<>(requestQueueUp);  // bug
                    int target1 = myList1.get(myList1.size() - 1).intValue();
                    up(target1, originalTargetFloor);
                }
            } else {
                if (!requestQueueUp.isEmpty()) {
                    requestQueueUp.poll();
                }
                if (requestQueueUp.isEmpty() && !requestQueueDown.isEmpty()) {
                    if (originalTargetFloor > targetFloor) {
                        up(originalTargetFloor, originalTargetFloor);
                    }
                    // no need to go 1th floor or the top floor, go directly to the target floor of another direction
                    if (!requestQueueDown.isEmpty()) {
                        List<Integer> myList2 = new ArrayList<>(requestQueueDown);
                        int target2 = myList2.get(myList2.size() - 1).intValue();
                        down(target2, target2);
                    }
                }
            }
        }
    }

    private boolean checkTwoQueueEmpty(Queue<Integer> requestQueueUp, Queue<Integer> requestQueueDown, int originalTargetFloor) {
        if (requestQueueUp.isEmpty() && requestQueueDown.isEmpty()) {
            //STAND
            setCurrentState(STAND);
            int defaultFloor = defaultStandFloor;
            if (currentFloor == defaultFloor) {
                // do nothering
            } else if (currentFloor > defaultFloor) {
                down(defaultFloor, originalTargetFloor);
            } else {
                up(defaultFloor, originalTargetFloor);
            }
            System.out.println("The current state of the elevator is "+ STAND);
            System.out.println("============ Don't have any request. Ready go into STAND state.  ============ ");
            return true;
        }
        return false;
    }

    private void down(int targetFloor, int originalTargetFloor) {
        setCurrentState(DOWN);
        setTargetFloor(targetFloor);
        System.out.println("Down, target floor is "+targetFloor+", originalTargetFloor is " + originalTargetFloor);
        while (currentFloor != targetFloor) {
            System.out.println("Down, curFloor is "+currentFloor);
            System.out.println("==========> requestQueueUp : " + requestQueueUp +", requestQueueDown is " + requestQueueDown);
            if (needStop(currentFloor, originalTargetFloor, DOWN)) {
                stop();
                openDoor();
                if (!requestQueueDown.isEmpty()) {
                    requestQueueDown.poll();
                    if (requestQueueDown.isEmpty() && !requestQueueUp.isEmpty()) {
                        System.out.println("====> Has another request in requestQueueUp !!!"+ requestQueueUp);
                        if (targetFloor >= originalTargetFloor) {
                            down(originalTargetFloor, originalTargetFloor);
                        }
                    }
                }
            }
            if (currentFloor == originalTargetFloor) {
                if (requestQueueDown.isEmpty() && !requestQueueUp.isEmpty()) {
                    System.out.println("====> requestQueueUp outside : " + requestQueueUp);
                    List<Integer> myList = new ArrayList<>(requestQueueUp);
                    int target = myList.get(myList.size() - 1).intValue();
                    up(target, target);
                }
            }
            if (getCurrentLoadWeight() > 0) {
                if (checkTwoQueueEmpty(requestQueueUp, requestQueueDown, originalTargetFloor)) {
                    return;
                }
            }
            if (currentFloor > originalTargetFloor) {
                currentFloor--;
            }
        }

        if (currentFloor == targetFloor) {
            System.out.println("Down, curFloor is "+currentFloor);
            stop();
            openDoor();
            if (0 == getCurrentLoadWeight()) {
                personComeIn();
                if (!requestQueueDown.isEmpty() || !requestQueueUp.isEmpty()) {
                    //if (originalTargetFloor > targetFloor) { // Error
                        /*List<Integer> myList1 = new ArrayList<>(requestQueueDown);  // bug
                        int target1 = myList1.get(myList1.size() - 1).intValue();  // bug
                        down(target1, target1);  // target1 = 4 shoud call up()*/
                    //}
                    if (!requestQueueUp.isEmpty() && !requestQueueDown.isEmpty()) {
                        if (requestQueueUp.size() >= requestQueueDown.size()) {
                            List<Integer> myList1 = new ArrayList<>(requestQueueUp);  // bug
                            int target1 = myList1.get(myList1.size() - 1).intValue();
                            up(target1, target1);
                        } else {
                            List<Integer> myList2 = new ArrayList<>(requestQueueDown);  // bug
                            int target2 = myList2.get(myList2.size() - 1).intValue();
                            down(target2, target2);
                        }
                    }
                    if (!requestQueueUp.isEmpty() && requestQueueDown.isEmpty()) {
                        List<Integer> myList1 = new ArrayList<>(requestQueueUp);  // bug
                        int target1 = myList1.get(myList1.size() - 1).intValue();
                        up(target1, target1);
                    }
                    if (requestQueueUp.isEmpty() && !requestQueueDown.isEmpty()) {
                        List<Integer> myList2 = new ArrayList<>(requestQueueDown);  // bug
                        int target2 = myList2.get(myList2.size() - 1).intValue();
                        up(target2, target2);
                    }
                }
            } else {
                if (!requestQueueDown.isEmpty()) {
                    requestQueueDown.poll();
                }
                if (requestQueueDown.isEmpty() && !requestQueueUp.isEmpty()) {
                    if (originalTargetFloor > targetFloor) {
                        down(originalTargetFloor, originalTargetFloor);
                    }
                    // no need to go 1th floor or the top floor, go directly to the target floor of another direction
                    if (!requestQueueUp.isEmpty()) {
                        List<Integer> myList2 = new ArrayList<>(requestQueueUp);
                        int target2 = myList2.get(myList2.size() - 1).intValue();
                        up(target2, target2);
                    }
                }
            }

        }
    }

    /*private boolean checkNeedStop(int curFloor, int direction) {
        Queue<Integer> tempQueue = (UP == direction) ? requestQueueUp : requestQueueDown;
        if (!tempQueue.isEmpty()) {
            int headUp = tempQueue.peek();
            if (headUp == curFloor) {
                return true;
            }
        }
        return false;
    }*/

    private boolean needStop(int curFloor, int originalTargetFloor, int direction) {
        boolean result = false;
        //result = checkNeedStop(curFloor, direction);
        if (UP == direction) {
            if (!requestQueueUp.isEmpty()) {
                int headUp = requestQueueUp.peek();
                if (headUp == curFloor) {
                    return true;
                }
            }
        } else if (DOWN == direction) {
            if (!requestQueueDown.isEmpty()) {
                int headDown = requestQueueDown.peek();
                if (headDown == curFloor) {
                    return true;
                }
            }
        }

        if (getCurrentLoadWeight() > 0) {
            result = checkTwoQueueEmpty(requestQueueUp, requestQueueDown, originalTargetFloor);
        }

        return result;
    }

    private void stop() {
        System.out.println("====> Elevator stop! ");
    }

    private void openDoor() {
        System.out.println("====> Open door! ");
        try {
            Thread.sleep(closeDoorTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        closeDoor();
    }

    private void closeDoor() {
        System.out.println("====> Close door after " + (closeDoorTime/1000) + " second! ");
    }

    private void personComeIn() {
        setCurrentLoadWeight(600);
        Queue<Integer> unsortedRequestUp = new LinkedList<>();
        Queue<Integer> unsortedRequestDown = new LinkedList<>();
        unsortedRequestUp.offer(5);
        unsortedRequestUp.offer(3);
        unsortedRequestUp.offer(8);
        unsortedRequestDown.offer(10);
        unsortedRequestDown.offer(4);
        unsortedRequestDown.offer(6);
        List<Integer> sortUp = new ArrayList<>(unsortedRequestUp);
        Collections.sort(sortUp);
        List<Integer> sortDown = new ArrayList<>(unsortedRequestDown);
        Collections.sort(sortDown);
        Collections.sort(sortDown);
        for (int i = 0; i < sortUp.size(); i++) {
            requestQueueUp.offer(sortUp.get(i));
        }
        for (int i = (sortDown.size() - 1); i >= 0; i--) {
            requestQueueDown.offer(sortDown.get(i));
        }
        System.out.println("========> Sort of requestQueueUp " +requestQueueUp);
        System.out.println("========> Sort of requestQueueDown " +requestQueueDown);
        System.out.println("========> person Come In! ");
    }

    private void personGoOut() {
        setCurrentLoadWeight(0);
        System.out.println("========> person Go Out! ");
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

    public int getTargetFloor() {
        return targetFloor;
    }

    public void setTargetFloor(int targetFloor) {
        this.targetFloor = targetFloor;
    }

    public int getCurrentLoadWeight() {
        return currentLoadWeight;
    }

    public void setCurrentLoadWeight(int currentLoadWeight) {
        this.currentLoadWeight = currentLoadWeight;
    }
}
