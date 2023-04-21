package com.example.demo.web.modem.request_handlers.requests;

import com.example.demo.web.modem.request_handlers.ATCommandExecutor;

public class ATQLEDDisableRequest implements ATRequest {
    @Override
    public String makeRequest(ATCommandExecutor executor) throws Exception {
        executor.openPort(115200, 8, 1, 0);
        executor.executeAtCommand("AT+QLEDMODE=0", 1000);
        String result = executor.readResult();
        executor.closePort();
        return result;
    }
}
