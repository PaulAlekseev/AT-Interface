package com.example.demo.web.socket.tasks.containers.out;

import com.example.demo.web.modem.states.ModemState;

public class ConnectModemOutContainer {
    private Long taskId;
    private ModemState modem;

    public ConnectModemOutContainer(Long taskId, ModemState modem) {
        this.taskId = taskId;
        this.modem = modem;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public ModemState getModem() {
        return modem;
    }

    public void setModem(ModemState modem) {
        this.modem = modem;
    }
}
