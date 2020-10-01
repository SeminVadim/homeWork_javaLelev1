package ru.geekbrains.HomeWork_08;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

    	Stats<Integer> arr1 = new Stats<Integer>(1, 2, 3, 4, 5);
	    Stats<String> arr2 = new Stats<String>("1","2","3","4","5","6","7","8","9","0");

	    System.out.println(arr1);
        System.out.println(arr2);
	    System.out.println("--- Task #1 --- ");
	    arr1.changeElement(1,2);
        arr2.changeElement(0,9);
        System.out.println(arr1);
        System.out.println(arr2);

        System.out.println("--- Task #2 --- ");
        ArrayList arrayList1 = arr1.toArrayList();
        ArrayList arrayList2 = arr2.toArrayList();
        System.out.println(arrayList1);
        System.out.println(arrayList2);

        System.out.println("--- Task #3 --- ");

        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());

        System.out.println("Weight Box of apple is: " + appleBox.getWeight());
        System.out.println("Weight Box of orange is: " + orangeBox.getWeight());

        System.out.println(appleBox.compare(orangeBox));

        Box<Apple> appleBoxNew = new Box<>();
        appleBoxNew.add(new Apple());
        appleBoxNew.add(new Apple());

        System.out.println("apple Box.size:" + appleBox.getSize());
        System.out.println("apple Box NEW .size:" + appleBoxNew.getSize());
        appleBox.moveToBox(appleBoxNew);

        System.out.println("apple Box.size:" + appleBox.getSize());
        System.out.println("apple Box NEW .size:" + appleBoxNew.getSize());

    }
}
