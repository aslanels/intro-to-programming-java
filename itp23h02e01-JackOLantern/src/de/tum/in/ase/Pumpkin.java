package de.tum.in.ase;

public class Pumpkin {
    //class pumpkin attributes
    private double weight ;
    private String face ;
    private String type ;
    private boolean seeds ;

    //pumpkin constructor
    public Pumpkin (String type, double weight){
        this.seeds = true ;
        this.face = "";
        this.type = type ;
        this.weight = weight;
    }
    // deseed method for pumpkin
    public void deseed(){
        if (this.seeds == true){
            this.seeds = false;
            this.weight = weight * 0.3;
        } else {
            System.out.println("Pumpkin already deseeded");
        }
    }
    public void carveFace(String temper){
        if (this.face == ""){
            this.face = temper;
        } else {
            System.out.println("Pumpkin already carved");
        }

    }

    //getters and setters

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSeeds() {
        return seeds;
    }

    public void setSeeds(Boolean seeds) {
        this.seeds = seeds;
    }
}
