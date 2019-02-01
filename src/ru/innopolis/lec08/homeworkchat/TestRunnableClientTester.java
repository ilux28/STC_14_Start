package ru.innopolis.lec08.homeworkchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestRunnableClientTester implements Runnable {

    static Socket socket;


    public TestRunnableClientTester() {
        try {
            socket = new Socket("localhost", 3345);
            System.out.println("Client connected to socket");
            Thread.sleep(2000);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try (DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
             DataInputStream ois = new DataInputStream(socket.getInputStream())) {
            System.out.println("Client oos and ois initialized");
            int i = 0;
            while (i < 5) {
                oos.writeUTF("clientCommand " + i);
                oos.flush();
                Thread.sleep(10);
                System.out.println("Client wrote and start waiting for from server...");
                System.out.println("Reading...");
                System.out.println(ois.read());
                i++;
                Thread.sleep(5000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}