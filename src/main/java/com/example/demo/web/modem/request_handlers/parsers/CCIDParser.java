package com.example.demo.web.modem.request_handlers.parsers;

import com.example.demo.web.modem.request_handlers.containers.CCIDContainer;

public class CCIDParser {
    private static final String CCIDRegex = "(\\d+)";

    public static CCIDContainer parseCCID(String ccid) {
        CCIDContainer container = new CCIDContainer();
        if (ccid == null) return null;
        container.setCCID(ccid);
        return container;
    }
}
