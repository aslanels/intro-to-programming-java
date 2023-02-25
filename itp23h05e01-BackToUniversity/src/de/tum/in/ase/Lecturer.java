package de.tum.in.ase;

import java.util.ArrayList;
import java.util.List;

public class Lecturer extends Participant{

    //      attributes

    private String title;
    private List<Lecture> lectures;

    //      constructor
    public Lecturer(String firstName, String lastName, String tumID, String title) {
        super(firstName, lastName, tumID);
        this.title = title;
        this.lectures = new ArrayList<>();
    }

    //      methods
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void attend(Lecture lecture) {
        lecture.addParticipant(this);
    }

    public void addLecture( Lecture lecture){
        if ( (lecture.getLecturer() == null) || (lecture.getLecturer().getTumID().equals(this.getTumID())) ){
            this.lectures.add(lecture);
        }else {
            System.out.println("The lecture " + lecture.getName() + " is already held by another lecturer.");
        }
    }

    public void openLecture(Lecture lecture){
        System.out.println("Welcome to the lecture " + lecture.getName() + "! I'm Prof. " + this.getName() + ".");
    }

    public void closeLecture(Lecture lecture){
        System.out.println("This is all for today. See you next week!");
    }

    public String toString(){
        return this.getTitle() + " " + getName() ;
    }

        //      getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }
}
