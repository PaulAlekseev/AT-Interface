package com.example.demo.web.modem.request_handlers.requests;

import com.example.demo.web.modem.request_handlers.ATCommandExecutor;

public interface ATRequest {
    String makeRequest(ATCommandExecutor executor) throws Exception;
}
