package ru.innopolis.lec08.homechat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server {
    public static final int PORT = 8080;
    public static List<SomethingServer> serverList = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        try {
            while(true) {
                Socket socket = server.accept();
                serverList.add(new SomethingServer(socket));
            }
        } finally {
            server.close();
        }
    }
}
