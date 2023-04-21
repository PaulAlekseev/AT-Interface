package com.example.demo.web.socket.tasks.runnable;

import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.socket.WebSocketClient;
import com.example.demo.web.socket.tasks.TaskOutKeywords;
import com.google.gson.Gson;

public class UpdateProviderTask implements RunnableTask {
    @Override
    public void run(ModemProviderState modemProviderState, String jsonString, WebSocketClient socketClient) {
        Gson gson = new Gson();
        modemProviderState.updateModems();
        socketClient.sendMessage(
                TaskOutKeywords.HANDLE_BLANK_MODEMS,
                gson.toJson(modemProviderState.getModems())
        );
    }
}
