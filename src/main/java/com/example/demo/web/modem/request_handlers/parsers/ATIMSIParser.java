package com.example.demo.web.modem.request_handlers.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ATIMSIParser implements ATParser {
    @Override
    public String parse(String data) {
        Pattern regex = Pattern.compile("(\\d+)");
        Matcher matcher = regex.matcher(data);
        if(matcher.find()){
            return matcher.group(1);
        } else {
            return null;
        }
    }
}
