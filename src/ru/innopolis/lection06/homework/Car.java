package ru.innopolis.lection06.homework;

public class Car {
    private String name;
    private int age;
    private String colour;

    public Car() {
    }

    public Car(String name, int age, String colour) {
        this.name = name;
        this.age = age;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", colour='" + colour + '\'' +
                '}';
    }
}
