package ru.innopolis.inputoutput.buffer;

import java.util.Random;
/**
 * Class for generation the sentence from words
 * @author Ilya Pribytkov
 * version 1.0
 */
public class RandomSentence {
    private String words;
    public String generateRandomWords(int num) {
        Random r = new Random();
        int wordsLength = r.nextInt(num) + 1;
        RandomWord word = new RandomWord();
        StringBuilder sbs = new StringBuilder();
        for (int i = 0; i < wordsLength; i++) {
            String str = word.generateRandomWord(15);
            if (i == 0) {
                sbs.append(str.substring(0, 1).toUpperCase()).append(str.substring(1));
            } else if (i == wordsLength - 1) {
                int k = r.nextInt(1000) % 3; //make forgot
                if (k == 0) {
                    sbs.append(str).append(".");
                } else if (k == 1) {
                    sbs.append(str).append("!");
                } else {
                    sbs.append(str).append("?");
                }
            } else {
                sbs.append(str).append(" ");
            }
        }
        this.words = sbs.toString();
        return this.words;
    }
}