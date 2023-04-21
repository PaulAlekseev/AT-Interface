package com.example.demo.web.modem.request_handlers.objs;

import com.example.demo.web.modem.request_handlers.ATCommandExecutor;
import com.example.demo.web.modem.request_handlers.ATRequester;
import com.example.demo.web.modem.request_handlers.containers.MessageContainer;
import com.example.demo.web.modem.request_handlers.parsers.FirstMessageParser;
import com.example.demo.web.modem.request_handlers.requestfactory.ATFirstMessageRequestFactory;

public class FirstMessage {

    public MessageContainer getFirstMessage(ATCommandExecutor executor) {
        ATRequester requester = new ATRequester(new ATFirstMessageRequestFactory());
        return FirstMessageParser.parseMessage(requester.makeRequest(executor));
    }
}
