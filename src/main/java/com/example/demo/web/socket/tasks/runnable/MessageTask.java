package com.example.demo.web.socket.tasks.runnable;

import com.example.demo.web.modem.request_handlers.Modem;
import com.example.demo.web.modem.request_handlers.containers.MessageContainer;
import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.modem.states.ModemState;
import com.example.demo.web.socket.WebSocketClient;
import com.example.demo.web.socket.tasks.TaskOutKeywords;
import com.example.demo.web.socket.tasks.containers.in.MessageTaskInContainer;
import com.example.demo.web.socket.tasks.containers.out.MessageTaskOutContainer;
import com.example.demo.web.socket.tasks.containers.out.TaskDoneOutContainer;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MessageTask implements RunnableTask{
    @Override
    public void run(ModemProviderState modemProviderState, String jsonString, WebSocketClient socketClient) {
        Gson gson = new Gson();
        MessageTaskInContainer containerIn = gson.fromJson(jsonString, MessageTaskInContainer.class);
        ModemState modemState = modemProviderState.getWithPhoneNumber(containerIn.getModemState().getPhoneNumber());
        Modem modem = new Modem(modemState.getPort());
        modem.deleteAllSMS();
        for (long stop = System.nanoTime() + TimeUnit.SECONDS.toNanos(containerIn.getTimeSeconds()); stop > System.nanoTime(); ) {
            ArrayList<MessageContainer> messageContainer = modem.getMessages(true);
            if (messageContainer.isEmpty()) {
                continue;
            }
            MessageTaskOutContainer messageOut = new MessageTaskOutContainer(containerIn.getTaskId());
            messageOut.setMessages(messageContainer);
            String jsonContainer = gson.toJson(messageOut);
            socketClient.sendMessage(TaskOutKeywords.MESSAGE_SENT, jsonContainer);
        }
        modemProviderState.fromBusy(modemState);
        socketClient.sendMessage(TaskOutKeywords.SET_TASK_DONE, gson.toJson(new TaskDoneOutContainer(containerIn.getTaskId())));
        socketClient.sendMessage(TaskOutKeywords.SET_MODEM_READY, gson.toJson(modemState));
    }
}
