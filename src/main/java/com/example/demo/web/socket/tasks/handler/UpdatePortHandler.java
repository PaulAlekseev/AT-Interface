package com.example.demo.web.socket.tasks.handler;

import com.google.gson.Gson;
import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.socket.WebSocketClient;
import com.example.demo.web.socket.tasks.containers.in.UpdatePortInContainer;

public class UpdatePortHandler implements TaskHandler {

    @Override
    public boolean checkIfAvailable(ModemProviderState modemProviderState, WebSocketClient socketClient, String taskJson) {
        return true;
    }

    @Override
    public void safeBeforeStart(ModemProviderState modemProviderState, WebSocketClient socketClient, String taskJson) {
        Gson gson = new Gson();
        UpdatePortInContainer container = gson.fromJson(taskJson, UpdatePortInContainer.class);
        if (container.getModem() != null) {
            modemProviderState.toBusy(modemProviderState.getByPortName(container.getPortName()));
            System.out.println(modemProviderState.getBusyModems());
        }
    }

    @Override
    public void abort(ModemProviderState modemProviderState, WebSocketClient socketClient, String taskJson) {

    }
}
