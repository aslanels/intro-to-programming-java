# H08E02 - Elevator

Christmas is right around the corner, which means that everyone is in rush to go shopping and find gifts for their friends and family. At the start of the holiday season, the elevator of your student dorm suddenly broke down leaving many students frustrated. Others in the dorm know that you have been diligently attending ITP lectures for the last few weeks and have put you in charge of the situation. It is up to you to fix the elevator using your programming knowledge and problem-solving skills while orienting yourself on the already implemented [SCAN algorithm](https://www.geeksforgeeks.org/scan-elevator-disk-scheduling-algorithms/) used in Hard Drives (HDDs).

## Project Structure

In the template repository folder src/de/in/tum/ase, you can find the packages: hdd and studentdorm. The package hdd consists of a file HardDrive.java and RotationDirection.java. You do not need to change anything in these two files. In the package studentdorm you can find the files Building.java, Direction.java, Person.java, and Stops.java. It is your job to complete the classes Building and Stops. You will also have to create and implement the Elevator class. You will find //TODOs.. pointing out to you where some code is missing. Nevertheless, please make sure to read the problem statement, since not everything will be explained in the TODOs!

Note: do NOT change anything in the classes we provided you with unless you are told to.

### Part 1: The SCAN algorithm for search scheduling on hard drives

What you should mainly take away from this is the fact, that algorithms can be used in different application environments. In our specific case, the algorithm that can be used to schedule searches on a hard drive can also be used for scheduling elevator calls (of course this requires some minor adaptations to match the new application environment). So to get hands on your actual task again: you are lucky! You've been given access to an implementation of a SCAN algorithm for scheduling searches on HDDs and fortunately the principles of this algorithm also work for scheduling the elevator.

In order to accomplish your tasks necessary to fix the elevator, it is crucial to get familiar with the provided algorithm in the package hdd. Go through the code and try to understand what is happening in each and every step.

### Part 2: Implement the elevator algorithm

Now that you got familiar with the algorithm you should be ready to get started with the implementation. You probably already have a basic idea about how an elevator works, but to refresh and expand on your knowledge we recommend you watch this video. To simplify the exercise, we will generalize it by having the elevator always start at the bottom floor (floor 0). On each floor, a maximum of one person is waiting for the elevator. We will use stops to represent landing and car calls in the upward and downward directions. The stops are computed before the elevator starts to move for the first time. We can assume that the floor that a person wants to go to is different from the one he or she is currently on. This means the elevator should stop on the floor a person is waiting and on the destination floor of this person. Keep in mind that people only get picked up, when the elevator is traveling in the same direction as their destination. When the door of the elevator opens (e.g. a passenger can leave) the person that was waiting enters the elevator, regardless of the direction of the elevator.

Note: There is one important difference between the SCAN and our elevator algorithm: SCAN always travels to the edge, no matter if there is an element present or not. Our elevator moves until it reaches the last stop in the given direction and then reverses the direction.

You have the following tasks:

### The Class Elevator

1. **Create Class and add attributes**

   Your first task is to create a new Elevator class in the studentdorm package. The class has a constant DEFAULT_CAPACITY which should have the value 15. Use the necessary modifiers to declare this field as a constant. Look at the UML diagram below and add the missing attributes to the class. Some of the attributes are initialized once and do not change their values (think about what that means in terms of modifiers), whereas others change the value often. This should be considered when deciding on attribute modifiers. Also keep in mind, that collection objects (e.g. lists) stay the literally same object even though their content might change. Make sure to also add getters and setters to each attribute. In the following tasks, you can ignore capacity, it is only relevant for the optional task in the end. This attribute should be implemented, but you don't need to work with it for now.

   Note: Think about the relation (and differences) between the constant DEFAULT_CAPACITY and the attribute capacity. In which case would you use the constant?

2. **Elevator constructors**

   Important: refer to the UML diagram. The constructor that only takes one parameter should initialize capacity with a predefined constant. Try to avoid duplicate code by calling a constructor by another constructor of the same class. Do not forget to initialize the direction of the elevator, in the beginning, the elevator goes in neither of the directions. When the elevator is created, the stops should be empty, so make sure to use one of the constructors from class Stops to initialize the attribute.
   You also have to take care of error handling. Think about what kind of values capacity should be allowed to have and throw an IllegalArgumentException in case the capacity argument is not reasonable.

3. **Implement changeFloor()**

   The method changeFloor() updates the attribute currentFloor, depending on the direction of the elevator. To start we will only implement the first part of the method: updating floors according to the direction of the elevator. You don't need to handle the case of the elevator being idle yet. In order to complete the changeFloor() method, you will first have to finish (and understand) the Stops class, since you will need its functionality. We'll get back to this method later. For now, the method should always return true.

4. **Implement move()**

   The elevator starts moving when the move() method is called. The elevator changes floors using the (just) implemented method until arriving at a stop. This arrivial will get indicated by changeFloor: Stop changing floor once this method returns true. Update the sequence attribute after arriving at the stop by adding the current floor to the list. Note: beware that the tests for this method can only be passed completely when the changeFloor() method is implemented completely and correctly!

5. **Add methods openDoor and closeDoor**

   Refer to the UML diagram below for the signature. We will take care about the implementation a bit later.

6. **Record your stops**

   You can add another method called printSequence to print the content of the sequence attribute. This method is primarily a helper for you. You can use it to test your implementation. We will NOT test the output of this method. The test for this method will NOT count toward your overall score.

### The Class Stops

The class acts as a wrapper, the methods are already implemented and are functioning. The only thing left for you is to handle illegal arguments. More information in the task down below. Take a look at the class and try to understand what exactly it is doing. The first element of the list is the one that will be visited first by the elevator. Take the currently relevant direction into consideration.

1. **Optional: Error handling**
   **This part is optional, you can earn up to 3 bonus points by completing this task.**
   Extend the methods isEmpty(), remove(), addStop() and getNextStop() so they check for illegal arguments. Make sure to check all passed arguments. Throw an IllegalArgumentException in case of illegal arguments. When checking the index argument that's passed for most of the methods, think about what values could lead to issues in the method. It also should be considered an illegal state if any method from Stops is called while the direction is IDLE. Both arguments should be checked independently.

   Note: although not part of the tests, you should add meaningful error messages to your exceptions.

2. **Implement changeFloor() of class Elevator**
   Now that you have an idea how stops work, finish the method changeFloor() so it checks if the elevator should stop at the current floor. Return true if the elevator should stop, false otherwise. You already handled the cases of the direction being UP or DOWN earlier. In case the direction is different from that, you should check if there are more upcoming stops in the upwards or downwards direction. In case there are still stops to be made, set the direction from IDLE to UP. Here make sure to only check if there is a stop to be made and do not change the currentFloor of the elevator. You probably already noticed, that the return type for this method is boolean. You should implement the method in a way, that it returns if the elevator has a stop on the current floor. For that take the corresponding list of stops from Stops into consideration.

### The Class Building

1. **Add attributes to Building**

   The attribute peopleOnFloor is initialized once in the constructor and more importantly, the used reference should not be changeable. On each floor, a person can be waiting for the elevator. This array indicates how many persons are waiting on each floor. Make sure to also add getters and setters as usual.

2. **Building Constructors**

   Implement the class constructors according to the UML diagram. Take into account that according to German law, buildings with fewer than 5 floors should not be allowed to have an elevator. Check the passed argument and throw an IllegalArgumentException as you did in previous tasks.

   Important: try to avoid duplicate code by calling a constructor by another constructor of the same class.

3. **Finish operateElevator()**

   The method should run until the direction of the elevator is IDLE again (note: the direction will be updated within in the closeDoors() method). First, the elevator should move, afterwards, it should open its doors. Afterwards, the elevator closes the doors. In the end of this method would be a good time to print out your sequence. However, as we stated earlier this will NOT be tested. So this is purely for you to test your implementation.

### Important Finishing Touches

1. **Implement openDoor() of class Elevator**

   When the doors are opened, people with destinationFloor same as the current floor leave the elevator (are removed from the passengers list). Also, make sure you keep the lists in Stops up to date, so there will be no interferences for the next stop (think about which method from the Stops class might be useful for this). After that, you should check if there is a person waiting on the floor (think about how that might be related to the argument of this method and where this method will be used). If so, it is added to the list and the method returns, if not the method also returns. Since this method is of return type boolean think about which return value is appropriate in which case.

2. **Implement the method closeDoor()**

   After the door has been opened, it also needs to be closed. Here it is checked if the elevator visited all stops in the stops lists and if all passengers left the elevator. If this is the case, the elevator stops operating and the method returns. Otherwise, it is checked if the list in the direction the elevator is going to currently is empty. If this is the case, that means the elevator is at its final stop for the current direction and should now reverse its direction. Look at the Direction class to find a static method that could help you do that.

3. **Finish processRequests()**

   The method goes through each floor of the building and adds stops to one of the two array lists already provided in the method in your template. A stop can only be added once in one list (we are not allowed to have two elements with the same value in one list). For each person, two stops are made. Firstly the floor on which the person is (currentFloor of the person) and the destinationFloor of the person. In order to determine the direction a person wants to go and accordingly add to the correct list, you can use the corresponding method from the Direction class. Once you are done with the adding part, the stops in the local up and down lists need to be sorted. Think about a reasonable order for that. Finally you need to tell the elevator about the upcoming stops.

### Bonus Task

**Optional: Add capacity checks**

This part is optional, you can earn up to 3 bonus points by completing this task.

In this bonus task, you will implement a capacity check for the elevator. This is where the attribute capacity of the class Elevator comes into play. A limited amount of people are allowed to be in the elevator at any given time. Capacity tells you the maximum capacity the elevator is allowed to have. If the elevator stops at a floor, a person might not be allowed to enter. Unlike the usual elevator, this elevator can actually throw a person out based on the absolute distance between the floor the elevator is currently on and the destination floor of the passenger. The person with the smallest absolute distance is thrown out, or not allowed to enter the elevator. Since it is easier to walk downstairs than upstairs, in case two people have the same absolute distance, the one whose destination floor is downstairs is the one to not travel in the elevator. Be sure to sort the passenger's list in the method openDoor based on the order already introduced. Of course, the person who sadly has to 

#### Helpful questions

For the Bonus exercise you can consider using the sort() method of Lists.