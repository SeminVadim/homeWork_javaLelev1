package ru.geekbrains.HomeWork_4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner readConsole = new Scanner(System.in);
    public static Random rand = new Random();
    public static int[] move = new int[3];

    public static void main(String[] args) {
        /**
         * Урок 4. Крестики-нолики в процедурном стиле
         * + Ok. 1. Полностью разобраться с кодом, попробовать переписать с нуля
         * + Ok. 2. Доработать все возможные варианты победы
         * + Ok. 3. Предусмотреть ничью
         * + Ok. 4. Предусмотреть проверку на допустимый диапазон значений вводимых координат пользователем,
         *          чтобы не выйти за пределы массива
         * + Ok. 5. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока
         */

        do {
            firstMenu();
            if (getNumberFromScaner(1, 2) == 1) startGame(1);
            else startGame(2);
            secondMenu();
        } while (getNumberFromScaner(1, 2) == 1);
        readConsole.close();
    }

    public static void startGame(int typeGame) {
        char[][] gameField = initField();
        showField(gameField);
        boolean flagManWin = false, flagPCWin = false;
        int count = 0;

        // start Game
        do {
            // move Man
            System.out.println("============= Man's move ============= ");
            do {
                move = manMove();
            } while (!checkMove(gameField, move));
            gameField[move[0]][move[1]] = 'X';
            showField(gameField);
            if (checkWinner(gameField, 'X')) {
                flagManWin = true;
            }
            count++;

            // move PC
            if (count < 5) {
                System.out.println("============= PC move ============= ");
                do {
                    if (typeGame == 1) {
                        // Игра рандом.
                        move = pcMove();
                    } else {
                        //Игра с логикой.
                        //Если можем то выигрываем.
                        move[2] = 0;
                        move = spyPc(gameField, 'O');
                        if (move[2] == 1) continue;

                        //Если нет выигрышной комбинации, то блокируем
                        move = spyPc(gameField, 'X');
                        if (move[2] == 1) continue;

                        //Иначе рандом
                        move = pcMove();
                    }
                } while (!checkMove(gameField, move));
                gameField[move[0]][move[1]] = 'O';
                showField(gameField);
                if (checkWinner(gameField, 'O')) {
                    flagPCWin = true;
                }
            }
            // check message winner
            if (flagManWin && flagPCWin) {
                System.out.println("!!! Winner is Fredship !!!");
                break;
            } else if (flagManWin) {
                System.out.println("!!! Winner is Man !!!");
                break;
            } else if (flagPCWin) {
                System.out.println("!!! Winner is PC !!!");
                break;
            } else if (count == 5) {
                System.out.println("!!! No body win !!!");
                break;
            }
        } while (true);
    }

    public static char[][] initField() {
        char[][] gameField = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'},
        };
        return gameField;
    }

    public static void showField(char[][] gameField) {
        System.out.println("  | 1 | 2 | 3 |");
        for (int i = 0; i < gameField.length; i++) {
            System.out.print(i + 1 + " | ");
            for (int j = 0; j < gameField[i].length; j++) {
                System.out.print(gameField[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public static int[] manMove() {
        System.out.print("Player man you move, please enter X coordinate -");
        move[0] = getNumberFromScaner(1, 3) - 1;
        System.out.print("Player man you move, please enter Y coordinate -");
        move[1] = getNumberFromScaner(1, 3) - 1;
        return move;
    }

    public static int[] pcMove() {
        move[0] = rand.nextInt(3);
        move[1] = rand.nextInt(3);
        return move;
    }

    public static boolean checkMove(char[][] gameField, int[] move) {
        if (gameField[move[0]][move[1]] == '-') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkWinner(char[][] gameField, char sign) {
        int x1 = 0, x2 = 0;
        for (int i = 0; i < gameField.length; i++) {
            if ((gameField[i][0] == gameField[i][1] && gameField[i][1] == gameField[i][2] && gameField[i][2] == sign) ||
                    (gameField[0][i] == gameField[1][i] && gameField[1][i] == gameField[2][i] && gameField[2][i] == sign)) {
                return true;
            }
            if (gameField[0][0] == gameField[i][i] && gameField[i][i] == sign) x1++;
            if (gameField[0][gameField.length - 1] == gameField[i][gameField.length - 1 - i] && gameField[i][gameField.length - 1 - i] == sign)
                x2++;
        }
        if (x1 == gameField.length || x2 == gameField.length) {
            return true;
        }
        return false;
    }

    public static int[] spyPc(char[][] gameField, char sign) {
        int sumX = 0;

        // проверка строк
        for (int i = 0; i < gameField.length; i++) {
            sumX = 0;
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[i][j] == sign) {
                    sumX++;
                }
            }
            if (sumX == 2) {
                for (int j = 0; j < gameField[i].length; j++) {
                    if (gameField[i][j] == '-') {
                        move[0] = i;
                        move[1] = j;
                        move[2] = 1;
                        return move;
                    }
                }
            }
        }
        // проверка столбцов
        for (int i = 0; i < gameField.length; i++) {
            sumX = 0;
            for (int j = 0; j < gameField.length; j++) {
                if (gameField[j][i] == sign) {
                    sumX++;
                }
            }
            if (sumX == 2) {
                for (int j = 0; j < gameField.length; j++) {
                    if (gameField[j][i] == '-') {
                        move[0] = j;
                        move[1] = i;
                        move[2] = 1;
                        return move;
                    }
                }
            }
        }
        // проверка главной диагонали
        sumX = 0;
        for (int i = 0; i < gameField.length; i++) {
            if (gameField[i][i] == sign) {
                sumX++;
            }
        }
        if (sumX == 2) {
            for (int i = 0; i < gameField.length; i++) {
                if (gameField[i][i] == '-') {
                    move[0] = i;
                    move[1] = i;
                    move[2] = 1;
                    return move;
                }
            }
        }
        // проверка втростепенной диагонали
        sumX = 0;
        for (int i = gameField.length - 1; i < 0; i--) {
            if (gameField[gameField.length - 1 - i][i] == sign) {
                sumX++;
            }
        }
        if (sumX == 2) {
            for (int i = gameField.length - 1; i < 0; i--) {
                if (gameField[gameField.length - 1 - i][i] == '-') {
                    move[0] = gameField.length - 1 - i;
                    move[1] = i;
                    move[2] = 1;
                    return move;
                }
            }
        }
        return move;
    }

    public static void firstMenu() {
        System.out.println("============ Menu ============ ");
        System.out.println(" What Game do you want to play?");
        System.out.println(" * Press 1 to play with Random.");
        System.out.println(" * Press 2 to play with SuperPuper IntelliJ'en PC.");
        System.out.println("============ Menu ============ ");
    }

    public static void secondMenu() {
        System.out.println("============ Menu ============ ");
        System.out.println(" Do you want to play again?");
        System.out.println(" * Press 1 to choice Game.");
        System.out.println(" * Press 2 to Exit.");
        System.out.println("============ Menu ============ ");
    }

    public static int getNumberFromScaner(int min, int max) {
        int number;
        do {
            System.out.print("Please, print number from " + min + " to " + max + ": ");
            number = readConsole.nextInt();
        } while (number < min || number > max);
        return number;
    }
}

