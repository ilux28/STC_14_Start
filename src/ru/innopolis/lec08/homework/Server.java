package ru.innopolis.lec08.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 5000; // 1025-65535
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Ждем подключения к серверу");
            Socket socket = serverSocket.accept();
            System.out.println("Подключение состоялось");

            InputStream socketInStr = socket.getInputStream();
            OutputStream socketOutStr = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketInStr);
            DataOutputStream out = new DataOutputStream(socketOutStr);

            String str = null;
            while (true) {
                str = in.readUTF();
                System.out.println("Мы получили следующее сообщение: " + str);
                System.out.println("Отправка обратно");
                out.writeUTF(str);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}