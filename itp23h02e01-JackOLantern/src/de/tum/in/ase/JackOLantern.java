package de.tum.in.ase;

public class JackOLantern {
    //class JackOLantern attributes
    private String name;
    private Pumpkin pumpkin;
    private Candle candle;
    private Ghost ghost;

    //JackOLantern constructor
    public JackOLantern(String name, Pumpkin pumpkin, Candle candle, Ghost ghost ) {
        this.name = name;
        this.pumpkin = pumpkin;
        this.candle = candle;
        this.ghost = ghost;
        pumpkin.deseed();
        pumpkin.carveFace(ghost.getTemper());

    }

    public double getLanternWeight() {
        // total weight = pumpkin weight + candle weight
        return pumpkin.getWeight() + candle.calculateWeight();
    }


    public static void main(String[] args) {
       /*
       You can test your code here by constructing objects. Have fun :)
       */

        Pumpkin p = new Pumpkin("pie", 5);
        Ghost g = new Ghost("angry", 20);
        Candle c = new Candle(1,1);
        JackOLantern j = new JackOLantern("myLantern",p,c,g);
        JackOLantern k = new JackOLantern("myLantern",p,c,g);


        System.out.println(j.getLanternWeight());
        System.out.println(c.calculateWeight());
        System.out.println(p.getWeight());
        System.out.println(p.isSeeds());


    }


    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pumpkin getPumpkin() {
        return pumpkin;
    }

    public void setPumpkin(Pumpkin pumpkin) {
        this.pumpkin = pumpkin;
    }

    public Candle getCandle() {
        return candle;
    }

    public void setCandle(Candle candle) {
        this.candle = candle;
    }

    public Ghost getGhost() {
        return ghost;
    }

    public void setGhost(Ghost ghost) {
        this.ghost = ghost;
    }
}
