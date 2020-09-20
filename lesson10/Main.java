package ru.geekbrains.HomeWork_02;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Arrays;

/**
 *
 * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
 * при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 *
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
 * должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
 *
 * 3. В методе main() вызвать полученный метод, обработать возможные исключения
 * MySizeArrayException и MyArrayDataException, и вывести результат расчета.
 *
 */

public class Main {
    public static void main(String[] args) {
        String[][] arr4x4 = new String[4][4];
        String[][] arr5x5 = new String[4][5];
        String[][] arr4x4Bad = new String[4][4];

        for (int i = 0; i < arr4x4.length; i++) {
            for (int j = 0; j < arr4x4.length; j++) {
                arr4x4[i][j] = "5";
                arr4x4Bad[i][j] = "5";
            }
        }

        arr4x4Bad[3][3] = "5x";

        for (int i = 0; i < arr5x5.length; i++) {
            for (int j = 0; j < arr5x5.length; j++) {
                arr5x5[i][j] = "5";
            }
        }
        checkArray(arr4x4);
        System.out.println("---------------------------------------");
        checkArray(arr5x5);
        System.out.println("---------------------------------------");
        checkArray(arr4x4Bad);
    }

    private static void checkArraySize(String[][] arr) throws MySizeArrayException {
        System.out.println("Check Size");
        if (arr.length > 4 || arr[1].length > 4) {
            throw new MySizeArrayException("Size array is more that 4х4");
        }
        System.out.println("Size is ok");
    }

    private static void checkArrayData(String[][] arr) throws MyArrayDataException {
        int sum = 0;
        System.out.println("Check elements and summary");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                try {
                    sum += Integer.valueOf(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    System.out.print("["+ i +"] ["+ j +"]");
                    throw new MyArrayDataException("index of bad element.");
                }
            }
        }
        System.out.println("Check elements and summary is ok. Sum = " + sum);
    }

    private static void checkArray (String [][] arr){
        int sum = 0;
        System.out.println("=== Start check array ===");
        try {

            checkArraySize(arr);
            System.out.println("----------");
            checkArrayData(arr);
        }
        catch (MySizeArrayException | MyArrayDataException e) {
            System.out.println("- catch exeption");
            //e.printStackTrace();
        }
        finally {
            System.out.println("=== Finish check  ===");
        };
    }
}

