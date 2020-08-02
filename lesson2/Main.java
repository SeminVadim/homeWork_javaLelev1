package ru.geekbrains.HomeWork_2;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("java Level 1. HomeWork for lesson 2. Semin Vadim ");

        // Задание №1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        System.out.println("Задание №1");
        int [] mas1 = {0,0,0,0,0,1,1,1,1,1};
        System.out.println(Arrays.toString(mas1));
        for (int i=0; i < mas1.length; i++) {
            switch (mas1[i]) {
                case 0: mas1[i] = 1; break;
                case 1: mas1[i] = 0; break;
            }
        }
        System.out.println(Arrays.toString(mas1));

        // Задание №2. Задать пустой целочисленный массив размером 8.
        // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        System.out.println("Задание №2");
        int [] mas2 = new int [8];
        for (int i = 0; i < 8; i++){
            mas2[i] = i * 3;
        }
        System.out.println(Arrays.toString(mas2));

        // Задание №3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        // пройти по нему циклом, и числа меньшие 6 умножить на 2;
        System.out.println("Задание №3");
        int [] mas3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println(Arrays.toString(mas3));
        for (int i = 0; i < mas3.length; i++ ) {
            if (mas3[i] < 6) mas3[i] = mas3[i]*2;
        }
        System.out.println(Arrays.toString(mas3));

        // Задание №4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        System.out.println("Задание №4");
        int [][] mas4 = new int[5][5];
        for (int i = 0; i < mas4.length; i++  ) {
            for (int j = 0; j < mas4[i].length; j++) {
                mas4[i][j] = 5;
            }
        }
        printMas(mas4);

        for (int i = 0; i < mas4.length; i++  ) {
            for (int j = 0; j < mas4[i].length; j++) {
                if (i == j) mas4[i][j] = 1;
            }
        }
        printMas(mas4);

        // Задание №5. Задать одномерный массив и найти в нем минимальный и максимальный элементы.
        System.out.println("Задание №5");
        int [] mas5 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println(Arrays.toString(mas5));
        int max = mas5[0], min = mas5[0];
        for (int i = 0; i < mas5.length; i++){
            if (mas5[i] > max) max = mas5[i];
            if (mas5[i] < min) min = mas5[i];
        }
        System.out.println("Максимальное число = " + max);
        System.out.println("Минимальное число  = " + min);

        // Задание №6. Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        // checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
        // checkBalance([1, 1, 1, || 2, 1]) → true/
        System.out.println("Задание №6");

        int [] mas6_1 = {2, 2, 2, 1, 2, 2, 10, 1 };
        int [] mas6_2 = {1,1,1,2,1 };

        System.out.println(checkBalance(mas1));
        System.out.println(checkBalance(mas2));
        System.out.println(checkBalance(mas3));
        System.out.println(checkBalance(mas5));
        System.out.println(checkBalance(mas6_1));
        System.out.println(checkBalance(mas6_2));

        // Задание №7. Написать метод, которому на вход подается одномерный массив и число n
        // (может быть положительным, или отрицательным), при этом метод должен сместить все
        // элементы массива на n позиций. Элементы смещаются циклично.
        // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
        // при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
        System.out.println("Задание №7");
        int [] mas7 = {1,2,3,4,5};
        moveMas(mas7,+3);
        moveMas(mas7,-3);
        moveMas(mas7,0);

    }

    public static void printMas (int [][] mas){
        for (int i = 0; i < mas.length; i++ ){
            for(int j =0; j< mas[i].length; j++){
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean checkBalance (int [] mas){
        int left = 0, right = 0;
        boolean flag = false;
        for (int i = 0; i < mas.length; i++ ){
            left = left + mas[i];
            for(int j = i+1; j< mas.length; j++) {
                right = right + mas[j];
            }
            if (left == right) {
                flag = true;
                break;
            }
            right = 0;
        }
        return flag;
    }

    public static void moveMas (int [] mas, int x) {
        int a = 0;
        System.out.println("Исходный Массив = " + Arrays.toString(mas));

        if ( x > 0) {
            for (int i = 1; i <= x; i++) {
                int a0 = mas[0];
                for (int j = 0; j < mas.length - 1; j++) {
                    mas[j] = mas[j + 1];
                }
                mas[mas.length - 1] = a0;
            }
        }   else if (x < 0) {
                x = x * -1;
                for (int i = 1; i <= x; i++) {
                    int a0 = mas[0];
                    for (int j = 0; j < mas.length-1; j++) {
                        mas[j] = mas[j+1];
                    }
                    mas[mas.length-1] = a0;
                }
        }
            else if (x == 0) {
                System.out.println("x = 0 массив не двигаем");
        }
        System.out.println("Измененный массив = " + Arrays.toString(mas));
    }
}

