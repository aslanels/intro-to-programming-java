package de.tum.in.ase.studentdorm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Elevator {
    private static final int DEFAULT_CAPACITY = 15;
    private final List<Integer> sequence;
    private final List<Person> passengers;
    private final int capacity;
    private final int maxFloor;
    private int currentFloor;
    private Direction direction;
    private Stops stops;


    public Elevator(int maxFloor, int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity should be positive");
        } else {
            this.capacity = capacity;
        }
        if (maxFloor < 4) {
            throw new IllegalArgumentException("Max Floor cannot be lower than 4");
        } else {
            this.maxFloor = maxFloor;
        }

        sequence = new ArrayList<>();
        passengers = new ArrayList<>();
        direction = Direction.IDLE;
        stops = new Stops();

    }

    public Elevator(int maxFloor) {
        this(maxFloor, DEFAULT_CAPACITY);
    }

    /**
     * update currentFloor depending on the direction of the elevator:
     * if UP or DOWN -> increment by 1 accordingly
     * if IDLE -> check if any more stops left -> change to UP if there are
     * @return true if currentFloor is a stop, false otherwise
     */
    public boolean changeFloor() {
        if (direction == Direction.UP) {
            currentFloor++;
            return currentFloor == stops.getNextStop(Direction.UP, 0);
        } else if (direction == Direction.DOWN) {
            currentFloor--;
            return currentFloor == stops.getNextStop(Direction.DOWN, 0);
        } else {
            if (!stops.isEmpty(Direction.UP) || !stops.isEmpty(Direction.DOWN)) {
                direction = Direction.UP;
            }
            //    return true if 0 is a stop
            return stops.getStopsUp().contains(0);
        }
    }


    /**
     * change floors until arriving at a stop
     * update sequence accordingly
     */
    public void move() {
        while (true) {
            boolean currentFloorIsAStop = changeFloor();
            if (currentFloorIsAStop) {
                break;
            }
        }
        sequence.add(currentFloor);

    }

    /**
     *
     * @param person waiting on peopleOnFloor on the currentFloor
     * @return true if the person gets inside the elevator
     */
    public boolean openDoor(Person person) {

        passengers.removeIf(p -> p.getDestinationFloor() == currentFloor);

        if (direction == Direction.UP) {
            if (!stops.isEmpty(Direction.UP)) {
                stops.remove(Direction.UP, 0);
            }
        } else if (direction == Direction.DOWN) {
            stops.remove(Direction.DOWN, 0);
        }

        if (person == null) {
            return false;
        } else {
            if (capacity == passengers.size()) {
                Person removedPerson;
                passengers.add(person);
                passengers.sort(Comparator.comparingInt(p -> p.computeDistance(currentFloor)));

                var p0 = passengers.get(0).computeDistance(currentFloor);
                var p1 = passengers.get(1).computeDistance(currentFloor);

                // if two lowest passengers have the same absolute distance

                if (p0 == p1) {

                   var d0 = passengers.get(0).getDestinationFloor();
                   var d1 = passengers.get(1).getDestinationFloor();

                   // remove the one that has to go the lower floor (i.e. down)
                   if (d0 > d1) {
                       removedPerson = passengers.remove(1);
                   } else {
                       removedPerson = passengers.remove(0);
                   }

                   // if no equality remove the lowest one
                } else {
                    removedPerson = passengers.remove(0);
                }

                // if the person on the floor is taken as a passenger (i.e. someone else is thrown out) return true
                return !removedPerson.getName().equals(person.getName());

            } else {
                passengers.add(person);
                passengers.sort(Comparator.comparingInt(p -> p.computeDistance(currentFloor)));

                return true;
            }

        }

    }

    /**
     * stop operating if all stops visited & all passengers left
     * otherwise reverse direction if arrived at final stop
     */
    public void closeDoor() {

        boolean visitedAllStops = stops.isEmpty(Direction.UP) && stops.isEmpty(Direction.DOWN);

        boolean passengersLeftElevator = passengers.isEmpty();

        if (visitedAllStops && passengersLeftElevator) {
            direction = Direction.IDLE;
            return;
        }

        if (stops.isEmpty(direction)) {
            direction = Direction.getReverseDirection(direction);
            if (!stops.isEmpty(Direction.DOWN) && currentFloor < stops.getNextStop(Direction.DOWN, 0)) {
                currentFloor = stops.getNextStop(Direction.DOWN, 0) + 1;
            }


        }

    }

    public void printSequence() {
        System.out.print("Elevator stopped on floors: ");
        for (Integer s: sequence) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    /**
     *      getters and setters
     */

    public List<Integer> getSequence() {
        return sequence;
    }

    public List<Person> getPassengers() {
        return passengers;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Stops getStops() {
        return stops;
    }

    public void setStops(Stops stops) {
        this.stops = stops;
    }


}
