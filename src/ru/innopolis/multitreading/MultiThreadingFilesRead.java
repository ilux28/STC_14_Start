package ru.innopolis.multitreading;

import java.io.IOException;

public class MultiThreadingFilesRead implements ThreadFileRead {
    @Override
    public void getOccurrencies(String[] sources, String[] words, String res) throws IOException, InterruptedException {
        int size = Runtime.getRuntime().availableProcessors();

    }
}
