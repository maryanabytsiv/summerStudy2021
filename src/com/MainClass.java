package com;

import java.lang.reflect.Method;
import java.util.Arrays;

class Printer {

    public <T> void printArray(T[]args ) {
        for (Object obj : args) {
            System.out.println(obj.toString());
        }
    }
}

public class MainClass {



    public static void main(String[] args) {

        testHMap();
        //playWithReferences();

//        List<String> list = new ArrayList<>();
//        list.add("foo");
//        String o = list.get(0);    // No cast
//
//
//        List list1 = new ArrayList();
//        list1.add("2");
//        list1.add(2);
//        list1.add(2f);

        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();

            if (name.equals("printArray")) {
                count++;
            }
        }

        if (count > 1) {
            System.out.println("Method overloading is not allowed!");
        }


    }

    private static void playWithReferences() {
        int a = 5;
        System.out.println("Before = " + a);
        passValue(a);
        System.out.println("After = " + a);

        refTypesValueTypesExamples();
    }

    private static void refTypesValueTypesExamples() {
//        Integer b = 5;
//        System.out.println("Before = " + b);
//        passRef(b);
//        System.out.println("After = " + b);

        SmartClass sc = new SmartClass(1, "smart class");
        System.out.println("Before = " + sc.name + " " + sc.code + " " + sc.toString());
        passRef(sc);
        System.out.println("After = " + sc.name + " " + sc.code + " " + sc.toString());
    }

    public static void passRef(SmartClass sc) {
        sc = new SmartClass(2, "new");
    }

    public static void passValue(int value) {
        value += 100;
    }


    public static void testHMap() {

        HMap map = new HMap();
        HSet set = new HSet();

        Integer val1 = 11;
        Integer val1_1 = 22;
        Integer val3 = 33;
        String val4 = "44";
        String val5 = "55";

        map.put(1000, val1);
        System.out.println(map.get(1000));

        map.put(1, val5);
        System.out.println(map.get(1));

        map.put(2, val1_1);
        System.out.println(map.get(2));

        map.put(3, val3);
        System.out.println(map.get(3));

        map.put(4, val4);
        System.out.println(map.get(4));

        map.put(4, val5);
        System.out.println(map.get(4));

    }
}
