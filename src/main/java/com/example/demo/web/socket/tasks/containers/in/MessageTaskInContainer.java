package com.example.demo.web.socket.tasks.containers.in;

import com.example.demo.web.modem.states.ModemState;

public class MessageTaskInContainer {
    private long taskId;
    private ModemState modem;
    private long timeSeconds;

    public MessageTaskInContainer(int taskId, ModemState modemState, long timeSeconds) {
        this.taskId = taskId;
        this.modem = modemState;
        this.timeSeconds = timeSeconds;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public ModemState getModemState() {
        return modem;
    }

    public void setModemState(ModemState modemState) {
        this.modem = modemState;
    }

    public long getTimeSeconds() {
        return timeSeconds;
    }

    public void setTimeSeconds(long timeSeconds) {
        this.timeSeconds = timeSeconds;
    }
}
