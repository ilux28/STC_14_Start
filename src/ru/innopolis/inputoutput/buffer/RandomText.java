package ru.innopolis.inputoutput.buffer;

import java.util.Random;

/**
 * class for generated text from sentence
 * @author Ilya Pribytkov
 * @version 1.0
 */

public class RandomText {
    public String generateRandomText(int num) {
        Random r = new Random();
        int number = r.nextInt(num) + 1;
        StringBuilder txt = new StringBuilder();
        /**
         * this added in @param stc @param number sentences
         */
        for (int i = 0; i < number; i++) {
            RandomSentence stc = new RandomSentence();
            txt.append(stc.generateRandomWords(14)).append("\n");
        }
        return txt.toString();
    }
}
