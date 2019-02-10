package ru.innopolis.pattern.decorator;

public class LineThinknessDecorator extends ShapeDecorator {
    protected double thickness;

    public LineThinknessDecorator(Shape decoratedShape, double thickness) {
        super(decoratedShape);
        this.thickness = thickness;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        System.out.println("Line thickness" + thickness);
    }

    @Override
    public void resize() {
        decoratedShape.resize();
    }

    @Override
    public String description() {
        return decoratedShape.description() + " draw with line thickness " + thickness + ".";
    }

    @Override
    public boolean isHide() {
        return decoratedShape.isHide();
    }
}