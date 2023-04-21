package com.example.demo.web.modem.request_handlers.requestfactory;

import com.example.demo.web.modem.request_handlers.parsers.ATGetCCIDParser;
import com.example.demo.web.modem.request_handlers.parsers.ATParser;
import com.example.demo.web.modem.request_handlers.requests.ATGetCCIDRequest;
import com.example.demo.web.modem.request_handlers.requests.ATRequest;

public class ATGetCCIDRequestFactory implements ATRequestFactory {

    @Override
    public ATRequest getATRequest() {
        return new ATGetCCIDRequest();
    }

    @Override
    public ATParser getATParser() {
        return new ATGetCCIDParser();
    }
}
