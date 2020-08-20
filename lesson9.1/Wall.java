package ru.geekbrains.HomeWork_01;

public class Wall implements TestRunWall {
    private int heightWall = 5;

    public Wall (){
    }
    public Wall (int height) {
        this.heightWall = height;
    }

    public boolean start (int height) {
        if ( height >= heightWall) {
            System.out.println("Высота стены: " +heightWall +", прыжок чемпиона: " + height +". Испытание пройдено");
            return true;
        }
        else {
            System.out.println("Высота стены: " +heightWall +", прыжок чемпиона: " + height +". Испытание НЕ пройдено");
            return false;

        }
    }

}
