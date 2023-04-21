package com.example.demo.web.socket.tasks.containers.in;

import com.example.demo.web.modem.states.ModemState;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DisconnectModemsInContainer {
    private List<ModemState> data;
}
