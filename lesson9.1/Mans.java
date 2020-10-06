package ru.geekbrains.HomeWork_01;

public class Mans implements TeamChampions {
    private String name;
    private int runLimit;
    private int jumpLimit;

    public Mans(String name, int run, int jump) {
        this.name = name;
        this.runLimit = run;
        this.jumpLimit = jump;
    }

    public void run() {
        System.out.println("Man run. Name = " +name+ ", run limit "+runLimit);
    }

    public void jump() {
        System.out.println("Man jump. Name = " +name+ ", jump limit "+jumpLimit);
    }

    public String printToConsole() {
        return  "{ Man, name = "     +name+
                ", run limit = " +runLimit+
                ", jump Limit = " +jumpLimit+
                " }";
    }

    // Getters
    public String getName()     { return name;      }
    public int getRunLimit()    { return runLimit;  }
    public int getJumpLimit()   { return jumpLimit; }


}
