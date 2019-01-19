package ru.innopolis.multitreading;

public class ThresdDemo {
    public static void main(String[] args) {
        Thread myThread = new MyThread();
        //myThread.setDaemon(true);

        myThread.start();
        myThread.interrupt();
        System.out.println("выполнение метода завершенро");
    }
}
