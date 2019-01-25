package ru.innopolis.multitreading.threadreader;

import java.io.IOException;

public class TestReader {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] words = {"again", "these", "volumes", "available", "publication",
                "and", "later", "substantial", "discount", "members"};
        URLGenerator urlGenerator = new URLGenerator();
        String[] sources = urlGenerator.getUrlMass(10);
        MultiThreadingFilesRead multiThreadingFilesRead = new MultiThreadingFilesRead();
        multiThreadingFilesRead.getOccurrences(sources, words, "./result.txt");
    }
}
