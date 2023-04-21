package com.example.demo.web.socket.tasks.runnable;

import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.modem.states.ModemState;
import com.example.demo.web.socket.WebSocketClient;
import com.example.demo.web.socket.tasks.TaskOutKeywords;
import com.google.gson.Gson;
import jssc.SerialPortList;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddModemTask implements RunnableTask{

    @Override
    public void run(ModemProviderState modemProviderState, String jsonString, WebSocketClient socketClient) {
        Gson gson = new Gson();
        List<String> currentPorts = modemProviderState.getAllModems()
                .stream()
                .map(ModemState::getPort)
                .toList();
        List<String> listOfNewPorts = new ArrayList<>(Arrays.stream(SerialPortList.getPortNames())
                .filter(entity -> !currentPorts.contains(entity))
                .toList());
        List<ModemState> modems = modemProviderState.updateModems(new ArrayList<>(listOfNewPorts))
                .stream()
                .filter(entity -> listOfNewPorts.contains(entity.getPort()))
                .toList();

        socketClient.sendMessage(TaskOutKeywords.ADD_MODEMS, gson.toJson(modems));
    }
}
