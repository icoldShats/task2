package org.example.http;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.logging.Logger;

public class HttpService {

    private final HttpClient client;
    private static final Logger logger = Logger.getLogger(HttpService.class.getName());

    public HttpService(HttpClient client) {
        this.client = client;
    }

    // Метод GET
    public String get(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        logger.info("HTTP Status Code: " + response.statusCode());

        return response.body();
    }
}
