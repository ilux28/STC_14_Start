package ru.innopolis.lec08.homework;

import java.net.Socket;

public class ReaderThread extends Thread {
    private Socket socket;
    public ReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {


    }
}
