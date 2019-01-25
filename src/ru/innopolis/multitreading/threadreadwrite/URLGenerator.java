package ru.innopolis.multitreading.threadreadwrite;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * @author Ilya Pribytkov
 * @version 1.0
 */
public class URLGenerator {

    private String URL_Mask = "http://www.gutenberg.org/files/%1$s/%1$s.txt";
    private int maxRandom = 10000;
    private int count;

    public URLGenerator() {

    }
    public String[] getUrlMass(int count) {
        int i = 0;
        this.count = count;
        Set<Integer> numbers = new HashSet<>();
        List<String> resources = new ArrayList<>();

        while (i < count) {
            int random = new Random().nextInt(maxRandom) + 1;

            if (!numbers.contains(random) && isExist(String.format(URL_Mask, random))) {
                numbers.add(random);
                String resource = String.format(URL_Mask, random);
                resources.add(resource);
                i++;
            }
        }
        return resources.toArray(new String[count]);
    }
    public String getOne() {
        count = 1;
        String[] res = getUrlMass(count);
        return res[res.length - 1];
    }
    private boolean isExist(String res) {
        try {
            URL url = new URL(res);
            url.openStream();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}