package systemdesign.parkinglot;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Google, Facebook, Amazon都会考的系统设计 -- Design a parking Lot
 *
 * @author Jeff
 * @date 2019/3/26 21:37
 * Success
 *
 * @version V3.0
 * @date 2019/3/27 02:20
 * fix bug that spot id will change when retrieve a vehicle and place
 * another vehicle again because vehicle size didn't binding with the spot.
 *
 * @version V4.0
 * @date 2019/4/6 7:50
 * merge code into one method getSpotByRandom(), add SizeEnum
 *
 * public String generateSecretToken() {
 *      SecureRandom secRandom = new SecureRandom();
 *      byte[] result = new byte[32];
 *      secRandom.nextBytes(result);
 *      return Hex.encodeHexString(result);
 * }
 */
@SuppressWarnings("ALL")
public class ParkingLot {

    public static final int MOTOR_CAPACITY = 1;
    public static final int CAR_CAPACITY = 2;
    public static final int TRUCK_CAPACITY = 1;
    public static final int BUS_CAPACITY = 1;
    public static final int TOTAL_CAPACITY = MOTOR_CAPACITY + CAR_CAPACITY
            + TRUCK_CAPACITY + BUS_CAPACITY;
    private Stack<Spot> motorStack;
    private Stack<Spot> carStack;
    private Stack<Spot> truckStack;
    private Stack<Spot> busStack;
    private Map<Integer, Vehicle> map;
    private List<Spot> spotList;

    /**
     * initialization of parking lot according to size
     */
    public ParkingLot() {
        spotList = new ArrayList<>(TOTAL_CAPACITY);
        Spot spot;
        for (int i = 0; i < MOTOR_CAPACITY; i++) {
            spot = new Spot(i, true);
            spotList.add(spot);
        }
        final int sum = MOTOR_CAPACITY + CAR_CAPACITY;
        for (int j = MOTOR_CAPACITY; j < sum; j++) {
            spot = new Spot(j, true);
            spotList.add(spot);
        }
        for (int k = sum; k < sum + TRUCK_CAPACITY; k++) {
            spot = new Spot(k, true);
            spotList.add(spot);
        }
        for (int m = sum + TRUCK_CAPACITY;
             m < sum + TRUCK_CAPACITY + BUS_CAPACITY; m++) {
            spot = new Spot(m, true);
            spotList.add(spot);
        }
        motorStack = new Stack<>();
        carStack = new Stack<>();
        truckStack = new Stack<>();
        busStack = new Stack<>();
        map = new HashMap<>();

        for (Spot aList : spotList) {
            System.out.println("initialization " + aList.toString());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot();
        Vehicle v1 = new Vehicle(5, "WA 10086", "Black", SizeEnum.S);
        Spot spot1 = pl.placeVehicle(v1);
        printLog(v1, spot1);
        Vehicle v2 = new Vehicle(58, "CA 19268", "Rad", SizeEnum.S);
        Spot spot2 = pl.placeVehicle(v2);
        printLog(v2, spot2);
        Vehicle v3 = new Vehicle(33, "DC 29388", "Yellow", SizeEnum.S);
        Spot spot3 = pl.placeVehicle(v3);
        printLog(v3, spot3);
        Vehicle v4 = new Vehicle(12, "NY 39456", "Pink", SizeEnum.S);
        Spot spot4 = pl.placeVehicle(v4);
        printLog(v4, spot4);
        System.out.println("********** Retrieve vehicle by id : " + spot1.getId());
        Vehicle returnV = pl.retrieveVehicle(spot1.getId());
        System.out.println("********** The vehicle you retrieve is : " + returnV.toString());
        System.out.println();
        Vehicle v5 = new Vehicle(30, "OR 99918", "White", SizeEnum.S);
        Spot spot5 = pl.placeVehicle(v5);
        printLog(v5, spot5);
        Vehicle v6 = new Vehicle(10, "CA 30001", "Blue", SizeEnum.M);
        Spot spot6 = pl.placeVehicle(v6);
        printLog(v6, spot6);
    }

    private static void printLog(Vehicle v1, Spot spot1) {
        System.out.println("Your " + v1.toString() + " park at =========> spot " + spot1.getId());
        System.out.println();
    }

    /**
     * retrieve vehicle by spotId
     * release three resources: stack, map and spot
     *
     * @param spotId id of spot
     * @return Vehicle
     */
    public Vehicle retrieveVehicle(int spotId) {
        if (spotId >= 0 && spotId < TOTAL_CAPACITY) {
            Vehicle vehicle = new Vehicle();
            if (map.containsKey(spotId)) {
                vehicle = map.get(spotId);
                if (vehicle != null) {
                    releaseStack(vehicle);
                    map.remove(spotId, vehicle);
                    for (Spot spot : spotList) {
                        if (spotId == spot.getId()) {
                            spot.setEmpty(true);
                        }
                    }
                    System.out.println("********** Have found your vehicle.");
                } else {
                    System.out.println("******************** Sorry, we didn't find your vehicle by input spotId : " + spotId);
                }
            } else {
                System.out.println("******************** This spotId never use, please input again!" + spotId);
            }
            return vehicle;
        } else {
            throw new IllegalArgumentException("The spotId you input is valid!!!");
        }
    }

    private void releaseStack(Vehicle vehicle) {
        switch (vehicle.getSize()) {
            case S:
                if (!motorStack.isEmpty()) {
                    motorStack.pop();
                }
                System.out.println("********** Size of motorStack is : " + motorStack.size());
                break;
            case M:
                if (!carStack.isEmpty()) {
                    carStack.pop();
                }
                System.out.println("********** Size of carStack is : " + carStack.size());
                break;
            case L:
                if (!truckStack.isEmpty()) {
                    truckStack.pop();
                }
                System.out.println("********** Size of truckStack is : " + truckStack.size());
                break;
            case XL:
                if (!busStack.isEmpty()) {
                    busStack.pop();
                }
                System.out.println("********** Size of busStack is : " + busStack.size());
                break;
            default:
                System.out.println("******************** It has a error in size matching when retrieve vehicle!!!");
                break;
        }
    }

    /**
     * place vehicle
     *
     * @param vehicle Vehicle
     * @return Spot
     */
    public Spot placeVehicle(Vehicle vehicle) {
        Spot spot = new Spot();
        if (vehicle == null || vehicle.getSize() == null) {
            return spot;
        }

        switch (vehicle.getSize()) {
            case S:
                spot = pushMotorStack(vehicle);
                break;
            case M:
                spot = pushCarStack(vehicle);
                break;
            case L:
                spot = pushTruckStack(vehicle);
                break;
            case XL:
                spot = pushBusStack(vehicle);
                break;
            default:
                System.out.println("It has a error in size matching when place a vehicle!!!");
                break;
        }

        return spot;
    }

    private Spot getSpotByRandom(int minCapacity, int maxCapacity, Vehicle vehicle) {
        Spot spot;
        int random = getRealRandom(minCapacity, maxCapacity - 1);
        spot = spotList.get(random);
        while (!spot.isEmpty()) {
            random = getRealRandom(minCapacity, maxCapacity - 1);
            spot = spotList.get(random);
        }
        map.put(spot.getId(), vehicle);
        spot.setEmpty(false);
        return spot;
    }

    private Spot pushMotorStack(Vehicle vehicle) {
        System.out.print("Size of motorStack is : " + motorStack.size() + ". ");
        Spot spot;
        if (motorStack.size() < MOTOR_CAPACITY) {
            spot = getSpotByRandom(0, MOTOR_CAPACITY, vehicle);
            motorStack.push(spot);
            System.out.println("You can park at a motorcycle spot.");
        } else {
            System.out.println("Warning : All spots of motorcycle are full! You may park at car spots.");
            spot = pushCarStack(vehicle);
        }
        return spot;
    }

    private Spot pushCarStack(Vehicle vehicle) {
        System.out.print("Size of carStack is : " + carStack.size() + ". ");
        Spot spot;
        if (carStack.size() < CAR_CAPACITY) {
            spot = getSpotByRandom(MOTOR_CAPACITY, MOTOR_CAPACITY + CAR_CAPACITY, vehicle);
            carStack.push(spot);
            System.out.println("You can park at a car spot.");
        } else {
            System.out.println("Warning : All spots of car are full! You may park at truck spots.");
            spot = pushTruckStack(vehicle);
        }
        return spot;
    }

    private Spot pushTruckStack(Vehicle vehicle) {
        System.out.print("Size of truckStack is : " + truckStack.size() + ". ");
        Spot spot;
        if (truckStack.size() < TRUCK_CAPACITY) {
            int minCapacity = MOTOR_CAPACITY + CAR_CAPACITY;
            spot = getSpotByRandom(minCapacity, minCapacity + TRUCK_CAPACITY, vehicle);
            truckStack.push(spot);
            System.out.println("You can park at a truck spot.");
        } else {
            System.out.println("Warning : All spots of truck are full! You may park at bus spots.");
            spot = pushBusStack(vehicle);
        }
        return spot;
    }

    private Spot pushBusStack(Vehicle vehicle) {
        System.out.print("Size of busStack is : " + busStack.size() + ". ");
        Spot spot = new Spot();
        if (busStack.size() < BUS_CAPACITY) {
            int minCapacity = MOTOR_CAPACITY + CAR_CAPACITY + TRUCK_CAPACITY;
            spot = getSpotByRandom(minCapacity, minCapacity + BUS_CAPACITY, vehicle);
            busStack.push(spot);
            System.out.println("You can park at a bus spot.");
        } else {
            System.out.println("Warning : All spots of bus are full! Please choose another time to park your vehicle.");
        }
        return spot;
    }

    private int getRealRandom(int min, int max) {
        return ThreadLocalRandom.current().nextInt(max - min + 1) + min;
    }

}
