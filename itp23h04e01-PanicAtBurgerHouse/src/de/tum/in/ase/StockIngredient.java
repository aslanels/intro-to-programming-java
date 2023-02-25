package de.tum.in.ase;

import java.util.Objects;

public class StockIngredient {
    //TODO: Implement Part 1
    private String name = "";
    private int price = 0;
    private int quantity = 0;

    public StockIngredient(String name, int price, int quantity) {
        this.name = Objects.requireNonNullElse(name, "");
        this.price = Math.max(price, 0);
        this.quantity = Math.max(quantity, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null){
            this.name = name;
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if ( price >= 0){
            this.price = price;
        }

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if ( quantity >= 0 ){
            this.quantity = quantity;
        }

    }
}
