package com.example.demo.web.modem.request_handlers.requestfactory;

import com.example.demo.web.modem.request_handlers.parsers.ATParser;
import com.example.demo.web.modem.request_handlers.requests.ATRequest;

public interface ATRequestFactory {
    ATRequest getATRequest();

    ATParser getATParser();
}
