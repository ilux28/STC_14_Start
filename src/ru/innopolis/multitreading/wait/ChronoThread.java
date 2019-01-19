package ru.innopolis.multitreading.wait;

public class ChronoThread extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (!isInterrupted()) {
            try {
                sleep(100);
                System.out.println("chrono" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}
