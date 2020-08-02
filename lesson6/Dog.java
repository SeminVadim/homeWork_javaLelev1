package ru.geekbrains.HomeWork_6;

public class Dog extends Animal {

    public Dog(String name, String color, int age) {
        super(name, color, age);
        this.runLimit = 500;
        this.jumpLimit =0.5;
        this.swimLimit = 10;
    }

    public Dog() {
    }

    public Dog (String name, String color, int age, double runLimit, double jumpLimit, double swimLimit) {
        super(name, color, age);
        this.runLimit = runLimit;
        this.jumpLimit =jumpLimit;
        this.swimLimit = swimLimit;
    }
}
