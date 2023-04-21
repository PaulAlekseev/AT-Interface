package com.example.demo.web.socket.handlers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SocketMessageContainer {
    private final String task;
    private final String json;
}
