package com.example.demo.web.socket;

public class SocketSingleton {
    private static final String server_url = "server_url";
    private static WebSocketClient webSocketClient;

    private SocketSingleton(WebSocketClient socketClient) {
        webSocketClient = socketClient;
    }

    public static WebSocketClient getWebSocketClient() {
        if (webSocketClient == null) {
            webSocketClient = new WebSocketClient(server_url);
        }
        return webSocketClient;
    }
}
