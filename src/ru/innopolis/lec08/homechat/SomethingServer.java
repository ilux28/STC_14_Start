package ru.innopolis.lec08.homechat;

import java.io.*;
import java.net.Socket;

public class SomethingServer extends Thread {
    /**
     *
     */
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    public SomethingServer(String name, Socket socket) throws IOException {
        super(name);
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.start();
    }

    public SomethingServer(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.start();
    }

    @Override
    public void run() {
        String word;
        try {
            while (true) {
                word = in.readLine();
                if (word.equals("quit"))
                    break;
                for (SomethingServer sr : Server.serverList) {
                    sr.send(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void send(String message) {
        try {
            out.write(message + "\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}