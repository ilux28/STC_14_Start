package ru.innopolis.multitreading.threadreader;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThreadReader extends Thread {
    String path;
    Set<String> targetWords;
    String res;
    String name;
    public ThreadReader(String path, Set<String> targetWords, String res, String name) {
        this.path = path;
        this.targetWords = targetWords;
        this.res = res;
        this.name = name;
    }
    private static final String REG_EXPRESSION_NOT_FULL_END = "[A-ZА-Я][^.?!]*$";
    private static final String REG_EXPRESSION_NOT_FULL_BEGIN = "^[^A-ZА-Я.!?]+[.?!]";
    private static final String REG_EXPRESSION_FULL = "^[A-ZА-Я][^.?!]+[!?.]";
    private String unFinSent = "";

    private BufferedReader reader;


    Pattern endNotFull = Pattern.compile(REG_EXPRESSION_NOT_FULL_END);
    Pattern beginNotFul = Pattern.compile(REG_EXPRESSION_NOT_FULL_BEGIN);
    Pattern full_exp = Pattern.compile(REG_EXPRESSION_FULL);

    /**
     * regular expression find
     */

    private BufferedReader getResource() throws IOException {
        InputStream is;
        if(isURL(path)) {
            is = new URL(path).openStream();
        } else {
            is = new FileInputStream(path);
        }
        return new BufferedReader(new InputStreamReader(is));
    }

    /**
     * This method is a parsing resource
     * @throws IOException error of reading
     */
    public void parseResourse() throws IOException {
        long startTime = System.currentTimeMillis();
        try (BufferedReader r = this.getResource()) {

            String content;
            while ((content = r.readLine()) != null) {
            }
        }
    }
    /**
     * check path has been is url
     * @param url
     * @return boolean
     */
    private boolean isURL(String url) {
        try {
            new URL(url);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private void checkLine(String line) throws IOException {
        if (!this.unFinSent.equals("")) {
            String[] continSent = coincidenceWord(beginNotFul, line);
            if (continSent.length == 0)
                unFinSent += line;
            String continuation = continSent[0];
            String sentence = unFinSent + " " + continuation;
            if (isMathch(sentence)) {
             //   this.storage.writeSentence(sentence);
            }
        }
    }

    /**
     * find coincidence in line by pattern
     * @param pattern - pattern
     * @param line - string
     * @return
     */
    private String[] coincidenceWord(Pattern pattern, String line) {
        List<String> matches = new LinkedList<>();
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) // what .
            matches.add(matcher.group(0));
        return matches.toArray(new String[0]);
    }

    private boolean isMathch(String sentence) {
        return !Collections.disjoint(sentenceToWords(sentence), this.targetWords);
    }

    /**
     * split sentence by words, deleted punctuation and convert to lower case
     * @param sentence - sentence
     * @return
     */
    private Set<String> sentenceToWords(String sentence) {
        Set<String> words = new HashSet<>();
        Collections.addAll(words, removePunctuation(sentence.toLowerCase()).split("\\s+"));
        return words;
    }
    /**
     * deleted punctuation from sentence
     * @param sentence
     * @return
     */
    private String removePunctuation(String sentence) {
        return sentence.replaceAll("[^a-zA-Zа-яА-Я\\d\\s]", "");
    }

    @Override
    public void run() {

    }
}
