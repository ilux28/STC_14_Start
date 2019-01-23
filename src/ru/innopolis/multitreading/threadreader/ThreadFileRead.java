package ru.innopolis.multitreading.threadreader;

import java.io.IOException;

public interface ThreadFileRead {
    void getOccurrences(String[] sources, String[] words, String res) throws IOException, InterruptedException;
}