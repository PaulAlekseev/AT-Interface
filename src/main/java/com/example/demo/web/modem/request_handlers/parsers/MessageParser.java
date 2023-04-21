package com.example.demo.web.modem.request_handlers.parsers;

import com.example.demo.web.modem.request_handlers.HexConverter;
import com.example.demo.web.modem.request_handlers.containers.MessageContainer;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageParser {
    private static final String resultRegex = "\\+CMGL:\\s(\\d+),\"REC\\sREAD\",\"(.*)\",\"\",\".*\"\r\n(.*)\r\n";

    public static ArrayList<MessageContainer> parseMessages(String messages) {
        Pattern resultRegexPattern = Pattern.compile(resultRegex);
        ArrayList<MessageContainer> resultList = new ArrayList<>();
        Matcher matcher = resultRegexPattern.matcher(messages);
        while(matcher.find()) {
            MessageContainer messageContainer = new MessageContainer();
            String sender = HexConverter.convertHexString(matcher.group(2));
            if (sender == null) sender = matcher.group(2);
            String message = HexConverter.convertHexString(matcher.group(3));
            if (message == null) message = matcher.group(3);
            Long index = Long.parseLong(matcher.group(1));
            messageContainer.setIndex(index);
            messageContainer.setSender(sender);
            messageContainer.setMessage(message);
            resultList.add(messageContainer);
        }
        return resultList;
    }
}
