package org.example.http;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class HttpServiceTest {

    private HttpClient mockClient;
    private HttpResponse<String> mockResponse;
    private HttpService service;

    @BeforeEach
    void setUp() {
        mockClient = mock(HttpClient.class);
        mockResponse = mock(HttpResponse.class);
        service = new HttpService(mockClient);
    }

    @Test
    void testGet_returnsResponseBody() throws IOException, InterruptedException {
        when(mockResponse.statusCode()).thenReturn(200);
        when(mockResponse.body()).thenReturn("Hello World");

        when(mockClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(mockResponse);

        String result = service.get("https://example.com");

        assertEquals("Hello World", result);

        verify(mockClient).send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class));
    }
}
