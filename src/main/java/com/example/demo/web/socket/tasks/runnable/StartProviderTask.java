package com.example.demo.web.socket.tasks.runnable;

import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.socket.WebSocketClient;
import com.example.demo.web.socket.tasks.TaskOutKeywords;
import com.google.gson.Gson;

public class StartProviderTask implements RunnableTask {
    @Override
    public void run(ModemProviderState modemProviderState, String jsonString, WebSocketClient socketClient) {
        Gson gson = new Gson();
        while (true) {
            try {
                modemProviderState.updateModems();
                socketClient.sendMessage(TaskOutKeywords.HANDLE_BLANK_MODEMS, gson.toJson(modemProviderState.getModems()));
                break;
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }
}
