package ru.geekbrains.HomeWork_01;

public class Runway implements TestRunWall {
    private int speedRunway = 10;

    public Runway (){
    }
    public Runway (int speed) {
        this.speedRunway = speed;
    }
    public boolean start (int speed) {
        if ( speed >= speedRunway) {
            System.out.println("Скорость дорожки: " +speedRunway +", скорость чемпиона: " + speed +". Испытание пройдено");
            return true;
        }
        else {
            System.out.println("Скорость дорожки: " +speedRunway +", скорость чемпиона: " + speed +". Испытание НЕ пройдено");
            return false;
        }
    }

}
