package ru.geekbrains.HomeWork_6;

public class Main {

    public static void main(String[] args) {
        /**
         *  + 1.Создать классы Собака и Кот с наследованием от класса Животное.
         *  + 2.Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
         *      В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания),
         *      или высоту (для прыжков).
         *  + 3.У каждого животного есть ограничения на действия (
         *      бег: кот 200 м., собака 500 м.;
         *      прыжок: кот 2 м., собака 0.5 м.;
         *      плавание: кот не умеет плавать, собака 10 м.).
         *  + 4.При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
         *      (Например, dog1.run(150); -> результат: run: true)
         *  + 5.Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
         */

        Cat cat1 = new Cat("murka", "black", 1);
        Cat cat2 = new Cat("barsik", "white", 2);
        Dog dog1 = new Dog("rex", "black", 3);
        Dog dog2 = new Dog("joy", "white", 4);
        Dog dog3 = new Dog("superDog", "white", 20,1000,5,100);


        System.out.println(" ==== Who is here? ====");
        cat1.printInfo();
        cat2.printInfo();
        dog1.printInfo();
        dog2.printInfo();
        dog3.printInfo();
        System.out.println(" =======================");

        System.out.println(" ==== Who can Run? ====");
        cat1.runAnimal(150);
        cat2.runAnimal(300);
        dog1.runAnimal(400);
        dog2.runAnimal(600);
        dog3.runAnimal(900);

        System.out.println(" =======================");

        System.out.println(" ==== Who can Jump? ====");
        cat1.jumpAnimal(2);
        cat2.jumpAnimal(3);
        dog1.jumpAnimal(0.3);
        dog2.jumpAnimal(1);
        dog3.jumpAnimal(3);
        System.out.println(" =======================");

        System.out.println(" ==== Who can Swim? ====");
        cat1.swimAnimal(2);
        cat2.swimAnimal(3);
        dog1.swimAnimal(9);
        dog2.swimAnimal(11);
        dog3.swimAnimal(90);
        System.out.println(" =======================");
    }


}
