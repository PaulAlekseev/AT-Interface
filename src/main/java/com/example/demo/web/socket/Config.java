package com.example.demo.web.socket;

import com.example.demo.entities.authentication.JwtTokenProvider;

import javax.websocket.ClientEndpointConfig;
import java.util.*;

public class Config extends ClientEndpointConfig.Configurator {
    @Override
    public void beforeRequest(Map<String, List<String>> headers) {
        super.beforeRequest(headers);
        headers.put(
                "Authorization",
                Collections.singletonList("Bearer " + JwtTokenProvider.getJwtTokenProvider().getAccessToken()));
    }
}
