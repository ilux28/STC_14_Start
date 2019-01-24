package ru.innopolis.multitreading.threadreader;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterThread implements Runnable {
    private String sentence;
    private String res;

    public WriterThread(String sentence, String res) {
        this.sentence = sentence;
        this.res = res;
    }
    public synchronized void writeSent() throws IOException {
        try (FileWriter writer = new FileWriter(res, false)) {
            writer.write(sentence);
            writer.flush();
        }
    }

    @Override
    public void run() {
        try {
            writeSent();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
