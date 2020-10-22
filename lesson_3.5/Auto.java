package ru.geekbrains.Homework05;

public abstract class Auto implements Runnable {
    protected String name;
    protected float tank;
    protected float fuelInMile;
    protected float fuelInTank;
    protected FuelStation fuelStation;

    public Auto(String name, float tank, float fuelInMile, FuelStation fuelStation) {
        this.name = name;
        this.tank = tank;
        this.fuelInMile = fuelInMile;
        this.fuelStation = fuelStation;
        this.fuelInTank = tank;
    }

    public void checkFuel () {
        try {
            while (true) {
                System.out.println(String.format("Check fuel in Transport: %s, fuel is left in tank: %s ", name, fuelInTank));
                Thread.sleep(3000);
                fuelInTank = fuelInTank - fuelInMile;

                if (fuelInTank <= fuelInMile) {
                    System.out.println(String.format("Transport: %s, fuel is few: %s, need go to FuelStation.", name,fuelInTank));
                    fuelInTank = fuelStation.refuel(name, tank);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("SWW with fuelLeft", e);
        }
    }

    @Override
    public void run() {
        checkFuel();
    }
}
