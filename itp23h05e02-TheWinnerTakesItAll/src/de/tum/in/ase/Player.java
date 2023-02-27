package de.tum.in.ase;

import java.util.List;

public abstract class Player implements Interactions{
    //   attributes
    protected String name;
    protected String specification;
    protected int amountOfArmor;
    protected String weaponType;
    protected int strength;
    protected int intelligence;
    protected int agility;
    protected int spirit;
    protected double health;
    protected int level;
    protected Armor helmet;
    protected Armor chest;
    protected Armor hands;
    protected Armor legs;
    protected Armor boots;
    protected List<Armor> armor;
    protected Weapon weapon;

    //  constructor

  protected Player(String name, String specification, int amountOfArmor, List<Armor> armor, Weapon weapon, String weaponType){
    this.name = name;
    this.specification = specification;
    this.amountOfArmor = amountOfArmor;
    this.armor = armor;
    this.level = 1;
    this.health = 200;
    this.weaponType = weaponType;

      if (weapon != null && weapon.getType().equals(weaponType) ){
        this.weapon = weapon;
      }

  }

  // methods

  protected void equipItems(){
    for ( Armor a: armor){
      if ( a.getType().equals("Helmet") && helmet == null){
        this.setHelmet(a);
        helmet.setEquipped(true);
      } else if (a.getType().equals("Chest") && chest == null) {
        this.setChest(a);
        chest.setEquipped(true);
      } else if (a.getType().equals("Hands") && hands == null) {
        this.setHands(a);
        hands.setEquipped(true);
      } else if (a.getType().equals("Legs")  && legs == null) {
        this.setLegs(a);
        legs.setEquipped(true);
      } else if (a.getType().equals("Boots")  && boots == null) {
        this.setBoots(a);
        boots.setEquipped(true);
      }
    }
  }
  protected boolean isDead(){
    return !(this.health > 0);
  }

  @Override
  public void attack(Player target) {

  }

  @Override
  public void useAbility(Player target) {

  }

  // getters and setters

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSpecification() {
    return specification;
  }

  public void setSpecification(String specification) {
    this.specification = specification;
  }

  public int getAmountOfArmor() {
    return amountOfArmor;
  }

  public void setAmountOfArmor(int amountOfArmor) {
    this.amountOfArmor = amountOfArmor;
  }

  public String getWeaponType() {
    return weaponType;
  }

  public void setWeaponType(String weaponType) {
    this.weaponType = weaponType;
  }

  public int getStrength() {
    return strength;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public int getIntelligence() {
    return intelligence;
  }

  public void setIntelligence(int intelligence) {
    this.intelligence = intelligence;
  }

  public int getAgility() {
    return agility;
  }

  public void setAgility(int agility) {
    this.agility = agility;
  }

  public int getSpirit() {
    return spirit;
  }

  public void setSpirit(int spirit) {
    this.spirit = spirit;
  }

  public double getHealth() {
    return health;
  }

  public void setHealth(double health) {
    this.health = health;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public Armor getHelmet() {
    return helmet;
  }

  public void setHelmet(Armor helmet) {
    this.helmet = helmet;
  }

  public Armor getChest() {
    return chest;
  }

  public void setChest(Armor chest) {
    this.chest = chest;
  }

  public Armor getHands() {
    return hands;
  }

  public void setHands(Armor hands) {
    this.hands = hands;
  }

  public Armor getLegs() {
    return legs;
  }

  public void setLegs(Armor legs) {
    this.legs = legs;
  }

  public Armor getBoots() {
    return boots;
  }

  public void setBoots(Armor boots) {
    this.boots = boots;
  }

  public List<Armor> getArmor() {
    return armor;
  }

  public void setArmor(List<Armor> armor) {
    this.armor = armor;
  }

  public Weapon getWeapon() {
    return weapon;
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

}
