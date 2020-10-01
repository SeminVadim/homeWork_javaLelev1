package ru.geekbrains.Lesson_7;

import java.util.Random;

public class Main {
	/**
	 * 	+ 1. Расширить задачу про котов и тарелки с едой
	 * 	+ 2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
	 * 	+ 3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true
	 * 	+ 4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
	 * 	+ 5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
	 * 	+ 6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
	*/
    public static void main(String[] args) {
		Random rand = new Random();
    	Cat [] catArray = new Cat[10];
		Plate plate =new Plate(30);

		System.out.println("============ Create Cat's ============");
		for (int i = 0; i < catArray.length; i++) {
			catArray[i] = new Cat("cat"+i, rand.nextInt(10)+1, false );
			catArray[i].info();
		}

		System.out.println("============ Feed Cat's ============");
		for (int i = 0; i < catArray.length; i++) {
			catArray[i].eat(plate);
		}
		System.out.println("============ Print info about Cat's ============");
		for (int i = 0; i < catArray.length; i++) {
			catArray[i].info();
		}
		System.out.println("============");
		plate.info();
		plate.addFood();
		System.out.println("============");
		plate.info();
    }
}
