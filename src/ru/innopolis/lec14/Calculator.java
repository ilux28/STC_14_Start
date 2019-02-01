package ru.innopolis.lec14;

public class Calculator {
    public int sum(int a, int b) {
        return a + b;
    }

    public int divade(int a, int b) throws DivideByZeroException {
        if (b == 0) {
            throw new DivideByZeroException();
        }
        return a / b;
    }
}
