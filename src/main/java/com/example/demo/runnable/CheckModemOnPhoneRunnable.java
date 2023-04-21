package com.example.demo.runnable;

import com.example.demo.web.extra.ATPhoneNumberRequestMethod;
import com.example.demo.web.extra.DecidePhoneNumberMethod;
import com.example.demo.web.modem.request_handlers.Modem;
import com.example.demo.web.modem.request_handlers.containers.CCIDContainer;
import com.example.demo.web.modem.request_handlers.containers.IMSIContainer;
import com.example.demo.web.modem.request_handlers.containers.PhoneNumberContainer;
import com.example.demo.web.modem.request_handlers.objs.PhoneNumber;
import com.example.demo.web.modem.states.ModemState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class CheckModemOnPhoneRunnable implements Runnable{

    @Getter
    private PhoneNumberContainer phoneNumber;

    @Getter
    private String port;

    @Getter
    private String iccid;

    @Getter
    private boolean needAssign = false;

    public CheckModemOnPhoneRunnable(String port) {
        this.port = port;
    }

    @Override
    public void run() {
        Modem modem = new Modem(port);
        IMSIContainer imsiContainer = modem.getIMSI();
        CCIDContainer ccidContainer = modem.getCCID();
        if (imsiContainer == null || ccidContainer == null) return;
        if (DecidePhoneNumberMethod.decideMethod(imsiContainer) != ATPhoneNumberRequestMethod.AT_CNUM) return;
        if (modem.getPhoneNumber() == null) needAssign = true;
    }
}
