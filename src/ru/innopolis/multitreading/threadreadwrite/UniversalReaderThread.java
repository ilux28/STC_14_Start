package ru.innopolis.multitreading.threadreadwrite;


import java.io.*;
import java.net.URL;
import java.util.Arrays;

public class UniversalReaderThread implements Runnable {

    private String source;
    private String[] words;
    private String res;

    public UniversalReaderThread(String source, String[] words, String res) {
        this.source = source;
        this.words = words;
        this.res = res;
    }

    @Override
    public void run() {
        try (BufferedReader r = getBufferedReader(source)) {
            StringBuilder content = new StringBuilder();
            int c;
            while ((c = r.read()) != -1) {
                if ((c != '.') && (c != '!') && (c != '?')) {
                    if (c == '\n' || c == '\r') {
                        content.append(' ');
                    } else {
                        assert (c != -1);
                        content.append((char) c);
                    }
                } else {
                    String sentence = content.toString().toLowerCase();
                    content.delete(0, content.length() - 1);
                    Arrays.stream(this.words).map(word -> new Thread(new ThreadWriter(sentence, res)))
                            .filter(word -> sentence.equals(word));
                    /*
                    for (String word : this.words) {
                        if (sentence.contains(word.toLowerCase())) {
                            Thread thread = new Thread(new ThreadWriter(sentence, res));
                            thread.start();
                        }
                    }
                    */
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return BufferedReader for reading regardless of
     * @throws IOException
     */
    private BufferedReader getBufferedReader(String source) throws FileNotFoundException {
        InputStream is;
        try {
            is = new URL(source).openStream();
        } catch (IOException e) {
            is = new FileInputStream(source);
        }
        return new BufferedReader(new InputStreamReader(is));
    }
}