package ru.innopolis.lection06.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Serialization serialization = new Serialization();
        try {
            System.out.println(serialization.deSerialize("./ru.innopolis.lection06.homework.Car.xml").toString());
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        /*
        Car car = new Car("Giguly", 1997, "Green");
        //System.out.println(car.getClass().getName());
        Serialization serialization = new Serialization();
        serialization.serialize(car);
        /*
        //System.out.println(Arrays.toString(car.getClass().getTypeName().split(".")));
        //System.out.println(names[names.length - 1]);
        for (Field declaredField : car.getClass().getDeclaredFields()) {
            System.out.println("name: " + declaredField.getName());
            declaredField.setAccessible(true);
            System.out.println("val: " + declaredField.get(car));
        }
        */

    }
}