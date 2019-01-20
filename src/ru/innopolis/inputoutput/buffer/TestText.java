package ru.innopolis.inputoutput.buffer;

import java.io.IOException;

public class TestText {
    public static void main(String[] args) throws IOException {
        /*
        RandomText tx = new RandomText();
        String txt = tx.generateRandomText(20);
        System.out.println(txt);
        */
        String[] words = new RandomText().generateRandomText(20).split(" ");
        RecordFile recordFile = new RecordFile();
        recordFile.getFiles("C://Users/Public/Documents/",2, 5, words, 10);
    }
}
