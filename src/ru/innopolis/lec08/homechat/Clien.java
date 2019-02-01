package ru.innopolis.lec08.homechat;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Clien {
    private static Socket clientSocket;
    private static BufferedReader consoleReader;
    private static BufferedReader socketReader;
    private static BufferedWriter socketwriter;

    public static void main(String[] args) {

        try {
            clientSocket = new Socket("localhost", 8080);
            consoleReader = new BufferedReader(new InputStreamReader(System.in));
            socketReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            socketwriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                /*
                while () {

                }
                */
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
