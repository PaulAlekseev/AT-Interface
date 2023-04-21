package com.example.demo.web.modem.request_handlers.requestfactory;

import com.example.demo.web.modem.request_handlers.parsers.ATParser;
import com.example.demo.web.modem.request_handlers.parsers.ATQLEDEnableParser;
import com.example.demo.web.modem.request_handlers.requests.ATQLEDEnableRequest;
import com.example.demo.web.modem.request_handlers.requests.ATRequest;

public class ATQLEDEnableRequestFactory implements ATRequestFactory {
    @Override
    public ATRequest getATRequest() {
        return new ATQLEDEnableRequest();
    }

    @Override
    public ATParser getATParser() {
        return new ATQLEDEnableParser();
    }
}
