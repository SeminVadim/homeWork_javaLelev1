package ru.geekbrains.Homework05;

public class Truck extends Auto{
    static final float TANK = 60;
    static final float FUEL_IN_MILE = 15F;
    public Truck(String name, FuelStation fuelStation ) {
        super(name, TANK, FUEL_IN_MILE, fuelStation);
    }
}
