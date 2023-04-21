package com.example.demo.web.extra;

import com.example.demo.web.modem.request_handlers.containers.IMSIContainer;

public class DecidePhoneNumberMethod {
    private static final String RUSSIA = "250";
    private static final String GREAT_BRITAIN = "234";
    private static final String RUSSIA_TELE2 = "203";
    private static final String LEBARA = "159";


    public static ATPhoneNumberRequestMethod decideMethod(IMSIContainer imsiContainer) {
        switch (imsiContainer.getCountryNumber()) {
            case RUSSIA:
                switch (imsiContainer.getProvider()) {
                    case RUSSIA_TELE2:
                        return ATPhoneNumberRequestMethod.CUSD;
                }

            case GREAT_BRITAIN:
                switch (imsiContainer.getProvider()) {
                    case LEBARA:
                        return ATPhoneNumberRequestMethod.CUSD;
                }
            default:
                return ATPhoneNumberRequestMethod.AT_CNUM;
        }
    }
}
