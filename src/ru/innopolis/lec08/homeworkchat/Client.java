package ru.innopolis.lec08.homeworkchat;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        try (Socket socket = new Socket("localhost", 3345);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
        DataInputStream ois = new DataInputStream(socket.getInputStream())) {
            System.out.println("Client is connected to socket.");
            System.out.println();
            System.out.println("Client writing channel = oos & reading channel = ois in initialized.");
            while (!socket.isOutputShutdown()) {
                if (br.ready()) {
                    //data is exist - working
                    System.out.println("Client start writing in chanel...");
                    Thread.sleep(1000);
                    String clientCommand = br.readLine();
                    //writing data with console in channel of socket for server
                    oos.writeUTF(clientCommand);
                    oos.flush();
                    System.out.println("Client sent message " + clientCommand + " to server.");
                    Thread.sleep(1000);
                    //waiting that server cen write and response
                    if (clientCommand.equalsIgnoreCase("quit")) {
                        System.out.println("Client kill connections");
                        Thread.sleep(200);
                        if (ois.read() > -1) {
                            System.out.println("Reading... " + ois.readUTF());
                        }
                        break;
                    }
                    System.out.println("Client sent message & start waiting for data from server...");
                    Thread.sleep(2000);

                    if (ois.read() > -1) {
                        System.out.println("Reading..." + ois.readUTF());
                    }
                }
                System.out.println("Closing connection & channels on clientSide - DONE.");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
