package com.example.demo.web.modem.request_handlers.objs;

import com.example.demo.web.modem.request_handlers.ATCommandExecutor;
import com.example.demo.web.modem.request_handlers.ATRequester;
import com.example.demo.web.modem.request_handlers.containers.PhoneNumberContainer;
import com.example.demo.web.modem.request_handlers.parsers.PhoneNumberParser;
import com.example.demo.web.modem.request_handlers.requestfactory.ATPhoneNumberRequestFactory;

public class PhoneNumber {
    public PhoneNumberContainer getPhoneNumber(ATCommandExecutor executor) {
        ATRequester requester = new ATRequester(new ATPhoneNumberRequestFactory());
        String phoneNumber = requester.makeRequest(executor);
        return PhoneNumberParser.parsePhoneNumber(phoneNumber, executor);
    }
}
