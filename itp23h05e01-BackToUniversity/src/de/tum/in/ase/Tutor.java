package de.tum.in.ase;


public class Tutor extends Participant{
    //      attributes
    private Lecture lecture;

    //      constructor
    public Tutor(String firstName, String lastName, String tumID, Lecture lecture) {
        super(firstName, lastName, tumID);
        this.lecture = lecture;
    }

    //      methods
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void attend(Lecture lecture) {

        if (lecture.getId().equals(this.getLecture().getId())){
            lecture.addParticipant(this);
        } else {
            Student tutor = new Student(this.getFirstName(),this.getLastName(),this.getTumID());
            lecture.addParticipant(tutor);
        }
    }

    //      getters and setters

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

}
