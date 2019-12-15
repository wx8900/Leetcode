package systemdesign.elevator;

import java.util.*;

/**
 * Elevator New Design 2
 *
 * @author Jeff
 * @date   01/09/2019
 *
 */

public class Elevator9 {
    public static final int MAINTENANCE = 0;
    public static final int STAND = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;
    public static final int closeDoorTime = 1000;
    public static final int defaultStandFloor = 5;

    private int minFloor;
    private int maxFloor;
    private int currentFloor;
    private int currentState;
    private int currentLoadWeight;
    private int targetFloor;
    private Queue<Integer> requestQueueUp = new LinkedList<>();
    private Queue<Integer> requestQueueDown = new LinkedList<>();

    /** Construction */
    public Elevator9(int minFloor, int maxFloor, int currentState,
                     Queue<Integer> requestQueueUp, Queue<Integer> requestQueueDown) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.currentState = currentState;
        this.requestQueueUp = requestQueueUp;
        this.requestQueueDown = requestQueueDown;
        this.currentFloor = defaultStandFloor;
        this.targetFloor = 0;
        this.currentLoadWeight = 0;
    }



    public void addWaitingFloor(int waitFloor, boolean goUp) {
        int curState = getCurrentState();
        int curFloor = getCurrentFloor();
        System.out.println("curState is "+curState+", curFloor is "+curFloor);
        if (MAINTENANCE == curState) {
            System.out.println("This elevator is not available !");
        }
        // if the elevator is stand state, call this elevator goes to this floor
        else if (STAND == curState) {
            setCurrentLoadWeight(0);
            if (curFloor == waitFloor) {
                stopProcess(true);
            } else if (curFloor < waitFloor) {
                up(waitFloor);
            } else {
                down(waitFloor);
            }
        } else if (UP == curState) {
            setCurrentLoadWeight(100);
            if (!goUp) {
                requestQueueDown.offer(waitFloor);
            } else {
                checkAddQueue(curFloor, waitFloor);
            }
        } else if (DOWN == curState) {
            setCurrentLoadWeight(100);
            if (goUp) {
                requestQueueUp.offer(waitFloor);
            } else {
                checkAddQueue(curFloor, waitFloor);
            }
        }
        System.out.println("Log : requestQueueUp is "+requestQueueUp+ ". RequestQueueDown is "+requestQueueDown);
    }

    private void checkAddQueue(int curFloor, int waitFloor) {
        if (curFloor == waitFloor) {
            stopProcess(false);
        } else if (curFloor < waitFloor) {
            requestQueueUp.offer(waitFloor);
        } else {
            requestQueueDown.offer(waitFloor);
        }
    }

    private void stopProcess(boolean onlyLoadOnce) {
        stop();
        openDoor();
        if (onlyLoadOnce) {
            personComeInOrOut();
        }
        closeDoor();
    }

    private void up(int targetFloor) {
        setCurrentState(UP);
        setTargetFloor(targetFloor);
        System.out.println("Up, target floor is "+targetFloor);
        while (currentFloor != targetFloor) {
            System.out.println("Up, curFloor is "+currentFloor);
            if (needStop(currentFloor, UP)) {
                stopProcess(false);
                System.out.println("=========Before=========> requestQueueUp " + requestQueueUp +"========>, requestQueueDown " +requestQueueDown);
                if (!requestQueueUp.isEmpty()) {
                    requestQueueUp.poll();
                    System.out.println("=========After=========> requestQueueUp " + requestQueueUp +"========>, requestQueueDown " +requestQueueDown);
                    if (requestQueueUp.isEmpty() && !requestQueueDown.isEmpty()) {
                        System.out.println("====> Has another request in requestQueueDown !!!" + requestQueueDown);
                        List<Integer> myList = new ArrayList<>(requestQueueDown);
                        int target = myList.get(myList.size() - 1).intValue();
                        down(target);
                    }
                }
            }
            if (getCurrentLoadWeight() > 0) {
                if (checkTwoQueueEmpty(requestQueueUp, requestQueueDown)) {
                    stop();
                }
            }
            if (currentFloor < targetFloor) {
                currentFloor++;
            }
        }

        if (currentFloor == targetFloor) {
            System.out.println("UP, curFloor is "+currentFloor);
            if (0 == getCurrentLoadWeight()) {
                stopProcess(true);
                processMove();
            } else {
                if (!requestQueueUp.isEmpty()) {
                    requestQueueUp.poll();
                }
                System.out.println("======requestQueueUp===="+requestQueueUp +"======requestQueueDown===="+requestQueueDown);
                stopProcess(false);
                processMove();
            }
        }
    }

    private void processMove() {
        List<Integer> myList1 = new ArrayList<>(requestQueueUp);
        List<Integer> myList2 = new ArrayList<>(requestQueueDown);
        if (!requestQueueUp.isEmpty() && !requestQueueDown.isEmpty()) {
            if (requestQueueUp.size() >= requestQueueDown.size()) {
                int headUp = requestQueueUp.peek();
                if (currentFloor > headUp) {
                    down(headUp);
                } else {
                    up(headUp);
                }
            } else {
                int headDown = requestQueueDown.peek();
                if (currentFloor > headDown) {
                    down(headDown);
                } else {
                    up(headDown);
                }
            }
        } else if (!requestQueueUp.isEmpty() && requestQueueDown.isEmpty()) {
            int headUp = requestQueueUp.peek();
            if (currentFloor > headUp) {
                down(headUp);
            } else {
                up(headUp);
            }
        } else if (requestQueueUp.isEmpty() && !requestQueueDown.isEmpty()) {
            int target = requestQueueDown.peek();
            if (currentFloor == target) {
                int target2 = myList2.get(myList2.size() - 1).intValue();
                down(target2);
            } else if (currentFloor < target) {
                up(target);
            } else {
                down(target);
            }
        } else {
            if (getCurrentLoadWeight() > 0) {
                openDoor();
                stop();
                System.out.println(" Waiting for person to click the button !!!");
            } else {
                if (checkTwoQueueEmpty(requestQueueUp, requestQueueDown)) {
                    readyToStand();
                }
            }
        }
    }

    private boolean checkTwoQueueEmpty(Queue<Integer> requestQueueUp, Queue<Integer> requestQueueDown) {
        if (requestQueueUp.isEmpty() && requestQueueDown.isEmpty()) {
            System.out.println(" *********** Current state is "+ STAND+". Don't have any request, ready go into STAND state.");
            return true;
        }
        return false;
    }

    private void readyToStand() {
        setCurrentState(STAND);
        int defaultFloor = defaultStandFloor;
        if (currentFloor == defaultFloor) {
            // do nothering
        } else if (currentFloor > defaultFloor) {
            down(defaultFloor);
        } else {
            up(defaultFloor);
        }
    }

    private void down(int targetFloor) {
        setCurrentState(DOWN);
        setTargetFloor(targetFloor);
        System.out.println("Down, target floor is "+targetFloor);
        while (currentFloor != targetFloor) {
            System.out.println("Down, curFloor is "+currentFloor);
            System.out.println("==========> requestQueueUp : " + requestQueueUp +", requestQueueDown is " + requestQueueDown);
            if (needStop(currentFloor, DOWN)) {
                stopProcess(false);
                if (!requestQueueDown.isEmpty()) {
                    requestQueueDown.poll();
                    if (requestQueueDown.isEmpty() && !requestQueueUp.isEmpty()) {
                        System.out.println("====> Has another request in requestQueueUp !!!"+ requestQueueUp);
                        List<Integer> myList1 = new ArrayList<>(requestQueueUp);
                        int target1 = myList1.get(myList1.size() - 1).intValue();
                        up(target1);
                    }
                }
            }
            if (getCurrentLoadWeight() > 0) {
                if (checkTwoQueueEmpty(requestQueueUp, requestQueueDown)) {
                    stop();
                }
            }
            if (currentFloor > targetFloor) {
                currentFloor--;
            }
        }

        if (currentFloor == targetFloor) {
            System.out.println("Down, curFloor is "+currentFloor);
            if (0 == getCurrentLoadWeight()) {
                stopProcess(true);
                processMove();
            } else {
                if (!requestQueueDown.isEmpty()) {
                    requestQueueDown.poll();
                }
                stopProcess(false);
                processMove();
            }
        }
    }

    private boolean needStop(int curFloor, int direction) {
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
            result = checkTwoQueueEmpty(requestQueueUp, requestQueueDown);
        }

        return result;
    }

    private void stop() {
        System.out.println("====> Elevator stop at " + currentFloor+" floor !");
    }

    private void openDoor() {
        //System.out.println("====> Open door! ");
        try {
            Thread.sleep(closeDoorTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void closeDoor() {
        //System.out.println("====> Close door after " + (closeDoorTime/1000) + " second! ");
    }

    private void personComeInOrOut() {
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
