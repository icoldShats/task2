package org.example.http;

import java.io.IOException;
import java.net.http.HttpClient;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpService service = new HttpService(client);

        String result = service.get("https://example.com");
        System.out.println("Response body: " + result);
    }
}
