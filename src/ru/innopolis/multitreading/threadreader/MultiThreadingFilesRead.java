package ru.innopolis.multitreading.threadreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MultiThreadingFilesRead implements ThreadFileRead {
    @Override
    public void getOccurrences(String[] sources, String[] words, String res) throws IOException, InterruptedException {
        List<String> keyWord = Collections.unmodifiableList(Arrays.asList(words));
        int size = Runtime.getRuntime().availableProcessors();
        for (String source : sources) {
        }
    }
}