package com.example.demo.web.extra;

import com.example.demo.web.modem.request_handlers.containers.IMSIContainer;

public class OperatorPhoneRequestNumber {
    public static String getRegex(IMSIContainer imsiContainer) {
        switch(imsiContainer.getCountryNumber()) {
            case "250":
                // RUSSIA
                switch (imsiContainer.getProvider()) {
                    case "203":
                        return "*201#"; // TELE2_RUSSIA
                    case "011":
                        return "*111*0887#"; // MTC_RUSSIA
                    case "021":
                        return "*205#"; // MEGAFON_RUSSIA
                }
            case "234":
                // Great Britain
                switch (imsiContainer.getProvider()) {
                    case "159":
                        return "*#100#"; // LEBARA
                }
        }
        return null;
    }
}
