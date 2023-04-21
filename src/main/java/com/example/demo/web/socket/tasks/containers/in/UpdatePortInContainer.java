package com.example.demo.web.socket.tasks.containers.in;


import com.example.demo.web.modem.states.ModemState;

public class UpdatePortInContainer {
    private Long taskId;
    private ModemState modem;
    private String portName;

    public UpdatePortInContainer(Long taskId, ModemState modem, String portName) {
        this.taskId = taskId;
        this.modem = modem;
        this.portName = portName;
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

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }
}
