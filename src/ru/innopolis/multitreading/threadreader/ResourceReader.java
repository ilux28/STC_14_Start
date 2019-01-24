package ru.innopolis.multitreading.threadreader;

import java.io.BufferedReader;

public interface ResourceReader {
    BufferedReader reader(String resource);
}
