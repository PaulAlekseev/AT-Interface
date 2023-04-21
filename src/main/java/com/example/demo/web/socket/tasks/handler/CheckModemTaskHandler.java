package com.example.demo.web.socket.tasks.handler;

import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.modem.states.ModemState;
import com.example.demo.web.socket.WebSocketClient;
import com.example.demo.web.socket.tasks.TaskOutKeywords;
import com.example.demo.web.socket.tasks.containers.in.CheckModemInContainer;
import com.example.demo.web.socket.tasks.containers.out.ModemBusyOutContainer;
import com.google.gson.Gson;

import java.util.List;
import java.util.Objects;

public class CheckModemTaskHandler implements TaskHandler {

    private ModemState modemState;
    private CheckModemInContainer taskContainer;

    private ModemState getModemState(ModemProviderState modemProviderState, String taskJson) {
        if (modemState == null) {
            modemState = modemProviderState.getWithPhoneNumber(getTaskContainer(taskJson).getModem().getPhoneNumber());
        }
        return modemState;
    }

    private CheckModemInContainer getTaskContainer(String taskJson) {
        if (taskContainer == null) {
            Gson gson = new Gson();
            taskContainer = gson.fromJson(taskJson, CheckModemInContainer.class);
        }
        return taskContainer;
    }

    @Override
    public boolean checkIfAvailable(ModemProviderState modemProviderState, WebSocketClient socketClient, String taskJson) {
        List<String> busyModems = modemProviderState.getBusyModems().stream().map(ModemState::getPhoneNumber).toList();
        for (String phoneNumber : busyModems) {
            if (Objects.equals(phoneNumber, getTaskContainer(taskJson).getModem().getPhoneNumber())) {
                return false;
            }
        }
        return getModemState(modemProviderState, taskJson) != null;
    }

    @Override
    public void safeBeforeStart(ModemProviderState modemProviderState, WebSocketClient socketClient, String taskJson) {
        modemProviderState.toBusy(getModemState(modemProviderState, taskJson));
    }

    @Override
    public void abort(ModemProviderState modemProviderState, WebSocketClient socketClient, String taskJson) {
        Gson gson = new Gson();
        ModemBusyOutContainer container = new ModemBusyOutContainer(getTaskContainer(taskJson).getTaskId(), getModemState(modemProviderState, taskJson));
        socketClient.sendMessage(TaskOutKeywords.MODEM_BUSY, gson.toJson(container));
    }
}
