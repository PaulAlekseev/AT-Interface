package com.example.demo.web.modem.request_handlers.objs;

import com.example.demo.web.modem.request_handlers.ATCommandExecutor;

public class SetPhoneNumber {
    public static boolean set(ATCommandExecutor executor, String phoneNumber) {
        executor.openPort(115200, 8, 1, 0);
        try {
            executor.executeAtCommand("AT+CPBS=\"ON\"", 300);
            executor.executeAtCommand(String.format("AT+CPBW=,\"%s\"", phoneNumber), 300);
            String output = executor.readResult();
            executor.closePort();
            return output.contains("OK");
        } catch (Exception e) {
            return false;
        }
    }
}
