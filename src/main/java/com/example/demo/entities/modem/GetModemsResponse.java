package com.example.demo.entities.modem;

import com.example.demo.ModemModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GetModemsResponse {
    private boolean ok;
    private List<ModemModel> data;
}
