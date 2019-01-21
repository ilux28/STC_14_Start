package ru.innopolis.multitreading;

import java.io.IOException;

public interface ThreadFileRead {
    void getOccurrencies(String[] sources, String[] words, String res) throws IOException, InterruptedException;
}