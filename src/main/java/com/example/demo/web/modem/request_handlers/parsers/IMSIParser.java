package com.example.demo.web.modem.request_handlers.parsers;

import com.example.demo.web.extra.IMSICountryRegex;
import com.example.demo.web.modem.request_handlers.containers.IMSIContainer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IMSIParser {

    private static final String countryNumberRegex = "(\\d{3})(\\d+)";

    public static IMSIContainer parseIMSI(String imsiData) {
        try {
            Pattern countryPattern = Pattern.compile(countryNumberRegex);
            Matcher countryMatcher = countryPattern.matcher(imsiData);
            if (countryMatcher.find()) {
                IMSIContainer container = new IMSIContainer();
                container.setCountryNumber(countryMatcher.group(1));
                Pattern pattern = Pattern.compile(IMSICountryRegex.getRegex(countryMatcher.group(1)));
                Matcher matcher = pattern.matcher(countryMatcher.group(2));
                if (matcher.find()) {
                    container.setProvider(matcher.group(1));
                    container.setIMSICode(imsiData);
                    return container;
                }
            }
            return null;
        }catch (Exception e) {
            return null;
        }

    }
}
