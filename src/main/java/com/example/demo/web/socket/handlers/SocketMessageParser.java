package com.example.demo.web.socket.handlers;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SocketMessageParser {
    
    private final String regex = "^(\\w+):([\\{|\\[].*[\\]|\\}])";

    public SocketMessageContainer parseMessage(String message) throws ParseException {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(message);
        if (matcher.find()) {
            SocketMessageContainer container = new SocketMessageContainer(matcher.group(1), matcher.group(2));
            return container;
        }
        throw new ParseException("Could not parse task " + message, 0);
    }
}
