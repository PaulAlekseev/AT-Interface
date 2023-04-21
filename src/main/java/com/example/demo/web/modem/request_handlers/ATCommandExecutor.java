package com.example.demo.web.modem.request_handlers;

import jssc.SerialPort;
import jssc.SerialPortException;

public class ATCommandExecutor {
    private final SerialPort serialPort;

    public ATCommandExecutor(String portName) {
        serialPort = new SerialPort(portName);
    }

    public void executeAtCommand(String command, int timeout) throws Exception {
        String finalCommand = command + "\r\n";
        serialPort.writeString(finalCommand);
        Thread.sleep(timeout);
    }

    public String readResult() throws SerialPortException {
        return serialPort.readString();
    }

    public boolean openPort(int baudRate, int dataBits, int stopBits, int parity) {
        try {
            if(serialPort.isOpened()) {
                serialPort.closePort();
            }
            serialPort.openPort();
            serialPort.setParams(baudRate, dataBits, stopBits, parity);
        } catch(SerialPortException exc) {
            return false;
        }
        return true;
    }

    public boolean closePort() {
        try {
            serialPort.closePort();
        } catch(SerialPortException exc) {
            return false;
        }
        return true;
    }
}
