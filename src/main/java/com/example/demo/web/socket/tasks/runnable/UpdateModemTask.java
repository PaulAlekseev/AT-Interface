package com.example.demo.web.socket.tasks.runnable;

import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.modem.states.ModemState;
import com.example.demo.web.socket.WebSocketClient;
import com.example.demo.web.socket.tasks.TaskOutKeywords;
import com.example.demo.web.socket.tasks.containers.in.UpdateModemInContainer;
import com.example.demo.web.socket.tasks.containers.out.ConnectModemOutContainer;
import com.google.gson.Gson;

public class UpdateModemTask implements RunnableTask{
    @Override
    public void run(ModemProviderState modemProviderState, String jsonString, WebSocketClient socketClient) {
        Gson gson = new Gson();
        UpdateModemInContainer container = gson.fromJson(jsonString, UpdateModemInContainer.class);
        modemProviderState.setModemByPortName(container.getPortName(), container.getModem());
        if (container.getModem() == null) return;
        ModemState modem = modemProviderState.getByPortName(container.getPortName());
        ConnectModemOutContainer outContainer = new ConnectModemOutContainer(container.getTaskId(), modem);
        socketClient.
                sendMessage(
                        TaskOutKeywords.CONNECT_MODEM,
                        gson.toJson(outContainer));
    }
}
