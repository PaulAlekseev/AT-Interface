package com.example.demo.web.modem.request_handlers.requestfactory;

import com.example.demo.web.modem.request_handlers.parsers.ATFirstMessageParser;
import com.example.demo.web.modem.request_handlers.parsers.ATParser;
import com.example.demo.web.modem.request_handlers.requests.ATFirstMessageRequest;
import com.example.demo.web.modem.request_handlers.requests.ATRequest;

public class ATFirstMessageRequestFactory implements ATRequestFactory {

    @Override
    public ATRequest getATRequest() {
        return new ATFirstMessageRequest();
    }

    @Override
    public ATParser getATParser() {
        return new ATFirstMessageParser();
    }
}
