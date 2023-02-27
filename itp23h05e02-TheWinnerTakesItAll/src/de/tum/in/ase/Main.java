package de.tum.in.ase;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        Weapon weaponHealer = new Weapon("x","Healer",10,10,10,10,10);
        Weapon weaponWarrior = new Weapon("x","Warrior",10,10,10,10,10);


        Ability heal = new Ability("Heal","Healer",10);
        ArrayList<Ability> abilities = new ArrayList<>();
        abilities.add(heal);

        Armor hands = new Armor("Hands","Healer",10,10,10,10,10);
        Armor chest = new Armor("Chest","Healer",10,10,10,10,10);
        Armor legs = new Armor("Legs","Healer",10,10,10,10,10);
        Armor boots = new Armor("Boots","Healer",10,10,10,10,10);
        Armor helmet = new Armor("Helmet","Healer",10,10,10,10,10);
        ArrayList<Armor> armors = new ArrayList<>();
        armors.add(hands);
        armors.add(chest);
        armors.add(legs);
        armors.add(boots);
        armors.add(helmet);

        Healer healer = new Healer("Healer",abilities,armors,weaponHealer,"x");
        Warrior warrior = new Warrior("Warrior", abilities,armors,weaponWarrior,"x");

        healer.useAbility(warrior);

    }
}
