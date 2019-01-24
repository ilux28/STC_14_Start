package ru.innopolis.multitreading.threadreader;

import java.util.List;

public class WriterThread implements Runnable {
    private List<String> storeSentence;
    private String res;

    public WriterThread(List<String> storeSentence, String res) {
        this.storeSentence = storeSentence;
        this.res = res;
    }

    @Override
    public void run() {

    }
}
