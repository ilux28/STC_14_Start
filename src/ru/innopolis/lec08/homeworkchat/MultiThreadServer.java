package ru.innopolis.lec08.homeworkchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer {
    static ExecutorService executeItem = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(3345);
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Server socket created, command console reader for listen to server commands");
            while (!server.isClosed()) {
                if (br.ready()) {
                    System.out.println("Main Server found anny message in channel, let's  look at them.");
                    String serverCommand = br.readLine();
                    if (serverCommand.equals("quit")) {
                        System.out.println("Main Server initiate existing...");
                        server.close();
                        break;
                    }
                }
                Socket client = server.accept();
                executeItem.execute(new MonoThreadClientHandler(client));
                System.out.println("Connection accepted.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
