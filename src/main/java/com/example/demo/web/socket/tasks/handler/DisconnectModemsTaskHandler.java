package com.example.demo.web.socket.tasks.handler;

import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.socket.WebSocketClient;

public class DisconnectModemsTaskHandler implements TaskHandler {

    @Override
    public boolean checkIfAvailable(ModemProviderState modemProviderState, WebSocketClient socketClient, String taskJson) {
        return true;
    }

    @Override
    public void safeBeforeStart(ModemProviderState modemProviderState, WebSocketClient socketClient, String taskJson) {

    }

    @Override
    public void abort(ModemProviderState modemProviderState, WebSocketClient socketClient, String taskJson) {

    }
}
