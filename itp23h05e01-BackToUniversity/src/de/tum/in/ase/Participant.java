package de.tum.in.ase;

abstract class Participant {

    //      attributes
    private String firstName;
    private String lastName;
    private String tumID;

    //      constructor

    protected Participant(String firstName, String lastName, String tumID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tumID = tumID;
    }

    //      methods

    public abstract void attend(Lecture lecture);

    public String getName(){
        return getFirstName() + " " + getLastName();
    }

    //      getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTumID() {
        return tumID;
    }

    public void setTumID(String tumID) {
        this.tumID = tumID;
    }

}
