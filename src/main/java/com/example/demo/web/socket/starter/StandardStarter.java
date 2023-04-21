package com.example.demo.web.socket.starter;

import com.google.gson.Gson;
import com.example.demo.web.socket.WebSocketClient;
import com.example.demo.web.socket.tasks.TaskOutKeywords;

public class StandardStarter implements Starter{

    @Override
    public void onOpen(WebSocketClient client) {
        Gson gson = new Gson();
        client.sendMessage(TaskOutKeywords.HANDLE_BLANK_MODEMS, gson.toJson(client.getModemProviderState().getModems()));
    }

    @Override
    public boolean allowedCommand(String command) {
        return true;
    }
}
