package com.example.demo.web.modem.states.threading;

import com.example.demo.web.modem.request_handlers.Modem;
import com.example.demo.web.modem.states.ModemState;

public class ModemUpdateStateRunnable implements Runnable{
    private Modem modem;
    private ModemState modemState;

    public ModemUpdateStateRunnable(Modem modem, ModemState state) {
        this.modem = modem;
        this.modemState = state;
    }

    @Override
    public void run() {
        modem.switchQLED(false);
        if(modem.getSignalQuality() != null) {
            modemState.setIMSI(modem.getIMSI().getIMSICode());
            modemState.setPort(modem.getPort());
            modemState.setICCID(modem.getCCID().getCCID());
        }
    }

    public ModemState getModemState() {
        return modemState;
    }

    public void setModemState(ModemState modemState) {
        this.modemState = modemState;
    }
}
