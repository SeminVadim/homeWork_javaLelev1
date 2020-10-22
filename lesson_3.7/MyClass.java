package ru.geekbrains.Homework07_1;

public class MyClass {
    @BeforeSuite
    public void start() {
        System.out.println("BeforeSuite");
    }

    @Test(priority = 10)
    public void test1() {
        System.out.println("test1");
    }

    @Test(priority = 8)
    public void test2() {
        System.out.println("test2");
    }

    @Test(priority = 5)
    public void test3() {
        System.out.println("test3");
    }

    @Test(priority = 1)
    public void test4() {
        System.out.println("test4");
    }

    public void helloWorld() {
        System.out.println("helloWorld");
    }

    @AfterSuite
    public void theEnd() {
        System.out.println("AfterSuite");
    }

}

