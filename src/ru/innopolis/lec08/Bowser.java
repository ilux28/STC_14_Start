package ru.innopolis.lec08;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Bowser {
    //public static final String ADDRESS = "file:///C:\\Users\\admin\\IdeaProjects\\STC_14_Start_001\\src\\ru\\innopolis\\lec08\\text.txt";
    public static final String ADDRESS = "";
    public static void main(String[] args) throws IOException {
        URL url = new URL(ADDRESS);
        try (BufferedReader is =
                     new BufferedReader(
                             new InputStreamReader(url.openStream()))) {
            String line;
            while ((line = is.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
