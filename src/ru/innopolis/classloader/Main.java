package ru.innopolis.classloader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите реализацию: ");
        StringBuilder sb = null;
        String str;
        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            if (str != "q") {
                sb.append(str);
            }
        }

    }
}
