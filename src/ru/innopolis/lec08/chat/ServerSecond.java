package ru.innopolis.lec08.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSecond {
    static final int PORT = 3232;
    static final int PORT1 = 3234;
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        ServerSocket serverSocket_1 = new ServerSocket(PORT1);
        try (Socket socket = serverSocket.accept()) {
            OutputStream os = socket.getOutputStream();
            InputStream is  = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                os.write(line.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server done");
    }
}