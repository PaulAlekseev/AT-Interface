package com.example.demo.web.socket.tasks.containers.in;

import com.example.demo.web.modem.states.ModemState;

public class UpdateModemInContainer {
    private Long taskId;
    private String portName;
    private ModemState modem;

    public UpdateModemInContainer(Long taskId, String portName, ModemState modem) {
        this.taskId = taskId;
        this.portName = portName;
        this.modem = modem;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public ModemState getModem() {
        return modem;
    }

    public void setModem(ModemState modem) {
        this.modem = modem;
    }
}
