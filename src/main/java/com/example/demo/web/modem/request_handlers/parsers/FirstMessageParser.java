package com.example.demo.web.modem.request_handlers.parsers;

import com.example.demo.web.modem.request_handlers.HexConverter;
import com.example.demo.web.modem.request_handlers.containers.MessageContainer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstMessageParser {
    private static final String ANSWER_PATTERN = "\\+CMGR:\\s\".*?\",\"(.*?)\".*\r\n(.*)\r\n";

    public static MessageContainer parseMessage(String data) {
        if (data == null) return null;
        Pattern answerPattern = Pattern.compile(ANSWER_PATTERN);
        Matcher matcher = answerPattern.matcher(data);
        if (matcher.find()) {
            MessageContainer messageContainer = new MessageContainer();
            String sender = HexConverter.convertHexString(matcher.group(1));
            if (sender == null) sender = matcher.group(1);
            String message = HexConverter.convertHexString(matcher.group(2));
            if (message == null) message = matcher.group(2);
            messageContainer.setSender(sender);
            messageContainer.setMessage(message);
            return messageContainer;
        }
        return null;
    }
}
