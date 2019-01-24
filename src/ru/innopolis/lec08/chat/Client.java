package ru.innopolis.lec08.chat;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("127.0.0.1", Server.PORT)) {
            OutputStream os = socket.getOutputStream();
            os.write("Hello Server\n".getBytes() );
            InputStream is = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if ("quit".equals(line))
                    break;
                os.write((line + "\n").getBytes());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Client done");
    }
}
