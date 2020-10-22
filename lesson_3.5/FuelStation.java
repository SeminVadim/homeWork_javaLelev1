package ru.geekbrains.Homework05;

import java.util.concurrent.Semaphore;

public class FuelStation {
    private Semaphore smp = new Semaphore(3);

    public float refuel(String name, float tank) {
        System.out.println("Welcome on FuelStation");

        try {
            System.out.println("Transport: " + name + " before fuelStation");
            smp.acquire();
            System.out.println("Transport: " + name + " start refuel");
            Thread.sleep(5000);
            System.out.println("Transport: " + name + " refuel is ok");
            return tank;

        } catch (Exception e) {
            throw new RuntimeException("SSW with refuel", e);
        } finally {
            System.out.println("Transport: " + name + " is left fuelStation");
            smp.release();

        }
    }
}
