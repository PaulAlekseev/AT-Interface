package com.example.demo.web.modem.request_handlers.requestfactory;

import com.example.demo.web.modem.request_handlers.parsers.ATMessagesParser;
import com.example.demo.web.modem.request_handlers.parsers.ATParser;
import com.example.demo.web.modem.request_handlers.requests.ATGetAndDeleteSmsRequest;
import com.example.demo.web.modem.request_handlers.requests.ATRequest;

public class ATGetAndDeleteSmsRequestFactory implements ATRequestFactory {

    @Override
    public ATRequest getATRequest() {
        return new ATGetAndDeleteSmsRequest();
    }

    @Override
    public ATParser getATParser() {
        return new ATMessagesParser();
    }
}
