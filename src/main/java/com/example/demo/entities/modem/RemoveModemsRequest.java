package com.example.demo.entities.modem;


import com.example.demo.ModemModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class RemoveModemsRequest {
    private List<ModemModel> modem;
}
