package ru.innopolis.multitreading.threadreader;


import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * @author IlyaPribytkov
 * @version 1.0
 */

public class UniversalFileReader {
    String path;
    Set<String> targetWords;
    String res;

    public UniversalFileReader(String path, Set<String> targetWords, String res) {
        this.path = path;
        this.targetWords = targetWords;
        this.res = res;
    }
    /**
     * @return get BufferedReader for reading
     * @throws IOException
     */
    private BufferedReader getResource() throws IOException {
        InputStream is;
        try {
            is = new URL(path).openStream();
        } catch (IOException e) {
            is = new FileInputStream(path);
        }
        return new BufferedReader(new InputStreamReader(is));
    }
    /**
     * This method read from source text, searching in him sentence,
     * in sentence found coincidence in sentence the word and write there in file res
     * @throws IOException
     */
    public void findCoincidenceAndLaunchWriter() throws IOException {
        try (BufferedReader r = this.getResource()) {
            StringBuilder content = null;
            int c;
            while ((c = r.read()) != -1) {
                if ((c == '.') || (c == '!') || (c == '?')) {
                    String sentence = content.toString().toLowerCase();
                    for (String str : this.targetWords) {
                        if (sentence.contains(str)) {
                            Thread threadWriter = new Thread(new UniversalWriter(sentence, str));
                            threadWriter.start();
                        }
                    }
                } else {
                    if (c == '\n' || c == '\r' || c == ',' || c == ';' || c == ':' || c == '-') {
                        content.append(" ");
                    } else {
                        //System.out.println(content.toString());
                        content.append(c);
                    }
                }
            }
        }
    }
}
