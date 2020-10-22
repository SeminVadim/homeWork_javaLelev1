package ru.geekbrains.HomeWork_08;

import java.util.ArrayList;
import java.util.Arrays;

public class Stats <T> {
    private T[] arr;


    public Stats(T... arr) {
        this.arr = arr;
    }

    public void changeElement (int one, int two) {
        Object tmp;
        tmp = arr[one];
        arr[one] = arr[two];
        arr[two] = (T) tmp;
    }

    public ArrayList<T> toArrayList(){
        ArrayList<T> arrList = new ArrayList<>(Arrays.asList(arr));
        return arrList;
    }
    @Override
    public String toString() {
        return "Stats{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
