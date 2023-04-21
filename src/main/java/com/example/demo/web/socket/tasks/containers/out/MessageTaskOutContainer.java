package com.example.demo.web.socket.tasks.containers.out;

import com.example.demo.web.modem.request_handlers.containers.MessageContainer;

import java.util.ArrayList;

public class MessageTaskOutContainer {
    private final long taskId;
    private ArrayList<MessageContainer> messages;

    public MessageTaskOutContainer(long taskId) {
        this.taskId = taskId;
    }

    public long getTaskId() {
        return taskId;
    }

    public ArrayList<MessageContainer> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<MessageContainer> messages) {
        this.messages = messages;
    }
}
