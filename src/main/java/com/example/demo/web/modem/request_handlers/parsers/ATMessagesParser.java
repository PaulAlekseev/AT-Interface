package com.example.demo.web.modem.request_handlers.parsers;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ATMessagesParser implements ATParser {

    private static final String ANSWER_PATTERN = "\\+CMGL:\\s.*\r\n(.*)\r\n";
    @Override
    public String parse(String data) {
        Pattern resultRegexPattern = Pattern.compile(ANSWER_PATTERN);
        Matcher matcher = resultRegexPattern.matcher(data);
        ArrayList<String> resultList = new ArrayList<>();
        while(matcher.find()) {
            resultList.add(matcher.group(0));
        }
        return resultList.toString();
    }
}
