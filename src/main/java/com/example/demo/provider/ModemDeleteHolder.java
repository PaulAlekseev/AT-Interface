package com.example.demo.provider;

import com.example.demo.ModemModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ModemDeleteHolder {

    @Getter
    @Setter
    private List<ModemModel> modems;
    private static ModemDeleteHolder holder;
    private ModemDeleteHolder(List<ModemModel> modems) {
        this.modems = modems;
    }

    public static ModemDeleteHolder getHolder() {
        return holder;
    }

    public static ModemDeleteHolder setHolder(List<ModemModel> modems) {
        holder = new ModemDeleteHolder(modems);
        return holder;
    }
}
