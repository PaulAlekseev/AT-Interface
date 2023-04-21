package com.example.demo.web.modem.request_handlers.parsers;

import com.example.demo.web.extra.OperatorNumberRegex;
import com.example.demo.web.modem.request_handlers.ATCommandExecutor;
import com.example.demo.web.modem.request_handlers.HexConverter;
import com.example.demo.web.modem.request_handlers.containers.IMSIContainer;
import com.example.demo.web.modem.request_handlers.containers.PhoneNumberContainer;
import com.example.demo.web.modem.request_handlers.objs.IMSI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberParser {
    public static PhoneNumberContainer parsePhoneNumber(String data, ATCommandExecutor executor) {
        if (data == null) return null;
        IMSI imsi = new IMSI();
        IMSIContainer imsiContainer = imsi.getIMSI(executor);
        String regex = OperatorNumberRegex.getRegex(imsiContainer);
        if (regex == null) return null;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        if(matcher.find()) {
            PhoneNumberContainer container = new PhoneNumberContainer();
            container.setPhoneNumber(matcher.group(1));
            return container;
        } else {
            data = HexConverter.convertHexString(data);
            Matcher matcher1 = pattern.matcher(data);
            if (matcher1.find()) {
                PhoneNumberContainer container = new PhoneNumberContainer();
                container.setPhoneNumber(matcher1.group(1));
                return container;
            }
        }
        return null;
    }
}
