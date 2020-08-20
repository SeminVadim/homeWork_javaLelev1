package ru.geekbrains.HomeWork_01;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        /**
         * 1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
         * Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
         *
         * 2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны
         * выполнять соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль
         * (успешно пробежал, не смог пробежать и т.д.).
         *
         * 3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
         * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
         * Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
         */

        /**
         *  Task #1
         */
        System.out.println("===== Task #1 =====");

        Mans superMan = new Mans("SuperMan",10,5);
        Cats catTom = new Cats("Tom",20,10);
        Robots robotBender = new Robots("Bender",2,2);

        superMan.run();
        superMan.jump();

        catTom.run();
        catTom.jump();

        robotBender.run();
        robotBender.jump();

        /**
         *  Task #2
         */
        System.out.println();
        System.out.println("===== Task #2 =====");

        Runway runway = new Runway();

        System.out.println("=== Испытание беговой дорожкой ===");
        System.out.print(superMan.getName() + ": ");
        runway.start(superMan.getRunLimit());

        System.out.print(catTom.getName()+ ": ");
        runway.start(catTom.getRunLimit());

        System.out.print(robotBender.getName()+ ": ");
        runway.start(robotBender.getRunLimit());

        Wall wall = new Wall();

        System.out.println("=== Испытание стеной ===");
        System.out.print(superMan.getName() + ": ");
        wall.start(superMan.getJumpLimit());

        System.out.print(catTom.getName()+ ": ");
        wall.start(catTom.getJumpLimit());

        System.out.print(robotBender.getName()+ ": ");
        wall.start(robotBender.getJumpLimit());

        /**
         *  Task #3
         */
        System.out.println();
        System.out.println("===== Task #3 =====");

        TeamChampions[] arrayTeam = new TeamChampions[3];
        arrayTeam[0] = superMan;
        arrayTeam[1] = catTom;
        arrayTeam[2] = robotBender;

        TestRunWall[] arrayTest = new TestRunWall[3];
        arrayTest[0] = wall;
        arrayTest[1] = runway;
        arrayTest[2] = wall;

        for (int i = 0; i < arrayTeam.length; i++){
            System.out.print(i + "-ым Испытания проходит: ");
            System.out.println(arrayTeam[i].printToConsole());
            boolean flag = true;
            for (int j =0; j < arrayTest.length; j++) {
                if (arrayTest[j].getClass().getName().endsWith("Wall")) {
                    if (arrayTest[j].start(arrayTeam[i].getJumpLimit())) {
                    }
                    else {
                        System.out.println("Сошел с дистанции");
                        flag = false;
                        break;
                    }
                }
                if (arrayTest[j].getClass().getName().endsWith("Runway")) {
                    if (arrayTest[j].start(arrayTeam[i].getRunLimit())) {
                    }
                    else {
                        System.out.println("Сошел с дистанции");
                        flag = false;
                        break;
                    }
                }
            }
            System.out.println("===================================");
            if (flag) System.out.println("Полоса препятствий пройдена");
            System.out.println("===================================");
        }
    }
}
