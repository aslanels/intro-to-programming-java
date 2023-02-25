package de.tum.in.ase;

import java.util.List;
import java.util.Objects;

public class Burger {
    //TODO: Implement Part 1
    private String name;
    private List<String> ingredients;

    public Burger(String name, List<String> ingredients) {
        this.name = Objects.requireNonNullElse(name, "");

        this.ingredients = ingredients;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (! (name == null) ){
            this.name = name;
        }

    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
