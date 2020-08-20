package ru.geekbrains.HomeWork_3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner readConsole = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            firstMenu();
            if (getNumberFromScaner(1, 2) == 1) GuessNumber();
            else GuessWord();
            secondMenu();
        } while (getNumberFromScaner(1, 2) == 1);
        readConsole.close();
    }

    public static void GuessNumber () {
        System.out.println("Guess number from 0 to 9. You have 3 attempts");
        Random rand = new Random();
        int xNumber, youNumber, flag;

        do {
            flag = 0;
            xNumber = rand.nextInt(10);
            System.out.println(" --- Start Game ---");
            for (int i = 1; i < 4; i++) {
                System.out.println("Attempt - " + i + " - from 3");
                youNumber = getNumberFromScaner(0, 9);
                if (youNumber == xNumber) {
                    System.out.println("You win!");
                    flag = 1;
                    break;
                }
                else if (youNumber > xNumber) {
                    System.out.println("You number is  > ");
                }
                else {
                    System.out.println("You number is < ");
                }
            }
            if ( flag == 0) System.out.println("You Lose !");
            System.out.println("----------------------------------------");
            System.out.println("Do you want to play again this Game? 1 – yes / 0 – no");
        } while (getNumberFromScaner(0,1) == 1);
    }

    public static void GuessWord () {
        String[] words = new String[]{  "apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                                        "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
                                        "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random rand = new Random();
        int xWord, n;
        String youWord;
        boolean flag;
        xWord = rand.nextInt(words.length);
        //System.out.println("================");
        //System.out.println(words[xWord]);
        //System.out.println("================");

        do {
            flag = false;
            youWord = getStringFromScaner();
            if (youWord.length() > words[xWord].length()) n = words[xWord].length();
            else n = youWord.length();

            for (int i = 0; i < n; i++) {
                if (youWord.charAt(i) == words[xWord].charAt(i))
                    System.out.print(youWord.charAt(i));
                else {
                    System.out.print("#");
                    flag = true;
                }
            }
            if ((flag) || (youWord.length() != words[xWord].length())) {
                for (int i = n; i < 16; i++) {
                    System.out.print("#");
                }
                flag = true;
                System.out.println();
                System.out.println("Not rigth! Try agan!");
            }
            else System.out.println();
        } while (flag);
        System.out.println("You win!");
    }

    public static int getNumberFromScaner(int min, int max){
        int number;
        do {
            System.out.print("Please, print number from " + min + " to " + max + ": ");
            number = readConsole.nextInt();
        } while (number < min || number > max);
        return number;
    }

    public static String getStringFromScaner () {
        System.out.print("Please, print you word: ");
        String word = readConsole.next();
        System.out.println();
        return word;
    }

    public static void firstMenu() {
        System.out.println("============ Menu ============ ");
        System.out.println(" What Game do you want to play?");
        System.out.println(" * Press 1 to play Guess Number.");
        System.out.println(" * Press 2 to play Guess Word.");
        System.out.println("============ Menu ============ ");
    }

    public static void secondMenu () {
        System.out.println("============ Menu ============ ");
        System.out.println(" Do you want to play again?");
        System.out.println(" * Press 1 to choice Game.");
        System.out.println(" * Press 2 to Exit.");
        System.out.println("============ Menu ============ ");
    }
}

