package ru.geekbrains.HomeWork_08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Box <T extends  Fruit>{
    private List<T> fruits;

    private float weightApple = 1.0f;
    private float weightOrange = 1.5f;


    public Box() {
        this(new ArrayList<>());
    }

    public Box(List<T> fruits) {
        this.fruits = fruits;
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }
    public void remove(T fruit) {
        fruits.remove(fruit);
    }
    public List<T> getFruits() {
        return fruits;
    }
    public int getSize() {
        return fruits.size();
    }

    public float getWeight() {
        float weight = 0;
        String str = "" + fruits;

        // так выдает java.util.ArrayList
        //System.out.println("fruits.getClass().getName() = " + fruits.getClass().getName());

        if (str.contains("Apple")) {
            weight = fruits.size() * weightApple;
        }  else {
            weight = fruits.size() * weightOrange;
        }

        return weight;
    }

    public boolean compare(Box<? extends Fruit> compareBox) {
        System.out.println("getWeight = " + getWeight());
        System.out.println("compareBox.getWeight() = " + compareBox.getWeight());

        if (getWeight() == compareBox.getWeight()) {
            return true;
        } else {
            return false;
        }
    }

    public void moveToBox (Box<T> toBox) {
        for (int i = 0; i < fruits.size(); i++) {
            toBox.add(fruits.get(i));
            fruits.remove(i);
        }
        toBox.add(fruits.get(0));
        fruits.remove(0);
    }

}
