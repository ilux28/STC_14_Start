package ru.innopolis.lec08.homechat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Receiver extends Thread {

        public Receiver(String name, BufferedReader in) {
            super(name);
            this.in = in;
    }

    BufferedReader in;
    @Override
    public void run() {
        String str;

        try {
            while(true) {
                str = in.readLine();
                if (str.equals("stop"))
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
