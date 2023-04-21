package com.example.demo.web.socket.tasks.runnable;

import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.modem.states.ModemState;
import com.example.demo.web.socket.WebSocketClient;
import com.example.demo.web.socket.tasks.containers.in.DisconnectModemsInContainer;
import com.example.demo.web.socket.tasks.containers.out.DisconnectModemsOutContainer;
import com.google.gson.Gson;

import java.util.List;

public class DisconnectModemsTask implements RunnableTask{
    @Override
    public void run(ModemProviderState modemProviderState, String jsonString, WebSocketClient socketClient) {
        Gson gson = new Gson();
        DisconnectModemsInContainer container = gson.fromJson(jsonString, DisconnectModemsInContainer.class);
        List<ModemState> data = container.getData()
                .stream()
                .filter((modem) -> modemProviderState.existsByImsiAndIccid(modem.getIMSI(), modem.getICCID()))
                .toList();

        for (ModemState modem : data) {
            modemProviderState.removeByImsiAndIccid(modem.getIMSI(), modem.getICCID());
        }
        String jsonOut = gson.toJson(DisconnectModemsOutContainer.builder()
                .modems(data)
                .build());

        socketClient.sendMessage("DisconnectModems", jsonOut);

    }
}
