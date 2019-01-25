package ru.innopolis.multitreading.threadreader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UniversalWriter implements Runnable {

    private String sentence;
    private String res;

    public UniversalWriter(String sentence, String res) {
        this.sentence = sentence;
        this.res = res;
    }

    private synchronized void writer(String sentence, String res) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(res))) {
            bw.write(sentence);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        writer(this.sentence, this.res);
    }
}
