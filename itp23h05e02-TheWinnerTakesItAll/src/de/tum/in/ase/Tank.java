package de.tum.in.ase;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class Tank extends Player{
    //  attributes
    private List<Ability> abilities = new ArrayList<>();
    private Armor shield;

    //  constructor
    public Tank(String name, List<Ability> abilities, List<Armor> armor, Weapon weapon, String weaponType, Armor shield) {
        super(name,"Tank",30,armor,weapon,weaponType);
        this.shield = shield;
        equipShield();
        equipItems();
        this.abilities = abilities;
        int amountOfArmour = 30;
        strength = 15;
        intelligence = 4;
        agility = 6;
        spirit = 2;

        if (this.weapon != null) {
            strength += weapon.getStrength();
            intelligence += weapon.getIntelligence();
            agility += weapon.getAgility();
            spirit += weapon.getSpirit();
        }

        List<Armor> armorList = Arrays.asList(helmet, chest, hands, legs, boots, this.shield);

        for (Armor arm: armorList) {
            if (arm != null) {
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
    protected void equipItems() {
        super.equipItems();
    }

    @Override
    public void useAbility(Player target) {
        if (abilities.isEmpty()){
            System.out.println( this.getName() + " has no skills to use!");
        } else {
            List<Ability> filtered = abilities.stream().filter(a -> a.getSpecification().equals(this.specification)).collect(Collectors.toCollection(ArrayList::new));

            if (filtered.isEmpty()) {
                System.out.println( this.getName() + " has no skills to use!");
            } else {

                Random rand = new Random();
                int randA = rand.nextInt(filtered.size());
                Ability randomAbility = filtered.get(randA);

                int incArmour = randomAbility.getArmor();
                this.setAmountOfArmor(getAmountOfArmor() + incArmour);

                System.out.println("Hey you! I am here, attack me!");
                target.attack(this);
            }

        }
    }

    @Override
    public void attack(Player target) {
        if ( weapon == null){
            System.out.println("You don't have a weapon to attack!");
        }else {
            double damage = strength * 0.7 + weapon.getDamage() + agility * 0.6 - target.getAmountOfArmor();

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

    private void equipShield(){
        if ( shield != null && shield.type.equals(weaponType)){
            setShield(shield);
            shield.equipped = true;
        }
    }


    //  getters and setters
    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public Armor getShield() {
        return shield;
    }

    public void setShield(Armor shield) {
        this.shield = shield;
    }

}
