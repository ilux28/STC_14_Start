package ru.innopolis.lec08.homework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ListenerThread extends Thread {
    public static final int PORT =3232;
    private final ServerSocket serverSocket;
    private final Map<Socket, String> socketUserName;

    public ListenerThread(ServerSocket socket, Map<Socket, String> socketUserName) throws IOException {

        this.serverSocket = socket;
        this.socketUserName = new ConcurrentHashMap<>();
    }

    @Override
    public void run() {
        while (isInterrupted()) {
            try {
                Socket socket = serverSocket.accept();
                //socketUserName =
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /*
        try () {

        }
        */
    }
}
