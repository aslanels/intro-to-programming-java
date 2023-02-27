package de.tum.in.ase;


public class Armor extends Item{
    //  attributes
    private int amountOfArmor;

    //   constructor
    public Armor(String armorType, String specification, int amountOfArmor, int strength, int intelligence, int agility, int spirit){
        super(armorType);
        this.amountOfArmor = amountOfArmor;
        super.specification = specification;
        super.strength = strength;
        super.intelligence = intelligence;
        super.agility = agility;
        super.spirit = spirit;
    }

    // methods
    public int getAmountOfArmor() {
        return amountOfArmor;
    }

    public void setAmountOfArmor(int amountOfArmor) {
        this.amountOfArmor = amountOfArmor;
    }
}
