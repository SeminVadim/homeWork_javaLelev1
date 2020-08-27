package ru.geekbrains.HomeWork_01;

public class Robots implements TeamChampions {
    private String name;
    private int runLimit;
    private int jumpLimit;

    public Robots(String name, int run, int jump) {
        this.name = name;
        this.runLimit = run;
        this.jumpLimit = jump;
    }

    public void run() {
        System.out.println("Robot run. Name = " +name+ ", run limit "+runLimit);
    }

    public void jump() {
        System.out.println("Robot jump. Name = " +name+ ", jump limit "+jumpLimit);
    }
    public String printToConsole() {
        return  "{ Robot, name = "     +name+
                ", run limit = " +runLimit+
                ", jump Limit = " +jumpLimit+
                " }";
    }

    // Getters
    public String getName()     { return name;      }
    public int getRunLimit()    { return runLimit;  }
    public int getJumpLimit()   { return jumpLimit; }
}
