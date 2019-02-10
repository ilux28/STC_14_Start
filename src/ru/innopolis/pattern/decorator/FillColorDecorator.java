package ru.innopolis.pattern.decorator;

public class FillColorDecorator extends ShapeDecorator {
    Color color;
    public FillColorDecorator(Shape decoratedShape, Color color) {
        super(decoratedShape);
        this.color = color;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        System.out.println("Fill Color: " + color);
    }

    @Override
    public void resize() {
        decoratedShape.resize();
    }

    @Override
    public String description() {
        return decoratedShape.description() + " filled with" + color + " color.";
    }

    @Override
    public boolean isHide() {
        return decoratedShape.isHide();
    }
}
