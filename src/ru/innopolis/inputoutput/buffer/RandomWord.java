package ru.innopolis.inputoutput.buffer;

import java.util.Random;

/**
 * Класс с методом для генерации случайных слов из букв
 * @author Ilya Pribytkov
 * @
 */
public class RandomWord {
    private String word;
    public String generateRandomWord(int wordLength) {
        Random r  = new Random();
        StringBuilder sb = new StringBuilder(wordLength);
        for (int i = 0; i < wordLength; i++) {
            char tmp = (char) ('a' + r.nextInt('z' - 'a'));
            sb.append(tmp);
        }
        this.word = sb.toString();
        return this.word;
    }
}
