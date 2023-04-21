package com.example.demo.web.extra;

import com.example.demo.web.modem.request_handlers.ATCommandExecutor;
import com.example.demo.web.modem.request_handlers.containers.IMSIContainer;

public enum ATPhoneNumberRequestMethod {
    AT_CNUM {
        public String executeMethod(ATCommandExecutor executor, IMSIContainer imsiContainer) throws Exception {
            executor.openPort(115200, 8, 1, 0);
            String commandAT = "AT+CNUM";
            executor.executeAtCommand(commandAT, 1000);
            String result = executor.readResult();
            executor.closePort();
            return result;
        }
    },
    CUSD {
        public String executeMethod(ATCommandExecutor executor, IMSIContainer imsiContainer) throws Exception {
            executor.openPort(115200, 8, 1, 0);
            String commandAT = String.format("AT+CUSD=1,%s,15", OperatorPhoneRequestNumber.getRegex(imsiContainer));
            executor.executeAtCommand(commandAT, 10000);
            String result = executor.readResult();
            executor.closePort();
            return result;
        }
    };

    public abstract String executeMethod(ATCommandExecutor executor, IMSIContainer imsiContainer) throws Exception;
}
