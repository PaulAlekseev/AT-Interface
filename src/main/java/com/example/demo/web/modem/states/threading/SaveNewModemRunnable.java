package com.example.demo.web.modem.states.threading;

import com.example.demo.web.modem.request_handlers.Modem;
import com.example.demo.web.modem.states.ModemState;

public class SaveNewModemRunnable implements Runnable{
    private Modem modem;
    private ModemState modemState;

    public SaveNewModemRunnable(Modem modem, ModemState modemState) {
        this.modem = modem;
        this.modemState = modemState;
    }

    @Override
    public void run() {
        try {
            if (modem.getSignalQuality() != null) {
                modemState.setPhoneNumber(modem.getPhoneNumber().getPhoneNumber());
                modemState.setIMSI(modem.getIMSI().getIMSICode());
                modemState.setPort(modem.getPort());
                modemState.setICCID(modem.getCCID().getCCID());
            }
        } catch (Exception e) {
            String port = modemState.getPort();
            modemState = new ModemState();
            modemState.setPort(port);
            System.out.println(e.getLocalizedMessage());
        }
    }

    public ModemState getModemState() {
        return modemState;
    }
}
