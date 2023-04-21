package com.example.demo.web.modem.request_handlers.requestfactory;

import com.example.demo.web.modem.request_handlers.parsers.ATParser;
import com.example.demo.web.modem.request_handlers.parsers.ATSignalQualityParser;
import com.example.demo.web.modem.request_handlers.requests.ATRequest;
import com.example.demo.web.modem.request_handlers.requests.ATSignalQualityRequest;

public class ATSignalQualityRequestFactory implements ATRequestFactory {
    @Override
    public ATRequest getATRequest() {
        return new ATSignalQualityRequest();
    }

    @Override
    public ATParser getATParser() {
        return new ATSignalQualityParser();
    }
}
