package com.example.demo.entities.modem;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ModemByCriteriaRequest {
    private boolean byRevenue;
    private int revenue;
    private boolean byService;
    private String services;
}
