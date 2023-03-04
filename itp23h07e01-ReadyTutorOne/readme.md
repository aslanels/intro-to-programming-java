# H07E01 - Ready Tutor One

In the movie《Ready Player One》, the main character has the opportunity to experience different game roles with his high-tech VR equipment. In this exercise, we would like to give you the chance to have a look at a simulated exam system, which is also called Artemis. The goal is to give you the chance to experience a part of tutor's job, as all of you can potentially be tutors in the future ;).

## Project Structure

There are four classes given in the folder under the path src/de/tum/in/ase, all methods are supposed to be implemented in the classes Artemis, Complaint, and Grade. DO NOT MAKE ANY CHANGES ON THE OTHER GIVEN FILES!. Otherwise, your tests will fail. In the corresponding classes, you will find more details about each method.

In this exercise, we want you to practice using the Java Stream class.

You are not allowed to use any loops (e.g. for and while control structures, forEach() or similar methods, etc.) in any of your methods in this exercise at all! This also includes helper methods. Otherwise, you won't receive any points for the whole exercise!

However, the ternary operator is allowed!

### Round 1: Warm up
    
First, we need to implement some classes and methods to help the tutors to keep an overview of each student's performance and enable the complaint function for students.

**You have the following tasks:**

1. **Functional interfaces**

    Implement a functional interface Formatter with the annotation @FunctionalInterface. This interface has a method called formatExam(Exam exam) whose return type is String. This interface will get used in later tasks.

2. **Calculate the average**

   Implement the method averageGrade(Stream<Exam> exams) in the Artemis class. Now, the average grade of all exams of a student should be calculated. However, just like in our real life, only those grades which are valid will be taken into account for the average. The rest of them can be ignored and don't play any role in the calculation. Please consider possible edge cases.

   As the default output, you should return 0.

3. **Make complaints**

   Implement the method complainAllPreliminary(Stream<Exam> exams) in the Complaint class. Artemis is an open-source project, so students decided to provide a method to other students to quickly generate complaints for all exams. This method should create a List of Complaints for every exam, whose status is still PRELIMINARY. As a message, the students decided to use Plz giv 1.0.

### Round 2: Some sorting works

**You have the following tasks:**

1. **sorting with exam dates**

   Implement the method sortExamsByExamDate(Stream<Exam> exams) in the Artemis class. The exams should be sorted based on the exam dates ascendingly. This method should return a sorted list.

   Hint: the Comparator of Java may be helpful.

2. **find the earliest exam date**

   Implement the method dateOfFirstExam(Stream<Exam> exams) in the Artemis class. With this method, we want to find the earliest exam that a student has written. If there is no such exam, please return null.

### Round 3: Some statistical works

Finally the last part, congrats!

**You have the following tasks:**

1. **Find out the online and onsite exams**

   Implement the method countByOnline(Stream<Exam> exams) in the Artemis class. Your method should only take the exams in VALID status into account and return a map. We have the boolean attribute isOnline as key: true (online exam) and false (on site exam) and the corresponding amounts of exams as value. If there are only online exams, for example, your map should contain only one pair: <true, amount of exams>.

   Hint: toMap() might be help for this task.

2. **Formatter**

   First, uncomment the method createFormattedReport(Stream<Exam> exams, Formatter formatter) in the class Artemis, which returns a String. This method should create a exam output as specified by the given Formatter. Call the formatExam method with every exam in the Stream. The resulting string should contain all the formatted exames, with every exam in its own line.

   In the following method, you are expected to call the method createFormattedReport and pass the Formatter as a lambda expression (arrow syntax). You will receive no points if you do not use the lambda syntax!

   Create the method createSimpleReport(Stream<Exam> exam) that returns a report formatted using this scheme: [<grade-status>] Exam "<exam-name>": <grade>.

   Example report using createSimpleReport

```
[VALID] Exam "Introduction to Programming": 1.0
[VALID] Exam "Allgemeine Betriebswirtschaftslehre": 1.0
```