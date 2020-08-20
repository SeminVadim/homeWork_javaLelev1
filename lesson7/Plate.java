package ru.geekbrains.Lesson_7;

import java.util.Scanner;

public class Plate {
    private int food;

    public Plate (int food) {
        this.food = food;
    }

    public void info () {
        System.out.println("plate: " + food);
    }

    public boolean decreaseFod (int n) {
        if (n > food) {
            System.out.println("in this plate don't have enough food");
            return false;
        }
        else {
            System.out.println("Cat eat is good ) meou ");
            food = food - n;
            return true;
        }
    }

    public void addFood () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hoe much food do you want add on plate?");
        int numberAddFood = sc.nextInt();
        food = food + numberAddFood;
        sc.close();
    }
}
