package com.example.demo.web.modem.request_handlers.requestfactory;

import com.example.demo.web.modem.request_handlers.parsers.ATParser;
import com.example.demo.web.modem.request_handlers.parsers.ATQLEDDisableParser;
import com.example.demo.web.modem.request_handlers.requests.ATQLEDDisableRequest;
import com.example.demo.web.modem.request_handlers.requests.ATRequest;

public class ATQLEDDisableRequestFactory implements ATRequestFactory {
    @Override
    public ATRequest getATRequest() {
        return new ATQLEDDisableRequest();
    }

    @Override
    public ATParser getATParser() {
        return new ATQLEDDisableParser();
    }
}
