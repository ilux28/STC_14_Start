package ru.innopolis.inputoutput.buffer;

import java.util.Random;

/**
 * Class generation the set of words
 * @uthor Ilya Pribytkov
 * version 1.0
 */
public class RandomWords {
    private String words;
    public String generateRandomWords(int num) {
        Random r = new Random();
        int wordsLength = r.nextInt(num);
        RandomWord word = new RandomWord();
        StringBuilder sbs = new StringBuilder();
        for (int i = 0; i < wordsLength; i++) {
            if (i == 0) {
                String str = (word.generateRandomWord(new Random().nextInt(14) + 1));
                sbs.append(str.substring(0, 1).toUpperCase()).append(str.substring(1));
            } else if (i == wordsLength - 1) {
                sbs.append(word.generateRandomWord(new Random().nextInt(14) + 1));
            } else {
                sbs.append(word.generateRandomWord(new Random().nextInt(14) + 1)).append(" ");
            }
        }
        this.words = sbs.toString();
        return this.words;
    }
}
