package com.example.demo.web.socket.tasks.containers.out;

import com.example.demo.web.modem.states.ModemState;

public class ModemCheckOutContainer {
    private final int taskId;
    private final int signalQuality;
    private final String portName;
    private final ModemState modem;

    public ModemCheckOutContainer(int taskId, int signalQuality, ModemState modemState, String portName) {
        this.portName = portName;
        this.taskId = taskId;
        this.signalQuality = signalQuality;
        this.modem = modemState;
    }
}
