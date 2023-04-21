package com.example.demo.web.modem.request_handlers;

import com.example.demo.web.modem.request_handlers.containers.*;
import com.example.demo.web.modem.request_handlers.objs.*;

import java.util.ArrayList;

public class Modem {
    private final CCID ccid;
    private final SignalQuality signalQuality;
    private final PhoneNumber phoneNumber;
    private final ATCommandExecutor executor;
    private final Messages messages;
    private final IMSI imsi;
    private final String port;
    private final FirstMessage firstMessage;
    private final QLEDSwitch qledSwitch;
    private final DeleteAllSms deleteAllSms;

    public Modem(String portName) {
        port = portName;
        executor = new ATCommandExecutor(portName);
        signalQuality = new SignalQuality();
        phoneNumber = new PhoneNumber();
        messages = new Messages();
        imsi = new IMSI();
        ccid = new CCID();
        firstMessage = new FirstMessage();
        qledSwitch = new QLEDSwitch();
        deleteAllSms = new DeleteAllSms();
    }

    public SignalQualityContainer getSignalQuality() {
        return signalQuality.getSignalQuality(executor);
    }

    public PhoneNumberContainer getPhoneNumber() {
        return phoneNumber.getPhoneNumber(executor);
    }

    public ArrayList<MessageContainer> getMessages(Boolean delete) {
        return messages.getMessages(executor, delete);
    }

    public IMSIContainer getIMSI() {
        return imsi.getIMSI(executor);
    }

    public CCIDContainer getCCID() {
        return ccid.getCCID(executor);
    }

    public ATCommandExecutor getExecutor() {
        return executor;
    }

    public Boolean deleteAllSMS() {
        return deleteAllSms.deleteAllSms(executor);
    }

    public Boolean switchQLED(boolean status) {
        return qledSwitch.setQLED(status, executor);
    }

    public Boolean setPhoneNumber(String phoneNumber) {
        return SetPhoneNumber.set(executor, phoneNumber);
    }

    @Deprecated
    public MessageContainer getFirstMessage() {
        return firstMessage.getFirstMessage(executor);
    }

    public String getPort() {
        return port;
    }
}
