package ru.innopolis.multitreading.threadreadwrite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ThreadWriter implements Runnable {

    private String sentence;
    private String res;

    public ThreadWriter(String sentence, String res) {
        this.sentence = sentence;
        this.res = res;
    }

    private synchronized void write(String sentence, String res) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(res))) {
            bw.write(sentence);
            bw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Write sentence: " + sentence);
        write(this.sentence, this.res);
    }
}