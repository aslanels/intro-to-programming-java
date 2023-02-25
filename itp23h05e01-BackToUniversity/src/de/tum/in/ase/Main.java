package de.tum.in.ase;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        //TODO test your code here
        Lecturer p1 = new Lecturer(null,null,null,null);
        Lecture l1 = new Lecture(null,null,null,null);


        Lecturer p2 = new Lecturer("Test","A","0","Prof");
        Lecture l2 = new Lecture("00","java",p2,null);

        p2.addLecture(l2);

        l1.addParticipant(p2);
        System.out.println(l2.getLecturer());

        List<Student> testStudents = generateStudents(30);

       // for (Student student: testStudents){
       //     System.out.println(student.getName() + student.getTumID());
       // }

        List<Tutor> testTutors = generateTutors(1,l2);

        //for ( Tutor tutor: testTutors){
        //    System.out.println(tutor.getName() + tutor.getTumID());
        //}

        LectureHall testHall = new LectureHall("TestHall",100);

        System.out.println(testHall);
        testHall.placeStudents(testStudents);

    }

    private static List<Student> generateStudents(int amount){
        ArrayList<Student> students = new ArrayList<>();

        for ( int i = 0; i<amount; i++){
            students.add(new Student("Test"+String.valueOf(i),"Student",String.valueOf(i)));
        }
        return students;
    }

    private static List<Tutor> generateTutors(int amount,Lecture lecture){
        ArrayList<Tutor> tutors = new ArrayList<>();

        for ( int i = 0; i<amount; i++){
            tutors.add(new Tutor("Test","Tutor",String.valueOf(i),lecture));
        }
        return tutors;
    }
}
