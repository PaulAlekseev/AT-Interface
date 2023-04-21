package com.example.demo.provider;

import lombok.Getter;
import lombok.Setter;

public class ModemRevenueServicesProvider {

    @Setter
    @Getter
    private String revenue;
    @Setter
    @Getter
    private String service;

    private static ModemRevenueServicesProvider modemRevenueServicesProvider;

    private ModemRevenueServicesProvider(String revenue, String service) {
        this.revenue = revenue;
        this.service = service;
    }

    public static ModemRevenueServicesProvider setCriteria(String revenue, String service) {
        modemRevenueServicesProvider = new ModemRevenueServicesProvider(revenue, service);
        return modemRevenueServicesProvider;
    }

    public static ModemRevenueServicesProvider getCriteria() {
        return modemRevenueServicesProvider;
    }
}
