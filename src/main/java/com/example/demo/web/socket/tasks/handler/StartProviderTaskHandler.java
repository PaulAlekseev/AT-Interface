package com.example.demo.web.socket.tasks.handler;

import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.socket.WebSocketClient;

public class StartProviderTaskHandler implements TaskHandler {
    @Override
    public boolean checkIfAvailable(ModemProviderState modemProviderState, WebSocketClient socketClient, String taskJson) {
        return !modemProviderState.getBusyOnTask();
    }

    @Override
    public void safeBeforeStart(ModemProviderState modemProviderState, WebSocketClient socketClient, String taskJson) {
        modemProviderState.setBusy();
    }

    @Override
    public void abort(ModemProviderState modemProviderState, WebSocketClient socketClient, String taskJson) {

    }
}
