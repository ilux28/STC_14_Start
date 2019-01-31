package ru.innopolis.inputoutput.buffer;

import com.sun.org.apache.regexp.internal.RE;

import java.io.IOException;
import java.util.regex.Pattern;

public class TestText {
    private static final String REG_EXPRESSION_NOT_FULL_END = "[A-ZА-Я][^.?!]*$";
    private static final String REG_EXPRESSION_NOT_FULL_BEGIN = "^[^A-ZА-Я.!?]+[.?!]";
    private static final String REG_EXPRESSION_FULL = "^[A-ZА-Я][^.?!]+[!?.]";
    public static void main(String[] args) throws IOException {
        Pattern endNotFull = Pattern.compile(REG_EXPRESSION_NOT_FULL_END);
        Pattern beginNotFul = Pattern.compile(REG_EXPRESSION_NOT_FULL_BEGIN);
        Pattern full_exp = Pattern.compile(REG_EXPRESSION_FULL);

        RandomText tx = new RandomText();
        String txt = tx.generateRandomText(20);
        System.out.println(txt);
        String[] arrText = txt.split(".");
        for (String word : arrText)
            System.out.println(word);
        /*
        String[] words = new RandomText().generateRandomText(20).split(" ");
        RecordFile recordFile = new RecordFile();
        recordFile.getFiles("C://Users/Public/Documents/",2, 5, words, 10);
        */
    }
}