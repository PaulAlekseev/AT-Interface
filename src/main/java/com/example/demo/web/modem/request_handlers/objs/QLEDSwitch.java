package com.example.demo.web.modem.request_handlers.objs;

import com.example.demo.web.modem.request_handlers.ATCommandExecutor;
import com.example.demo.web.modem.request_handlers.ATRequester;
import com.example.demo.web.modem.request_handlers.requestfactory.ATQLEDDisableRequestFactory;
import com.example.demo.web.modem.request_handlers.requestfactory.ATQLEDEnableRequestFactory;
import com.example.demo.web.modem.request_handlers.requestfactory.ATRequestFactory;

import java.util.Objects;

public class QLEDSwitch {

    public boolean setQLED(boolean status, ATCommandExecutor executor) {
        ATRequestFactory factory;
        if (status) {
            factory = new ATQLEDEnableRequestFactory();
        } else {
            factory = new ATQLEDDisableRequestFactory();
        }
        ATRequester requester = new ATRequester(factory);
        return Objects.equals(requester.makeRequest(executor), "OK");
    }
}
