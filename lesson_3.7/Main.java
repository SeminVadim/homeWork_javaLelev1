package ru.geekbrains.Homework07_1;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        Class myClass = MyClass.class;
        MyClass myClass1= (MyClass) myClass.newInstance();

        ArrayList<Method> arrayList = new ArrayList<>();
        Method beforeMethod = null;
        Method afterMethod = null;

        //---
        for (Method o : myClass.getDeclaredMethods()) {
            if (o.isAnnotationPresent(Test.class)) {
                arrayList.add(o);
            }
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeMethod == null) {
                    beforeMethod = o;
                }
                else {
                    throw new RuntimeException("Exception more by one BeforeSuite");
                }
            }
            if (o.isAnnotationPresent(AfterSuite.class)) {
                if (afterMethod == null) {
                    afterMethod = o;
                }
                else {
                    throw new RuntimeException("Exception more by one AfterSuite");
                }
            }
            arrayList.sort((o1, o2) -> o2.getAnnotation(Test.class).priority()-o1.getAnnotation(Test.class).priority());
        }
        //---


        if (beforeMethod != null) {
            beforeMethod.invoke(myClass1, null);
        }

        for (Method o : arrayList) {
            o.invoke(myClass1, null);
        }

        if (afterMethod != null) {
            afterMethod.invoke(myClass1, null);
        }
    }
}
