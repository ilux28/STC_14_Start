package ru.innopolis.multitreading.threadreadwrite;

import java.io.IOException;

public interface ReadWriteThread {
    void getOccurrences(String[] source, String[] words, String res) throws IOException, InterruptedException;
}
