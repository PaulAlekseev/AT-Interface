package com.example.demo.web.modem.request_handlers.objs;

import com.example.demo.web.modem.request_handlers.ATCommandExecutor;
import com.example.demo.web.modem.request_handlers.ATRequester;
import com.example.demo.web.modem.request_handlers.requestfactory.ATDeleteAllSMSRequestFactory;

public class DeleteAllSms {

    public Boolean deleteAllSms(ATCommandExecutor executor) {
        ATRequester requester = new ATRequester(new ATDeleteAllSMSRequestFactory());
        return requester.makeRequest(executor) != null;
    }
}
