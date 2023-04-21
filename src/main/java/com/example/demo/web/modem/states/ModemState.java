package com.example.demo.web.modem.states;

import com.example.demo.web.modem.request_handlers.Modem;
import com.example.demo.web.modem.states.threading.ModemUpdateStateRunnable;

public class ModemState {
    private String IMSI;
    private String phoneNumber;
    private String port;
    private String ICCID;


    public ModemState(String port) {
        this.port = port;
    }

    public ModemState() {
//        this.port = port;
    }
    public Thread updateState() {
        Modem modem = new Modem(port);
        ModemUpdateStateRunnable runnable = new ModemUpdateStateRunnable(modem, this);
        Thread thread = new Thread(runnable);
        thread.start();
        return thread;
    }

    public boolean isValid() {
        return this.IMSI != null;
    }

    public String getIMSI() {
        return IMSI;
    }

    public void setIMSI(String IMSI) {
        this.IMSI = IMSI;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getICCID() {
        return ICCID;
    }

    public void setICCID(String ICCID) {
        this.ICCID = ICCID;
    }
}
