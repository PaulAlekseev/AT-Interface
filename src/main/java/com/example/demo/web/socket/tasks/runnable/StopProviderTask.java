package com.example.demo.web.socket.tasks.runnable;

import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.socket.WebSocketClient;

public class StopProviderTask implements RunnableTask{
    @Override
    public void run(ModemProviderState modemProviderState, String jsonString, WebSocketClient socketClient) {
        modemProviderState.setBusy(true);
    }
}
