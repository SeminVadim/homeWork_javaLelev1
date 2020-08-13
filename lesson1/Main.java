package ru.geekbrains.lesson_1;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
import java.util.jar.JarOutputStream;

public class Main {

    // Задание 1. Создать проект.
    public static void main(String[] args) {

    // Задание 2. Создание и инициализация переменных.
        byte varByte = 1;
        short varShort = 1;
        int varInt = 1, flag = 1, year;
        long varLong = 1000L;
        float aa = 10.1f , bb = 3.1f, cc = 4.1f, dd = -5.1f;
        double varDouble = 5.535;
        char varChar = 'y';
        String varString = "Semin Vadim";
        boolean varBoolean = true;
        Scanner readConsole = new Scanner(System.in);

        System.out.println("Домашнее задание: " + varString);
        System.out.println("Задание 1. Сделать проект. Сделал.");
        System.out.println("Задание 2. Описать и инициализировать переменные. Сделал.");
        System.out.println("Задание 3. Решаем пример: a * (b + (c / d)) = " + metod3(aa,bb,cc,dd));
        System.out.println("Задание 4. Сравнение a+b >=10 " + (aa+bb) + " <=20. И это: "+metod4((int) aa, (int)bb));
        System.out.println("Задание 4. Сравнение a+b >=10 " + (bb+cc) + " <=20. И это: "+metod4((int) bb, (int)cc));
        System.out.print("Задание 5. Передаем число: "+ (int)aa+ ". ");
        metod5((int)aa);
        System.out.print("Задание 5. Передаем число: " + (int)dd+ ". ");
        metod5((int)dd);
        System.out.println("Задание 6. Передаем число(+ false, - true): "+ (int)aa+ ". "+ metod6((int)aa));
        System.out.println("Задание 6. Передаем число(+ false, - true): "+ (int)dd+ ". "+ metod6((int)dd));
        System.out.print("Задание 7. ");
        metod7(varString);
        System.out.println("Задание 8. ");
        while (flag == 1) {
            System.out.print("Введите год для проверки: ");
            year = readConsole.nextInt();
            metod8(year);
            System.out.println("Будем еще проверять? Если да то нажмите 1. Если нет, то любую клавишу");
            flag = readConsole.nextInt();
        }
        System.out.println("Домашнее задание выполнено!");
    }
    /*
    Задание 3.Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    где a, b, c, d – аргументы этого метода, имеющие тип float.
    */
    public static float metod3( float a, float b, float c, float d) {
        float x = a * (b + (c / d));
        return x;
    }
    /*
    Задание 4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в
    пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    */
    public static boolean metod4 (int a, int b){
        if (a+b >= 10 && a+b <=20) {
            return true;
        }
        else {
            return false;
        }
    }
    /*
    Задание 5.	Написать метод, которому в качестве параметра передается целое число, метод должен
    напечатать в консоль, положительное ли число передали или отрицательное.
    Замечание: ноль считаем положительным числом.
    */
    public static void metod5(int a) {
        if (a >= 0) {
            System.out.println("Переданное число: " + a + " - положительное");
        }
        else {
            System.out.println("Переданное число: " + a + " - отрицательное");
        }
    }
    /*
    Задание 6.	Написать метод, которому в качестве параметра передается целое число.
    Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
     */
    public static boolean metod6 (int a){
        if (a >= 0) {
            return false;
        }
        else {
            return true;
        }
    }
    /*
    7.	Написать метод, которому в качестве параметра передается строка, обозначающая имя.
    Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    */
    public static void metod7 (String myName){
        System.out.println("Привет, " + myName+ "!");
    }
    /*
    8.	*Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    */
    public static void metod8 (int i) {

        //for (int i = 1; i <= 1201; i++) {
            if (i % 4 == 0) {
                if (i % 100 != 0) {
                    System.out.println(i + " високосный");
                }
                else {
                    if (i % 400 == 0) System.out.println(i + " високосный");
                    else System.out.println(i + " обычный");
                }
            }
            else {
                System.out.println(i + " обычный");
            }

        //}
    }

}

