package ru.innopolis.lec08.homeworkchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MonoThreadClientHandler implements Runnable {

    private static Socket clientDialog;

    public MonoThreadClientHandler(Socket client) {
        MonoThreadClientHandler.clientDialog = client;
    }

    @Override
    public void run() {
        try {
            DataOutputStream out = new DataOutputStream(clientDialog.getOutputStream());
            DataInputStream in = new DataInputStream(clientDialog.getInputStream());
            System.out.println("DataInputStream created");
            System.out.println("DataOutputStream created");
            while (!clientDialog.isClosed()) {
                System.out.println("Server reading from channel");
                String entry = in.readUTF();
                System.out.println("Read from clientDialog message - " + entry);
                if (entry.equals("quit")) {
                    System.out.println("Client initialize connection suicide ...");
                    System.out.println("Server reply - " + " - OK");
                    Thread.sleep(3000);
                    break;
                }
                out.writeUTF("Server reply - " + entry + " - OK");
                out.flush();
                System.out.println("Client disconnect");
                in.close();
                out.close();
                clientDialog.close();
                System.out.println("Closing connection and channels - DONE.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}