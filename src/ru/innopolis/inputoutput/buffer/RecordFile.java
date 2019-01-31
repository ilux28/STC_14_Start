package ru.innopolis.inputoutput.buffer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * This class record in file on path
 * @author Ilya Pribytkov
 * @version 1.0
 */
public class RecordFile {
    /**
     * This method created file
     * @param path - storage path
     * @param n - quantity files
     * @param size - size of file
     * @param words - array of words
     * @param probability - probability occurrence one word from array words
     */
    //String path = "C://Users/Public/Documents/";
    public void getFiles(String path, int n, int size, String[] words, int probability) throws IOException {

        for (int i = 0; i < n - 1; i++) {
            StringBuilder strPath = new StringBuilder();
            strPath.append(path).append(i + 1).append(".txt");
            RandomText tx = new RandomText();
            String txt = tx.generateRandomText(size);
            String[] str = txt.split(" ");
            List<String> arrayList = new ArrayList<String>(Arrays.asList(str));
            if ((new Random().nextInt(10) + 1) / 10 > probability)
                arrayList.add(new Random().nextInt(arrayList.size()), words[new Random().nextInt(words.length)]);
            StringBuilder text = new StringBuilder();
            for (String string : arrayList)
                text.append(string).append(" ");
            try (FileWriter writer = new FileWriter(path,false)) {
                writer.append(text);
                writer.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}