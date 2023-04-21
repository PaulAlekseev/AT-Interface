package com.example.demo.web.socket.tasks.handler;

import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.socket.WebSocketClient;

public interface TaskHandler {
    boolean checkIfAvailable(ModemProviderState modemProviderState, WebSocketClient socketClient, String taskJson);

    void safeBeforeStart(ModemProviderState modemProviderState, WebSocketClient socketClient, String taskJson);

    void abort(ModemProviderState modemProviderState, WebSocketClient socketClient, String taskJson);
}
