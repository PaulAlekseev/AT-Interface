package com.example.demo.web.modem.request_handlers.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ATGetCCIDParser implements ATParser {
    @Override
    public String parse(String data) {
        String resultRegex = "\\+CCID:\\s\"(\\d\\w+)\"";
        Pattern pattern = Pattern.compile(resultRegex);
        Matcher matcher = pattern.matcher(data);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null;
        }
    }
}
