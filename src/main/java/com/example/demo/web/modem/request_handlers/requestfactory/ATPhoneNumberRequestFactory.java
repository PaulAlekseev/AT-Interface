package com.example.demo.web.modem.request_handlers.requestfactory;

import com.example.demo.web.modem.request_handlers.ATRequester;
import com.example.demo.web.modem.request_handlers.parsers.ATParser;
import com.example.demo.web.modem.request_handlers.parsers.ATPhoneNumberParser;
import com.example.demo.web.modem.request_handlers.requests.ATPhoneNumberRequest;
import com.example.demo.web.modem.request_handlers.requests.ATRequest;

public class ATPhoneNumberRequestFactory implements ATRequestFactory {
    @Override
    public ATRequest getATRequest() {
        return new ATPhoneNumberRequest();
    }

    @Override
    public ATParser getATParser() {
        return new ATPhoneNumberParser();
    }
}
