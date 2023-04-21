package com.example.demo.web.modem.request_handlers.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ATFirstMessageParser implements ATParser {

    private static final String ANSWER_PATTERN = "\\+CMGR:\\s\".*?\",\"(.*?)\".*\r\n(.*)\r\n";

    @Override
    public String parse(String data) {
        Pattern trueAnswer = Pattern.compile(ANSWER_PATTERN);
        Matcher matcher = trueAnswer.matcher(data);
        if (!matcher.find()) return null;
        return matcher.group(0);
    }
}
