package com.example.demo.runnable;

import com.example.demo.web.modem.request_handlers.Modem;
import com.example.demo.web.socket.SocketSingleton;

public class TurnQledRunnable implements Runnable{

    private Modem modem;
    private boolean mode;

    public TurnQledRunnable(String port, boolean mode) {
        this.modem = new Modem(port);
        this.mode = mode;
    }

    @Override
    public void run() {
        if (SocketSingleton.getWebSocketClient().getModemProviderState().portIsInactive(modem.getPort())) {
            modem.switchQLED(mode);
        }
    }
}
