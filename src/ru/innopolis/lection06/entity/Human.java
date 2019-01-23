package ru.innopolis.lection06.entity;

@HumanAnnotation(name = "Строитель")
public class Human {
    public static String human = "Гуманойд";
    private String name = "Вася";
    private final int money = 100;

    @Override
    public String toString() {
        return "Human{" +
        "name='" + name + '\'' +
        ", money=" + money +
        "}, human = " + human;
    }

}
