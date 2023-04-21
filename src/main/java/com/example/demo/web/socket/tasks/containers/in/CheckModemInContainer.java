package com.example.demo.web.socket.tasks.containers.in;

import com.example.demo.web.modem.states.ModemState;

public class CheckModemInContainer {
    private int taskId;
    private ModemState modem;

    public CheckModemInContainer(int taskId, ModemState modemState) {
        this.taskId = taskId;
        this.modem = modemState;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public ModemState getModem() {
        return modem;
    }

    public void setModem(ModemState modem) {
        this.modem = modem;
    }
}
