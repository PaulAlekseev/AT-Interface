package com.example.demo.web.modem.request_handlers.requests;

import com.example.demo.web.modem.request_handlers.ATCommandExecutor;
import com.example.demo.web.modem.request_handlers.containers.MessageContainer;
import com.example.demo.web.modem.request_handlers.parsers.MessageParser;

import java.util.List;

public class ATGetAndDeleteSmsRequest implements ATRequest {

    @Override
    public String makeRequest(ATCommandExecutor executor) throws Exception {
        ATMessagesRequest messagesRequest = new ATMessagesRequest();
        String result = messagesRequest.makeRequest(executor);
        List<Long> indexes = MessageParser
                .parseMessages(result)
                .stream().map(MessageContainer::getIndex).toList();

        executor.openPort(115200, 8, 1, 0);
        for (Long index : indexes) {
            String atCommand = String.format("AT+CMGD=%d,0", index);
            executor.executeAtCommand(atCommand, 300);
        }
        executor.readResult();
        executor.closePort();
        return result;
    }
}
