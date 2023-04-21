package com.example.demo.web.modem.request_handlers.objs;

import com.example.demo.web.modem.request_handlers.ATCommandExecutor;
import com.example.demo.web.modem.request_handlers.ATRequester;
import com.example.demo.web.modem.request_handlers.containers.CCIDContainer;
import com.example.demo.web.modem.request_handlers.parsers.CCIDParser;
import com.example.demo.web.modem.request_handlers.requestfactory.ATGetCCIDRequestFactory;

public class CCID {
    public CCIDContainer getCCID(ATCommandExecutor executor) {
        ATRequester requester = new ATRequester(new ATGetCCIDRequestFactory());
        return CCIDParser.parseCCID(requester.makeRequest(executor));
    }
}
