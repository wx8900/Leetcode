package systemdesign.elevator;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  01/08/2018
 *  Three Object Class: Building, Elevator, Person
 *  Five Actions for Elevator Class: up(), down(), stop(), move(), alarmAlert()
 */

public class Test8 {

    public static void main(String[] str) {
        Building building = new Building(1, "Bellevue City Hall", 1, 10);

        Queue<Integer> requestQueue = new LinkedList<>();
        requestQueue.offer(3);
        requestQueue.offer(5);
        requestQueue.offer(8);
        //requestQueue.offer(10);
        //requestQueue.offer(6);
        //requestQueue.offer(10);

        Elevator8 elevator = new Elevator8(1, 20,requestQueue, 1, Elevator8.UP);

        elevator.addWaitingFloor(9, true);

        /*Person person1 = new Person(11, "Tom", 100);
        Person person2 = new Person(23, "John", 80);
        Person person3 = new Person(56, "Alex", 160);
        List<Person> passagerList = new ArrayList<>();
        passagerList.add(person1);
        passagerList.add(person2);
        passagerList.add(person3);*/
    }

}
