package com.example.demo.web.modem.request_handlers.objs;

import com.example.demo.web.modem.request_handlers.ATCommandExecutor;
import com.example.demo.web.modem.request_handlers.ATRequester;
import com.example.demo.web.modem.request_handlers.containers.SignalQualityContainer;
import com.example.demo.web.modem.request_handlers.requestfactory.ATSignalQualityRequestFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignalQuality {
    public SignalQualityContainer getSignalQuality(ATCommandExecutor executor) {
        ATRequester requester = new ATRequester(new ATSignalQualityRequestFactory());
        try {
            String regex = "(\\d+),";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(requester.makeRequest(executor));
            if (matcher.find()) {
                int result = Integer.parseInt(matcher.group(1));
                SignalQualityContainer signalQualityContainer = new SignalQualityContainer();
                signalQualityContainer.setSignalQuality(result);
                return signalQualityContainer;
            }
            return null;
        } catch (Exception exc) {
            return null;
        }
    }
}
