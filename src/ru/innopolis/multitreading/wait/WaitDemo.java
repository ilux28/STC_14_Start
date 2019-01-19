package ru.innopolis.multitreading.wait;

public class WaitDemo {
    public static void main(String[] args) {
        Thread thread = new ChronoThread();
        thread.start();
    }
}
