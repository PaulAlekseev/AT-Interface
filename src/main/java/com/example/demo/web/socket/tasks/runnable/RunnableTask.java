package com.example.demo.web.socket.tasks.runnable;

import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.socket.WebSocketClient;

import java.lang.reflect.Type;

public interface RunnableTask {
    void run (ModemProviderState modemProviderState, String jsonString, WebSocketClient socketClient);
}
