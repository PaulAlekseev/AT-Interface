package com.example.demo.web.socket.tasks.runnable;

import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.modem.states.ModemState;
import com.example.demo.web.socket.WebSocketClient;

import java.util.List;

public class StartSaveModemsTask implements RunnableTask{
    @Override
    public void run(ModemProviderState modemProviderState, String jsonString, WebSocketClient socketClient) {
        try {
            List<ModemState> modems;
            if (modemProviderState.getBusy()) {
                modems = modemProviderState.updateModems();

            }
            else {
                modems = modemProviderState.getInactivePorts()
                        .stream()
                        .map(ModemState::new)
                        .toList();
            }
            modemProviderState.saveNewModems(modems);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
