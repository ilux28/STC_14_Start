package ru.innopolis.lec08.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        int serverPort = 5000;
        String interAdres = "127.0.0.1";

        try {
            InetAddress inetAddress = InetAddress.getByName(interAdres);
            System.out.println("Подключаемся к серверу: " + serverPort);
            Socket socket = new Socket(inetAddress, serverPort);

            InputStream socketInStream = socket.getInputStream();
            OutputStream socketOuttStream = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketInStream);
            DataOutputStream out = new DataOutputStream(socketOuttStream);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Введите фразу для передачи на сервер: ");
            String string = null;
            while (true) {
                string = reader.readLine();
                out.writeUTF(string);
                out.flush();
                string = in.readUTF();
                System.out.println("Сервер прислал ответ: " + string);
                System.out.println("Введите фразу для отправки на сервер: ");
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
