package com.example.demo.web.modem.request_handlers.requestfactory;

import com.example.demo.web.modem.request_handlers.parsers.ATDeleteAllSMSParser;
import com.example.demo.web.modem.request_handlers.parsers.ATParser;
import com.example.demo.web.modem.request_handlers.requests.ATDeleteAllSMSRequest;
import com.example.demo.web.modem.request_handlers.requests.ATRequest;

public class ATDeleteAllSMSRequestFactory implements ATRequestFactory {

    @Override
    public ATRequest getATRequest() {
        return new ATDeleteAllSMSRequest();
    }

    @Override
    public ATParser getATParser() {
        return new ATDeleteAllSMSParser();
    }
}
