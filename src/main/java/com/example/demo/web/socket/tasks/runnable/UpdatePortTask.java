package com.example.demo.web.socket.tasks.runnable;

import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.socket.WebSocketClient;
import com.example.demo.web.socket.tasks.TaskOutKeywords;
import com.example.demo.web.socket.tasks.containers.in.UpdatePortInContainer;
import com.example.demo.web.socket.tasks.containers.out.ConnectModemOutContainer;
import com.google.gson.Gson;

public class UpdatePortTask implements RunnableTask {
    @Override
    public void run(ModemProviderState modemProviderState, String jsonString, WebSocketClient socketClient) {
        Gson gson = new Gson();
        UpdatePortInContainer containerIn = gson
                .fromJson(jsonString, UpdatePortInContainer.class);
        if (containerIn.getModem() == null) {
            modemProviderState.removeModemByPort(containerIn.getPortName());
        }
        modemProviderState.setModemByPortName(containerIn.getPortName(), containerIn.getModem());
        ConnectModemOutContainer outContainer = new ConnectModemOutContainer(containerIn.getTaskId(), containerIn.getModem());
        socketClient.sendMessage(TaskOutKeywords.CONNECT_MODEM, gson.toJson(outContainer));
    }
}
