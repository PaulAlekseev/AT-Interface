package com.example.demo.web.modem.request_handlers.objs;

import com.example.demo.web.modem.request_handlers.ATCommandExecutor;
import com.example.demo.web.modem.request_handlers.ATRequester;
import com.example.demo.web.modem.request_handlers.containers.IMSIContainer;
import com.example.demo.web.modem.request_handlers.parsers.IMSIParser;
import com.example.demo.web.modem.request_handlers.requestfactory.ATIMSIRequestFactory;

public class IMSI {

    public IMSIContainer getIMSI(ATCommandExecutor executor) {
        ATRequester requester = new ATRequester(new ATIMSIRequestFactory());
        return IMSIParser.parseIMSI(requester.makeRequest(executor));
    }
}
