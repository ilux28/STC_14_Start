package ru.innopolis.multitreading.threadreader;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class MultiThreadingFilesRead implements ThreadFileRead {
    private Set<String> set = new TreeSet<>();
    @Override
    public void getOccurrences(String[] sources, String[] words, String res) throws IOException, InterruptedException {
        for (String word : words)
            this.set.add(word);
        for (String source : sources) {
            UniversalFileReader fileReader = new UniversalFileReader(source, set, res);
            fileReader.findCoincidenceAndLaunchWriter();
        }
    }
}