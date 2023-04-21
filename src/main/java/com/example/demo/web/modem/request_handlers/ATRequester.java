package com.example.demo.web.modem.request_handlers;


import com.example.demo.web.modem.request_handlers.requestfactory.ATRequestFactory;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ATRequester {
    ATRequestFactory requestFactory;

    public String makeRequest(ATCommandExecutor executor) {
        String commandResult;
        try {
            commandResult = requestFactory.getATRequest().makeRequest(executor);
        } catch (Exception exception) {
            return null;
        }
        if (commandResult == null) {
            return null;
        }
        return requestFactory.getATParser().parse(commandResult);
    }

}
