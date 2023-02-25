package de.tum.in.ase;

import java.util.ArrayList;
import java.util.List;

public class Lecture {
    //      attributes
    private String id;
    private String name;
    private Lecturer lecturer;
    private List<ExerciseInstructor> exerciseInstructors;
    private List<Tutor> tutors;
    private List<Student> students;
    private LectureHall lectureHall;

    //      constructor
    public Lecture(String id, String name, Lecturer lecturer, LectureHall lectureHall) {
        this.id = id;
        this.name = name;
        this.lecturer = lecturer;
        this.lectureHall = lectureHall;
        this.students = new ArrayList<>();
        this.tutors = new ArrayList<>();
        this.exerciseInstructors = new ArrayList<>();
    }

    //      methods
    public void addParticipant(Participant p){
        if ( p instanceof Student){
            if ((students != null ) && students.contains(p) ){
                System.out.println(p.getName() + " tumID:" + p.getTumID() + " already attends/holds the lecture.");
            }else {
                students.add((Student) p);
            }
        } else if (p instanceof Tutor) {
            if ( (tutors != null ) && tutors.contains(p) ){
                System.out.println(p.getName() + " tumID:" + p.getTumID() + " already attends/holds the lecture.");
            }else {
                tutors.add((Tutor) p);
            }
        } else if (p instanceof ExerciseInstructor) {
            if ( (exerciseInstructors != null ) && exerciseInstructors.contains(p)){
                System.out.println(p.getName() + " tumID:" + p.getTumID() + " already attends/holds the lecture.");
            }else {
                exerciseInstructors.add((ExerciseInstructor) p);
            }
        } else if (p instanceof Lecturer) {
            if (lecturer == null){
                lecturer = (Lecturer) p;
            }else if (lecturer.getTumID().equals(p.getTumID())){
                System.out.println(p.getName() + " tumID:" + p.getTumID() + " already attends/holds the lecture.");
            } else {
                System.out.println("This lecture already has a lecturer!");
            }
        }else {
            System.out.println("No such participants allowed in this lecture!");
        }
    }

    public void addParticipants(List<Participant> participants){
        for(Participant p: participants){
            addParticipant(p);
        }
    }

    public void takePlace(){
        lectureHall.placeStudents(students);
        lecturer.openLecture(this);
        lecturer.closeLecture(this);
        lectureHall.empty();
    }

    //      getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public List<ExerciseInstructor> getExerciseInstructors() {
        return exerciseInstructors;
    }

    public void setExerciseInstructors(List<ExerciseInstructor> exerciseInstructors) {
        this.exerciseInstructors = exerciseInstructors;
    }

    public List<Tutor> getTutors() {
        return tutors;
    }

    public void setTutors(List<Tutor> tutors) {
        this.tutors = tutors;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public LectureHall getLectureHall() {
        return lectureHall;
    }

    public void setLectureHall(LectureHall lectureHall) {
        this.lectureHall = lectureHall;
    }
}
