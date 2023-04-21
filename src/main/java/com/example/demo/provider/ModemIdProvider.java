package com.example.demo.provider;

import lombok.Getter;
import lombok.Setter;

public class ModemIdProvider {
    @Getter
    @Setter
    private Long modemId;

    private static ModemIdProvider modemIdProvider;

    private ModemIdProvider(Long modemId) {
        this.modemId = modemId;
    }

    public static ModemIdProvider setProvider(Long modemId) {
        modemIdProvider = new ModemIdProvider(modemId);
        return modemIdProvider;
    }

    public static ModemIdProvider getProvider() {
        return modemIdProvider;
    }
}
