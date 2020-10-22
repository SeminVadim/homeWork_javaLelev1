package ru.geekbrains.HomeWork_5;

import javax.swing.plaf.basic.BasicBorders;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        /**
         * + Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
         * + Конструктор класса должен заполнять эти поля при создании объекта;
         * + Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
         * + Создать массив из 5 сотрудников
         * + С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
         */

        Personal[] GeekBrainsCompany = new Personal[5];
        GeekBrainsCompany[0] = new Personal("Ivanov Ivan","Team Lead","Ivanov@gmail.com", "892121212121",90000,50);
        GeekBrainsCompany[1] = new Personal("Petrov Petr","Designer","Petrov@gmail.com", "892121212121",80000,25);
        GeekBrainsCompany[2] = new Personal("Sidorov Sergey","Frontend developer","Sidorov@gmail.com", "892121212121",70000,31);
        GeekBrainsCompany[3] = new Personal("Smirnov Stepan","Backend developer","Smirnov@gmail.com", "892121212121",70000,41);
        GeekBrainsCompany[4] = new Personal("Medvedev Mihail","Database architect","Medvedev@gmail.com", "892121212121",60000,45);

        for (int i = 0; i < GeekBrainsCompany.length; i++) {
            if (GeekBrainsCompany[i].getAge() > 40) {
                System.out.println(GeekBrainsCompany[i].printToConsole());
            }
        }
    }
}
