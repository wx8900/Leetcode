package systemdesign.elevator;

import java.util.ArrayList;
import java.util.List;

/**
 *  01/07/2018
 *  Three Object Class: Building, Elevator, Person
 *  Five Actions for Elevator Class: up(), down(), stop(), move(), alarmAlert()
 */

public class Test {

    public static void main(String[] str) {
        Building building = new Building(1, "Town Hall", -3, 10);
        Elevator elevator = new Elevator(1,"East", 1000, 1);
        Person person1 = new Person(11, "Tom", 100, 3);
        Person person2 = new Person(23, "John", 80, 7);
        Person person3 = new Person(56, "Alex", 160,8);

        List<Person> passagerList = new ArrayList<>();
        passagerList.add(person1);
        passagerList.add(person2);
        passagerList.add(person3);

        int startLayer = -3; // number 1 means the first/ground floor
        int targetLayer = 8;
        elevator.move(building, elevator, passagerList, startLayer, targetLayer);
    }

}
