package de.tum.in.ase.studentdorm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Building {
    /**
     * This class represents our student dorm building.
     */

    //      attributes
    private final Person[] peopleOnFloor;
    private final Elevator elevator;

    //      constructors
    public Building(int numberOfFloors, Elevator elevator) {
        if (numberOfFloors < 5) {
            throw new IllegalArgumentException("IllegalArgumentException: Number of floors cannot be lower than 5");
        }
        peopleOnFloor = new Person[numberOfFloors];
        this.elevator = elevator;
    }

    public Building(int numberOfFloors) {
        this(numberOfFloors, new Elevator(numberOfFloors - 1));
    }

    //      getters
    public Person[] getPeopleOnFloor() {
        return peopleOnFloor;
    }

    public Elevator getElevator() {
        return elevator;
    }

    /**
     * This method operates the elevator. It will move, open and close the doors as long as necessary in order to fulfill
     * every passenger request.
     */
    public void operateElevator() {

        while (true) {
            elevator.move();
            boolean passengerInsideElevator = elevator.openDoor(peopleOnFloor[elevator.getCurrentFloor()]);
            if (passengerInsideElevator) {
                peopleOnFloor[elevator.getCurrentFloor()] = null;
            }
            elevator.closeDoor();
            if (elevator.getDirection() == Direction.IDLE) {
                break;
            }
        }
         elevator.printSequence();
         System.out.println("Elevator finished on " + elevator.getCurrentFloor());
    }

    /**
     * This method is used before operating the elevator. It basically prepares the stops which will be visited
     * by the elevator. People waiting on the floors are taken into consideration when filling the lists. The lists are then
     * used to create a new Stops object for elevator.Do not forget that the elevator always starts on floor 0, so the lists
     * have to be sorted accordingly. It is advisable for you to orient yourself on the SCAN algorithm.
     */
    public void processRequests() {
        List<Integer> up = new ArrayList<>();
        List<Integer> down = new ArrayList<>();

        for (int i = 0; i < peopleOnFloor.length; i++) {
            if (peopleOnFloor[i] != null) {
                Direction directionOfPerson = Direction.computeDirection(i, peopleOnFloor[i].getDestinationFloor());

                if (directionOfPerson == Direction.UP) {
                       up.add(i);
                       up.add(peopleOnFloor[i].getDestinationFloor());
                } else {
                    //if (!up.contains(i)) {
                        down.add(i);
                    //}
                       down.add(peopleOnFloor[i].getDestinationFloor());

                }
            }
        }


        ArrayList<Integer> downStops = down.stream()
                .distinct()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toCollection(ArrayList::new));


        ArrayList<Integer> upStops = up.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));



        Stops newStops = new Stops(upStops, downStops);

        elevator.setStops(newStops);

    }

    /**
     * This method can be used to initialize some standard values in order to test the implementation locally.
     */
    public void setupPeopleWaiting() {

        peopleOnFloor[1] = new Person(0);
        peopleOnFloor[0] = new Person(1);
        //peopleOnFloor[2] = new Person(5);

    }


    public static void main(String[] args) {
        Elevator elevator = new Elevator(5, 2);
        Building building = new Building(6, elevator);
        building.setupPeopleWaiting();
        building.processRequests();
        building.operateElevator();

        //testElevator.move();
        //testElevator.printSequence();


    }

}
