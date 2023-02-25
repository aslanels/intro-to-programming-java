package de.tum.in.ase;

public class Candle {
    private double height;
    private double radius;
    private boolean burning;

    public Candle(double radius, double height){
        this.radius = radius;
        this.height = height;
        this.burning = false ;
    }

    public void light(){
        this.burning = true;
    }

    public double calculateWeight(){
        return 3.14 * radius * radius * height * 0.95;
    }

    //getters and setters

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public boolean isBurning() {
        return burning;
    }

    public void setBurning(Boolean burning) {
        this.burning = burning;
    }
}
