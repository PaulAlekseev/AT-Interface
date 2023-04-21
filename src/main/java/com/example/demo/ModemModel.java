package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ModemModel {
    private Long id;
    private String imsi;
    private String iccid;
    private boolean busy;
    private String phoneNumber;
    private String services;
}
