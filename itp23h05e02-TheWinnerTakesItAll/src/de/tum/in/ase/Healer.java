package de.tum.in.ase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Healer extends Player{
    //  attributes
    private List<Ability> abilities = new ArrayList<>();

    //  constructor
    public Healer (String name, List<Ability> abilities, List<Armor> armor, Weapon weapon, String weaponType) {
        super(name,"Healer",9,armor,weapon,weaponType);
        equipItems();
        this.abilities = abilities;
        int amountOfArmour = 9;
        strength = 3;
        intelligence = 5;
        agility = 3;
        spirit = 10;

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
    public void attack(Player target) {
        if ( weapon == null){
            System.out.println("You don't have a weapon to attack!");
        }else {
            double damage = strength * 0.2 + weapon.getDamage() + agility * 0.1 - target.getAmountOfArmor();

            if ( damage < 0 ){
                System.out.println("Target " + target.getName() + " didn't receive any damage!");
            } else {
                target.setHealth(target.getHealth() - damage);
            }

            if (target.isDead()){
                System.out.println(this.getName() + " killed " + target.getName());
                this.setLevel(this.getLevel() + 1);
            }
        }
    }

    @Override
    public void useAbility(Player target) {
        if (abilities.isEmpty()){
            System.out.println( this.getName() + " has no spells to cast!");
        } else {
            //List<Ability> filtered =  abilities.stream().filter(a -> a.getSpecification().equals(this.specification)).collect(Collectors.toCollection(ArrayList::new));
            ArrayList<Ability> filtered = new ArrayList<>();
            for (Ability ability: abilities){
                if (ability.getSpecification().equals(this.getSpecification())){
                    filtered.add(ability);
                }

            }

            if (filtered.isEmpty()) {
                System.out.println( this.getName() + " has no spells to cast!");
            } else {

                Random rand = new Random();
                int randA = rand.nextInt(filtered.size());
                Ability randomAbility = filtered.get(randA);

                double heal = spirit + randomAbility.getHeal() + intelligence * 0.5;


                if (target.isDead()){
                    System.out.println("Can not heal " + target.getName() + ", " + target.getName() + " is dead!");
                } else {
                    target.setHealth(target.getHealth() + heal);
                }
            }
        }

    }

    //  getters and setters
    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }


}
