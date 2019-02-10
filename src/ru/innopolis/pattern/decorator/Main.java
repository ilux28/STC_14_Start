package ru.innopolis.pattern.decorator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Creating Simple Shape Objects...");
        Shape rectangle = new Rectangle();
        Shape circle = new Circle();

        System.out.println("Drawing Simple Shape Objects...");
        rectangle.draw();
        System.out.println();
        circle.draw();
        System.out.println();

        System.out.println("Creating Decorated Circle with Red Color, Blue Lines in dash pattern and thickness");
        Shape circle1 = new FillColorDecorator(
                new LineColorDecorator(
                        new LineStyleDecorator(
                                new LineThinknessDecorator(
                                        new Circle(), 2.0d), LineStyle.DASH), Color.BLUE), Color.RED);
        System.out.println();
        //order of decorator is also not much important here since all are are unique functionalities
    }
}
