package com.example.demo.web.modem.request_handlers.parsers;

public class ATQLEDDisableParser implements ATParser {
    @Override
    public String parse(String data) {
        if (data.contains("OK")) {
            return "OK";
        } else {
            return null;
        }
    }
}
