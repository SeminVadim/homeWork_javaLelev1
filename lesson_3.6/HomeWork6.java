package ru.geekbrains.Homework06_1;

public class HomeWork6 {

    public static void main(String[] args) {
        /**
         * 1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
         * Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
         * идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,иначе в методе
         * необходимо выбросить RuntimeException. Написать набор тестов для этого метода(по 3-4 варианта входных данных).
         * Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
         *
         * 2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки
         * или единицы, то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
         * */

        int [] mas1 = {1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9};
        int [] mas3 = {2,3,5,6,7,8,9,0,2,3,5,6,7,8,9};

        int [] mas2 = new int[0];

        try {
            mas2 = returnArray (mas3);
        } catch (Exception e){
            e.printStackTrace();
        }
        showArray(mas3);
        showArray(mas2);


        System.out.println(checkArray(mas1));
        System.out.println(checkArray(mas3));
    }

    public static void showArray (int [] inArray) {
        for (int i = 0; i < inArray.length; i++) {
            System.out.print(inArray[i] + " ");
        }
        System.out.println();
    }

    public static int[] returnArray(int[] inArray) {
        int index = -1;

        for (int i = 0; i < inArray.length; i++) {
            if (inArray[i] == 4) {
                index = i;
            }
        }

        if (index == -1 || (index+1) >= inArray.length) {
            throw new RuntimeException();
        } else {
            int j = 0;
            index++;
            int [] outArray = new int[inArray.length-index];
            for (int i = index; i < inArray.length; i++) {
                outArray[j] = inArray[i];
                j++;
            }
            return outArray;
        }
    }

    public static boolean checkArray (int[] inArray) {
        boolean flag_1 = false, flag_4 = false;

        for (int i = 0; i < inArray.length; i++) {
            if (inArray[i] == 1) {
                flag_1 = true;
            }
            else if (inArray[i] == 4) {
                flag_4 = true;
            } else {
                return false;
            }
        }
        return flag_1 && flag_4;
    }
}
