package de.tum.in.ase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Warrior extends Player {
    //  attributes
    private List<Ability> abilities = new ArrayList<>();

    //  constructor
    public Warrior(String name, List<Ability> abilities, List<Armor> armor, Weapon weapon, String weaponType) {
        super(name,"Warrior",15,armor,weapon,weaponType);
        equipItems();
        this.abilities = abilities;
        int amountOfArmour = 15;
        strength = 20;
        intelligence = 2;
        agility = 8;
        spirit = 2;

        if (this.weapon != null) {
            strength += weapon.getStrength();
            intelligence += weapon.getIntelligence();
            agility += weapon.getAgility();
            spirit += weapon.getSpirit();
        }

        for (Armor arm: armor) {
            if (arm.isEquipped()) {
                amountOfArmour += arm.getAmountOfArmor();
                strength += arm.getStrength();
                intelligence += arm.getIntelligence();
                agility += arm.getAgility();
                spirit += arm.getSpirit();
            }
        }

        setAmountOfArmor(amountOfArmour);

    }

    //  methods
    @Override
    public void useAbility(Player target) {
        if (abilities.isEmpty()){
            System.out.println( this.getName() + "has no skills to use!");
        } else {
            List<Ability> filtered =  abilities.stream().filter(a -> a.getSpecification().equals(this.specification)).collect(Collectors.toCollection(ArrayList::new));

            if (filtered.isEmpty()) {
                System.out.println( this.getName() + "has no skills to use!");
            } else {

                Random rand = new Random();
                int randA = rand.nextInt(filtered.size());
                Ability randomAbility = filtered.get(randA);

                double damage = strength * 2 + randomAbility.getDamage() - target.getAmountOfArmor();
                if ( damage <= 0){
                    System.out.println("Target " + target.getName()+ " didn't receive any damage!");
                } else {
                    target.setHealth(target.getHealth() - damage);
                }

                if (target.isDead()){
                    System.out.println(this.getName() + " killed " + target.getName());
                    this.setLevel(this.getLevel() + 1);
                }


            }

        }

    }

    @Override
    public void attack(Player target) {
        if ( weapon == null){
            System.out.println("You don't have a weapon to attack!");
        }else {
            double damage = strength*1.0 +weapon.getDamage() + agility*0.8 + - target.getAmountOfArmor();

            if ( damage < 0 ){
                System.out.println("Target " + target.getName() + " didn't receive any damage!");
            } else {
                target.setHealth(target.getHealth() - damage);
            }
            if (target.getHealth() <= 0){
                System.out.println(this.getName() + " killed " + target.getName());
                this.setLevel(this.getLevel() + 1);
            }
        }
    }

    @Override
    protected void equipItems() {
        super.equipItems();
    }

    //  getters and setters
    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

}
