package com.example.demo.web.socket.tasks.containers.out;

import com.example.demo.web.modem.states.ModemState;

public class ModemBusyOutContainer {
    private long taskId;
    private ModemState modem;

    public ModemBusyOutContainer(long taskId, ModemState modem) {
        this.taskId = taskId;
        this.modem = modem;
    }

    public long getTaskId() {
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
