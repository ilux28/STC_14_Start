package ru.innopolis.lec08.homechat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Sender extends Thread {
    /**
     * @param name the name of the new thread
     */
    private BufferedReader in;

    private BufferedWriter out;

    public Sender(String name, BufferedReader in, BufferedWriter out) {
        super(name);
        this.in = in;
        this.out = out;
    }
    /**
     *
     */
    @Override
    public void run() {
        while (true) {
            String messageUser;
            try {
                messageUser = in.readLine();
                if (messageUser.equals("quit")) {
                    out.write("stop");
                    break;
                } else {
                    out.write(messageUser + "\n");
                }
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}