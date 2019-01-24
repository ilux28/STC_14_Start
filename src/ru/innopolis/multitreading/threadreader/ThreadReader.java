package ru.innopolis.multitreading.threadreader;


import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThreadReader {
    String path;
    Set<String> targetWords;

    public ThreadReader(String path, Set<String> targetWords) {
        this.path = path;
        this.targetWords = targetWords;
    }
    private static final String REGEX_NO_END = "[A-ZА-Я][^.?!]*$";
    private static final String REGEX_NO_START = "^[^A-ZА-Я.!?]+[.?!]";
    private static final String REGEX_FULL = "^[A-ZА-Я][^.?!]+[!?.]";
    private String unFinSent = "";

    //private BufferedReader reader;


    Pattern patternNoEnd = Pattern.compile(REGEX_NO_END);
    Pattern patternNoStart = Pattern.compile(REGEX_NO_START);
    Pattern patternFull = Pattern.compile(REGEX_FULL);

    /**
     *
     * @return
     * @throws IOException
     */
    private BufferedReader getResource() throws IOException {
        InputStream is;
        try {
            URL url = new URL(path);
            is = new URL(path).openStream();
        } catch (IOException e) {
            is = new FileInputStream(path);
        }
        return new BufferedReader(new InputStreamReader(is));
    }
    private String ghostSentence(Matcher matcher) {
        return matcher.group(1).
                replaceAll(System.getProperty("line.separator"), " ").
                toLowerCase();
    }
    private boolean searchInSentenceWord(String sentence, String[] words) {

        return false;
    }
    /**
     * This method building store of sentence
     * @throws IOException error of reading
     */
    public List<String> buildSentenceStore() throws IOException {
        //long startTime = System.currentTimeMillis();
        List<String> storeSentence = new LinkedList<>();
        try (BufferedReader r = this.getResource()) {
            //StringBuilder strBuff = null;
            String content;
            while ((content = r.readLine()) != null) {
                Matcher matchNoEnd = patternNoEnd.matcher(content);
                Matcher matchNoStart = patternNoStart.matcher(content);
                Matcher matchFull = patternFull.matcher(content);
                String sentence = "";
                if (matchFull.find()) {
                    for ()
                    ghostSentence(matchFull);
                    if(matchNoEnd.find()) {
                        sentence = ghostSentence(matchNoEnd);
                        if (matchNoStart.find()) {
                            sentence = sentence + ghostSentence(matchNoStart);
                        }
                    } else {
                        if (matchNoStart.find()) {
                            sentence = sentence + ghostSentence(matchNoStart);
                        }
                    }
                } else {
                    if (matchNoStart.find()) {
                        sentence = sentence + ghostSentence(matchNoStart);
                        if (matchNoEnd.find()) {
                            sentence = ghostSentence(matchNoEnd);
                        }
                    } else {
                        if (matchNoEnd.find()) {
                            sentence = ghostSentence(matchNoEnd);
                        }
                    }
                }
            } return storeSentence;
        }
    }

    /**
     * This method added repeat code in buildSentenceStore method
     * @param storeSentence
     * @param matchNoStart
     * @param matchFull
     * @param sentence
     */
    private void addedInList(List<String> storeSentence, Matcher matchNoStart, Matcher matchFull, String sentence) {
        sentence = sentence + " " + matchNoStart.group(1).
                replaceAll(System.getProperty("line.separator"), " ").
                toLowerCase();
        storeSentence.add(sentence.toLowerCase());
        storeSentence.add(matchFull.group(1).
                replaceAll(System.getProperty("line.separator"), " ").
                toLowerCase());
    }
    /**
     * deleted punctuation from sentence
     * @param sentence
     * @return
     */
    private String removePunctuation(String sentence) {
        return sentence.replaceAll("[^a-zA-Zа-яА-Я\\d\\s]", "");
    }
}