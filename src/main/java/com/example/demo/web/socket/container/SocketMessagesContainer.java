package com.example.demo.web.socket.container;

import com.example.demo.web.modem.request_handlers.containers.MessageContainer;

import java.util.ArrayList;

public class SocketMessagesContainer {

    private final int taskId;
    private final ArrayList<MessageContainer> messages;

    public SocketMessagesContainer(int taskId, ArrayList<MessageContainer> messages) {
        this.taskId = taskId;
        this.messages = messages;
    }
}
