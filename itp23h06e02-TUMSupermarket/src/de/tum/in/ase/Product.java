package de.tum.in.ase;

public class Product {

    private final String name;
    private final double price;

    public Product(String name, double price) {
        //TODO throw an exception
        if ( name == null || price <= 0){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "Product: " + name + " Price: " + price;
    }
}
