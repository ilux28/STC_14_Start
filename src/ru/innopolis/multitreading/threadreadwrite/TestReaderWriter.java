package ru.innopolis.multitreading.threadreadwrite;


import java.io.IOException;

public class TestReaderWriter {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] words = {"again", "these", "volumes", "available", "publication",
                "and", "later", "substantial", "discount", "members"};
        URLGenerator urlGenerator = new URLGenerator();
        String[] sources = urlGenerator.getUrlMass(10);
        for (String source : sources) {
            Thread thread = new Thread(new UniversalReaderThread(source, words, "./result.txt"));
            thread.start();
        }

    }
}
