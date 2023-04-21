package com.example.demo.web.socket;

public class ProviderSocketApplication {
    private final WebSocketClient client;

    public ProviderSocketApplication() {
        client = SocketSingleton.getWebSocketClient();
    }


    public void run() {
        client.start();
    }
}
