package de.tum.in.ase;

public class Weapon extends Item{
    //  attributes
    private int damage;

    //  constructor
    public Weapon(String weaponType, String specification, int damage, int strength, int intelligence, int agility, int spirit){
        super(weaponType);
        this.damage = damage;
        super.specification = specification;
        super.strength = strength;
        super.intelligence = intelligence;
        super.agility = agility;
        super.spirit = spirit;
    }

    //  getters and setters
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
