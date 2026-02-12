package org.example.HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket client = server.accept();

            new Thread(() -> {
                try {
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(client.getInputStream())
                    );

                    PrintWriter out = new PrintWriter(client.getOutputStream());

                    String line;
                    while ((line = in.readLine()) != null && !line.isEmpty()) {
                        System.out.println(line);
                    }

                    String response =
                            "HTTP/1.1 200 OK\r\n" +
                                    "Content-Type: text/html\r\n" +
                                    "\r\n" +
                                    "<h1>Hello from Lambda Runnable!</h1>";

                    out.write(response);
                    out.flush();

                    client.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
