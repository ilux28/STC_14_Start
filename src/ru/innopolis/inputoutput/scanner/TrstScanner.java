package ru.innopolis.inputoutput.scanner;

import java.util.Scanner;

public class TrstScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in;
        if (sc.hasNextInt()) {
            in = sc.nextInt();
            System.out.println(in * 2);
        } else {
            System.out.println("вы ввели не целое число");
        }
    }
}
