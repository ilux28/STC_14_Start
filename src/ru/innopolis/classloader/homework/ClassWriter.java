package ru.innopolis.classloader.homework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ClassWriter {
    //public String ClassText = "package ru.innopolis.classloader.homework; public class ClassLoaded {public static void main(String[] args) { System.out.println(\"Hello!\");}}";
    public void doWrite() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(("Введите реализацию: "));
        StringBuilder sb = new StringBuilder();
        String line;
        String file = "src/ru/innopolis/classloader/homework/ClassLoaded.java";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {
            while (true) {
                line = scanner.nextLine();
                if (!line.trim().equals("")) {
                    sb.append(line);
                } else {
                    break;
                }
            }
            System.out.println(sb);
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
