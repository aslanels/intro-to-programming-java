package de.tum.in.ase;

public class Ghost {
    private String temper;
    private int age;

    public Ghost (String temper, int age){
        this.temper = temper;
        this.age = age;
    }


    public String getTemper() {
        return temper;
    }

    public void setTemper(String temper) {
        this.temper = temper;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
