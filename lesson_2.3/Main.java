package ru.geekbrains.HomeWork_03;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        /**
         * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
         * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
         * Посчитать сколько раз встречается каждое слово.
         *
         * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
         * - В этот телефонный справочник с помощью метода add() можно добавлять записи.
         * - С помощью метода get() искать номер телефона по фамилии.Следует учесть, что под одной фамилией может быть
         * несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
         */

        /**
            Task #1
         */
        System.out.println("=== Task #1 ===");
        String[] arraySecondName = { "фамилия1","фамилия1","фамилия1","фамилия1","фамилия1","фамилия1","фамилия1",
                                    "фамилия2","фамилия2","фамилия2","фамилия2","фамилия2","фамилия2","фамилия2",
                                    "фамилия3","фамилия3","фамилия3","фамилия3","фамилия3","фамилия3","фамилия3",
                                    "фамилия4","фамилия4","фамилия4","фамилия4","фамилия4","фамилия4","фамилия4"
        };

        Map<String,Integer> arraySecondNameCount = new HashMap<>();

        for (String s:arraySecondName) {
            if(arraySecondNameCount.containsKey(s)){
                arraySecondNameCount.put(s,arraySecondNameCount.get(s)+1);
            } else arraySecondNameCount.put(s,1);
        }

        for (Map.Entry<String, Integer> o : arraySecondNameCount.entrySet()) {
            System.out.println(o.getKey() + ": " + o.getValue());
        }
        System.out.println("=== Task #1 ===");

        /**
         Task #2
         */
        System.out.println("=== Task #2 ===");
        List<PhoneBook> book = new ArrayList<>(Arrays.asList(
                new PhoneBook("Aaa", "123a"), new PhoneBook("Bbb", "123a"),new PhoneBook("Ccc", "123a"),
                new PhoneBook("Ddd", "123d"),new PhoneBook("Eee", "123e"),new PhoneBook("Fff", "123f"),
                new PhoneBook("Ggg", "123g"),new PhoneBook("Hhh", "123h"),new PhoneBook("Iii", "123i"),
                new PhoneBook("Aaa", "123aa"),new PhoneBook("Bbb", "123bb"),new PhoneBook("Ccc", "123cc")
        ));

        System.out.println(book);
        String addSecondName = "Xxx";
        String addNumberPhone = "123xxx";
        book.add(0, new PhoneBook(addSecondName,addNumberPhone));
        System.out.println(book);

        String searchSecondName = "Aaa";
        System.out.println("Search phone number for: " + searchSecondName);
        Iterator<PhoneBook> iter = book.iterator();
        while (iter.hasNext()) {
            PhoneBook str = iter.next();
            if (null != PhoneBook.getNumberPhone(str,searchSecondName)) {
                System.out.println(PhoneBook.getNumberPhone(str,searchSecondName));
            }
        }
        System.out.println("=== Task #2 ===");
    }
}
