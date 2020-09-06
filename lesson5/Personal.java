package ru.geekbrains.HomeWork_5;

public class Personal {
    private String name;
    private String position;
    private String email;
    private String telNumber;
    private double salary;
    private int age;

    public Personal(String name, String position, String email, String telNumber, double salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.telNumber = telNumber;
        this.salary = salary;
        this.age = age;
    }

    public String printToConsole() {
        return  "{ name = "     +name+
                ", position = " +position+
                ", email = "    +email+
                ", telNumber = "+telNumber+
                ", salary = "   +salary +
                ", age = "      +age+
                " }";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
