package ru.innopolis.pattern;

public class ImmutableClass {
    private final int a;
    private final int b;

    public ImmutableClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}