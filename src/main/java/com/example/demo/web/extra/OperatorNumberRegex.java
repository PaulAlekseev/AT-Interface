package com.example.demo.web.extra;

import com.example.demo.web.modem.request_handlers.containers.IMSIContainer;

public class OperatorNumberRegex {
    public static String getRegex(IMSIContainer imsiContainer) {
        switch(imsiContainer.getCountryNumber()) {
            case "250":
                // RUSSIA
                switch (imsiContainer.getProvider()) {
                    case "203":
                        return "(\\+7\\s\\(\\d{3}\\)\\d{3}\\-\\d{2}-\\d{2})"; // TELE2_RUSSIA
//                    case "011":
//                        return "*111*0887#"; // MTC_RUSSIA
                    case "021":
                        return "\\s(\\d{10})\n"; // MEGAFON_RUSSIA
                }
            case "234":
                switch (imsiContainer.getProvider()) {
                    case "159":
                        return "(\\d{11})";
                }
            default:
                return "(.*)";
        }
    }
}
