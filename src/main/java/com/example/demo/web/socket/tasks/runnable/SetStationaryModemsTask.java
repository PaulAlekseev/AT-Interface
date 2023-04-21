package com.example.demo.web.socket.tasks.runnable;

import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.modem.states.ModemState;
import com.example.demo.web.socket.WebSocketClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class SetStationaryModemsTask implements RunnableTask{
    @Override
    public void run(ModemProviderState modemProviderState, String jsonString, WebSocketClient socketClient) {
        Gson gson = new Gson();
        Type token = new TypeToken<ArrayList<ModemState>>(){}.getType();
        ArrayList<ModemState> list = gson.fromJson(jsonString, token);
        HashMap<String, ModemState> newModemStates = new HashMap<>();
        for (ModemState modemState : list) {
            newModemStates.put(modemState.getIMSI(), modemState);
        }
        ArrayList<ModemState> result = new ArrayList<>();
        for (ModemState modem : modemProviderState.getModems()) {
            ModemState modemState = newModemStates.get(modem.getIMSI());
            if (modemState == null) continue;
            modemState.setPort(modem.getPort());
            result.add(modemState);
        }
        modemProviderState.setModems(result);
        modemProviderState.setNotBusy();
        modemProviderState.setBusyOnTask(false);
    }
}
