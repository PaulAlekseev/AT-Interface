package com.example.demo.web.socket.tasks.containers.out;

import com.example.demo.web.modem.states.ModemState;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class DisconnectModemsOutContainer {
    private List<ModemState> modems;
}
