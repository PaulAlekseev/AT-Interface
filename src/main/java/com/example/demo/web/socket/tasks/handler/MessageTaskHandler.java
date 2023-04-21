package com.example.demo.web.socket.tasks.handler;

import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.modem.states.ModemState;
import com.example.demo.web.socket.WebSocketClient;
import com.example.demo.web.socket.tasks.TaskOutKeywords;
import com.example.demo.web.socket.tasks.containers.in.MessageTaskInContainer;
import com.example.demo.web.socket.tasks.containers.out.ModemBusyOutContainer;
import com.google.gson.Gson;

public class MessageTaskHandler implements TaskHandler {
    private ModemState modemState;

    private ModemState getModemState(String taskJson, ModemProviderState modemProviderState) {
        if (modemState == null) {
            Gson gson = new Gson();
            MessageTaskInContainer taskContainer = gson.fromJson(taskJson, MessageTaskInContainer.class);
            modemState = modemProviderState.getWithPhoneNumber(taskContainer.getModemState().getPhoneNumber());
        }
        return modemState;
    }
    @Override
    public boolean checkIfAvailable(ModemProviderState modemProviderState, WebSocketClient socketClient, String taskJson) {
        return getModemState(taskJson, modemProviderState) != null;
    }

    @Override
    public void safeBeforeStart(ModemProviderState modemProviderState, WebSocketClient socketClient, String taskJson) {
        modemProviderState.toBusy(getModemState(taskJson, modemProviderState));
    }

    @Override
    public void abort(ModemProviderState modemProviderState, WebSocketClient socketClient, String taskJson) {
        Gson gson = new Gson();
        MessageTaskInContainer taskContainer = gson.fromJson(taskJson, MessageTaskInContainer.class);
        ModemBusyOutContainer busyResult = new ModemBusyOutContainer(
                taskContainer.getTaskId(), taskContainer.getModemState());
        socketClient.sendMessage(TaskOutKeywords.MODEM_BUSY, gson.toJson(busyResult));
    }
}
