package ru.innopolis.multitreading.threadreader;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Callable;

public class Parser implements Callable<List<String>> {
    private final String source;

    public Parser(String source, List<String> keyWords) {
        this.source = source;
        this.keyWords = keyWords;
    }

    private final List<String> keyWords;

    @Override
    public List<String> call() throws Exception {
        /*
        try(BufferedReader br = new BufferedReader(new InputStreamReader(getInputStream(source))) {

        } catch (Exception ex) {

        } finally {

        }
    */
        return null;
    }

    private InputStream getInputStream(String source) throws IOException {
        URL url = getURL(source);
        if (url == null) {
            return new FileInputStream(source);
        }
            return url.openStream();
    }

    private URL getURL(String url) {
        try {
            return new URL(url);
        } catch (Exception e) {
            return null;
        }
    }
}
