package ru.innopolis.multitreading.threadreadwrite;


import java.io.IOException;
import java.util.Arrays;

public class TestReaderWriter {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] words = {"again", "these", "volumes", "available", "publication",
                "and", "later", "substantial", "discount", "members"};
        URLGenerator urlGenerator = new URLGenerator();
        String[] sources = urlGenerator.getUrlMass(10);
        Arrays.stream(sources).map(source -> new Thread(new UniversalReaderThread(source, words, "./result.txt"))).forEach(Thread::start);
    }
}