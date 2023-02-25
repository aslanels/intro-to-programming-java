package de.tum.in.ase;

public class Student extends Participant{

    //      constructor
    public Student(String firstName, String lastName, String tumID) {
        super(firstName, lastName, tumID);
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
}
