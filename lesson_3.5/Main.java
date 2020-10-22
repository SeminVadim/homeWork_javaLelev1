package ru.geekbrains.Homework05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /**
         * 1. Создать классы Car, Truck, Bus. Каждый обладает объемом топлива и расходом (Car - 20\2.5, Truck - 60\15, Bus - 40\7.5)
                и уникальных значением для определения среди разных транспортных средств.
         * 2. Для каждого транспортного средства оставшиеся в баке количество топлива вычисляется раз в 3 сек.
         * 3. Создать до 10 экземпляров разных транспортных средств и запустить их в работу
         * 4. Создать класс FuelStaion. Одновременно может заправлять 3 автомобиля, остальные должны пока не освободится место.
                Заправка занимает 5 сек, зачем транспортное средство освобождает место
         * 5. Транспортные средства должны выстраиваться в очередь, если нет свобожных мест для заправки и начинать заправку
                в строгом порядке своей очередь
         * 6. Транспортные средства после заправки возвращаются на дорогу и продолжают свое движение
         */

        FuelStation fuelStation = new FuelStation();
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 4; i++) {
            executorService.execute(new Car("Car - "+i, fuelStation));
            executorService.execute(new Bus("Bus - "+i, fuelStation));
            executorService.execute(new Truck("Truck - "+i, fuelStation));
        }
        executorService.shutdown();
    }
}
