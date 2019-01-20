package ru.innopolis.inputoutput.buffer;

import java.util.Random;

/**
 *
 * Class for generation words from char
 * @author Ilya Pribytkov
 * @version 1.0
 */

public class RandomWord {
    /**
     * @param word - return word
     * @param wordLength - length of word
     */
    private String word;
    public String generateRandomWord(int number) {
        Random r  = new Random();
        int wordLength = r.nextInt(number) + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordLength; i++) {
            char tmp = (char) ('a' + r.nextInt('z' - 'a'));
            sb.append(tmp);
        }
        this.word = sb.toString();
        return this.word;
    }
}
