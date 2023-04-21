package com.example.demo.web.modem.request_handlers.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ATPhoneNumberParser implements ATParser {

    @Override
    public String parse(String data) {
        String resultRegex = "(\\+CNUM:\\s\".*?\",\"|\\+CUSD:\\s2,\")(.*?)\"";
        Pattern regexResultPattern = Pattern.compile(resultRegex);
        Matcher matcher = regexResultPattern.matcher(data);
        if (matcher.find()) {
            data = matcher.group(2);
        } else {
            return null;
        }
        return data;
    }
}
