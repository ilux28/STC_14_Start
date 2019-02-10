package ru.innopolis.pattern.decorator;

public interface Shape {
    void draw();

    void resize();

    String description();

    boolean isHide();
}
