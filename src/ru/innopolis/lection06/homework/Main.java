package ru.innopolis.lection06.homework;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
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
