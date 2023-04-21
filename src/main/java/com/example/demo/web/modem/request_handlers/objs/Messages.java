package com.example.demo.web.modem.request_handlers.objs;

import com.example.demo.web.modem.request_handlers.ATCommandExecutor;
import com.example.demo.web.modem.request_handlers.ATRequester;
import com.example.demo.web.modem.request_handlers.containers.MessageContainer;
import com.example.demo.web.modem.request_handlers.parsers.MessageParser;
import com.example.demo.web.modem.request_handlers.requestfactory.ATGetAndDeleteSmsRequestFactory;
import com.example.demo.web.modem.request_handlers.requestfactory.ATMessagesRequestFactory;
import com.example.demo.web.modem.request_handlers.requestfactory.ATRequestFactory;

import java.util.ArrayList;

public class Messages {

    public ArrayList<MessageContainer> getMessages(ATCommandExecutor executor, Boolean delete) {
        ATRequestFactory requestFactory = delete ?
                new ATGetAndDeleteSmsRequestFactory() :
                new ATMessagesRequestFactory();
        ATRequester requester = new ATRequester(requestFactory);
        return MessageParser.parseMessages(requester.makeRequest(executor));
    }
}
