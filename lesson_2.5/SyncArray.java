package ru.geekbrains.HomeWork_05;

public class SyncArray {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    float[] arr = new float[SIZE];

    public void metod1() {
        System.out.println("Metod 1 start");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        a = System.currentTimeMillis() - a;

        System.out.println("time to work metod 1 = " + a);
        System.out.println("Metod 1 stop");
    }

    public void metod2() {
        System.out.println("Metod 2 start");
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);
       //
       new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (arr1) {
                    System.out.println("arr1");
                    for (int i = 0; i < arr1.length; i++) {
                        arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    }
                    System.out.println("arr1 end");
                }
            }
        }).start();
       //
       new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (arr2) {
                    System.out.println("arr2");
                    for (int i = 0; i < arr2.length; i++) {
                        arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    }
                    System.out.println("arr2 end");
                }
            }
        }).start();

        synchronized (arr1) {
            synchronized (arr2){
                System.arraycopy(arr1, 0, arr, 0, HALF);
                System.arraycopy(arr2, 0, arr, HALF, HALF);
                a = System.currentTimeMillis() - a;

                System.out.println("time to work metod 2= " + a);
                System.out.println("Metod 2 stop");
           }
        }
    }
}
