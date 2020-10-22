package ru.geekbrains.HomeWork_6;

public class Animal {
    protected String name;
    protected String color;
    protected int age;
    protected double runLimit, jumpLimit, swimLimit;


    public void runAnimal(double x) {
        checkLimit(runLimit, x);
    }
    public void jumpAnimal(double x) {
        checkLimit(jumpLimit, x);
    }
    public void swimAnimal(double x) {
        checkLimit(swimLimit, x);
    }

    public Animal() {
    }

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public void printInfo() {
        System.out.println(String.format("Name: %s, Color: %s, Age: %s, runLimit: %s, jumpLimit %s, swimLimit: %s", name, color, age, runLimit, jumpLimit, swimLimit));
    }

    public void checkLimit(double lim, double x) {
        if (x <= lim && x > 0) {
            System.out.println(String.format("True. %s is can do: %s ", name, x));
        } else {
            System.out.println(String.format("False. %s is can't do: %s ", name, x));
        }
    }
}
