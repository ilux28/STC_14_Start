package ru.innopolis.multitreading.threadpool;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread number " + Thread.currentThread().getName() + " is started!");
    }
}
