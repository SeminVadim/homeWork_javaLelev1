package ru.geekbrains.Homework05;

public class Bus extends Auto {
    static final float TANK = 40;
    static final float FUEL_IN_MILE = 7.5F;
    public Bus(String name, FuelStation fuelStation ) {
        super(name, TANK, FUEL_IN_MILE, fuelStation);
    }
}
