package ru.geekbrains.HomeWork_6;

public class Cat extends Animal {

    public Cat(String name, String color, int age) {
        super(name, color, age);
        this.runLimit = 200;
        this.jumpLimit = 2;
        this.swimLimit = 0;
    }

    @Override
    public void swimAnimal(double x) {
        System.out.println(String.format("Cat %s is can't swimming",super.name));
    }

    public Cat() {
    }

    public Cat (String name, String color, int age, double runLimit, double jumpLimit, double swimLimit) {
        super(name, color, age);
        this.runLimit = runLimit;
        this.jumpLimit =jumpLimit;
        this.swimLimit = swimLimit;
    }
}
