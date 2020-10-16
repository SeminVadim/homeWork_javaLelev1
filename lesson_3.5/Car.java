package ru.geekbrains.Homework05;

public class Car extends Auto{
    static final float TANK = 20;
    static final float FUEL_IN_MILE = 2.5F;
    public Car(String name, FuelStation fuelStation ) {
        super(name, TANK, FUEL_IN_MILE, fuelStation);
    }
}
