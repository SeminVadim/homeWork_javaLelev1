package ru.geekbrains.HomeWork_02;

public class MySizeArrayException extends Exception {
    public MySizeArrayException() {
    }

    public MySizeArrayException(String message) {
        super(message);
    }

    public MySizeArrayException(String message, Throwable cause) {
        super(message, cause);
    }
}