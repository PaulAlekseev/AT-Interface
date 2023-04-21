package com.example.demo.web.modem.request_handlers.containers;

public class IMSIContainer {

    private String IMSICode;
    private String countryNumber;
    private String provider;

    public IMSIContainer() {
    }

    public String getIMSICode() {
        return IMSICode;
    }

    public void setIMSICode(String IMSICode) {
        this.IMSICode = IMSICode;
    }

    public String getCountryNumber() {
        return countryNumber;
    }

    public void setCountryNumber(String countryNumber) {
        this.countryNumber = countryNumber;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
