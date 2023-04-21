package com.example.demo.web.socket.starter;

import com.example.demo.web.socket.WebSocketClient;

public interface Starter {
    void onOpen(WebSocketClient client);
    boolean allowedCommand(String command);
}
