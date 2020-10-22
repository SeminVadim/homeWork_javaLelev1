package ru.geekbrains.HomeWork_03;

import java.util.Objects;

public class PhoneBook {
    private String secondName;
    private String numberPhone;

    public PhoneBook(String secondName, String numberPhone) {
        this.secondName = secondName;
        this.numberPhone = numberPhone;
    }

    public String getSecondName() {
        return secondName;
    }

    public static Object getNumberPhone(Object o, String secondName) {
        PhoneBook book = (PhoneBook) o;
        if (Objects.equals(secondName, book.secondName)) {
            return book.numberPhone;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Card{" +
                "secondName = " + secondName +
                ", numberPhone = " + numberPhone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBook book = (PhoneBook) o;
        return Objects.equals(secondName, book.secondName) &&
                Objects.equals(numberPhone, book.numberPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(secondName,numberPhone);
    }
}
