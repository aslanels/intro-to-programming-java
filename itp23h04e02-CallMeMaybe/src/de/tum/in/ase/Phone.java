package de.tum.in.ase;

public class Phone {

    //TODO: Add nextPhoneId, id, brand, price, touchscreen attributes to the Phone class and implement the constructor with these attributes

    private final int id;

    public static int nextPhoneId =0;
    private String brand;
    private double price;
    private boolean touchscreen;

    public Phone(String brand, double price, boolean touchscreen) {
        this.brand = brand;
        this.price = price;
        this.touchscreen = touchscreen;
        this.id = nextPhoneId;
        nextPhoneId++;

    }



    //TODO: Implement getter and setter methods for the attributes id, brand, price, touchscreen

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isTouchscreen() {
        return touchscreen;
    }

    public void setTouchscreen(boolean touchscreen) {
        this.touchscreen = touchscreen;
    }


    //TODO: Implement the toString method for the Phone class

    @Override
    public String toString(){

        return new String("id: " + id + ", brand: " + brand + ", price: " + price + ", touchscreen: " + touchscreen);
    }



}
