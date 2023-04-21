package com.example.demo.web.extra;

public class IMSICountryRegex {
    public static String getRegex(String countryNumber) {
        switch(countryNumber) {
            case "250":
                // Russia
            case "234":
                // Great Britain
                return "(\\d{3})\\d+";
        }
        return null;
    }
}
