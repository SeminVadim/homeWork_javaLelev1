package ru.geekbrains.Lesson_7;

public class Cat {
    private String name;
    private int appetite;
    private boolean full;

    public Cat (String name, int appetite, boolean full) {
        this.name = name;
        this.appetite = appetite;
        this.full = full;
    }

    public void eat (Plate p) {
        System.out.println(String.format("Cat name: %s, is have appetite: %s and Try eat ", name, appetite));
        full = p.decreaseFod(appetite);
    }

    public void info () {
        System.out.println(String.format("Cat info: name: %s, appetite: %s, full: %s", name, appetite, full));
    }
}
