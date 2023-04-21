package com.example.demo.web.socket.tasks.runnable;

import com.example.demo.web.modem.request_handlers.Modem;
import com.example.demo.web.modem.request_handlers.containers.CCIDContainer;
import com.example.demo.web.modem.request_handlers.containers.IMSIContainer;
import com.example.demo.web.modem.request_handlers.containers.SignalQualityContainer;
import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.modem.states.ModemState;
import com.example.demo.web.socket.WebSocketClient;
import com.example.demo.web.socket.tasks.TaskOutKeywords;
import com.example.demo.web.socket.tasks.containers.in.CheckModemInContainer;
import com.example.demo.web.socket.tasks.containers.out.ModemCheckOutContainer;
import com.google.gson.Gson;

public class CheckModemTask implements RunnableTask{
    @Override
    public void run(ModemProviderState modemProviderState, String jsonString, WebSocketClient socketClient) {
        Gson gson = new Gson();
        CheckModemInContainer containerIn = gson.fromJson(jsonString, CheckModemInContainer.class);
        ModemState modemState = modemProviderState.getWithPhoneNumber(containerIn.getModem().getPhoneNumber());
        Modem modem = new Modem(modemState.getPort());
        int taskId = containerIn.getTaskId();
        try {
            SignalQualityContainer signalResult = modem.getSignalQuality();
            IMSIContainer imsiResult = modem.getIMSI();
            CCIDContainer iccidContainer = modem.getCCID();
            if (signalResult == null || iccidContainer == null || imsiResult == null) {
                ModemCheckOutContainer outContainer = new ModemCheckOutContainer(taskId,  0, null, modemState.getPort());
                socketClient.sendMessage(TaskOutKeywords.MODEM_CHECK, gson.toJson(outContainer));
                modemProviderState.fromBusy(modemState);
                return;
            }
            ModemState resultModemState = new ModemState();
            resultModemState.setICCID(iccidContainer.getCCID());
            resultModemState.setIMSI(imsiResult.getIMSICode());
            resultModemState.setPort(modem.getPort());
            ModemCheckOutContainer outContainer = new ModemCheckOutContainer(taskId, signalResult.getSignalQuality(), resultModemState, modemState.getPort());
            socketClient.sendMessage(TaskOutKeywords.MODEM_CHECK, gson.toJson(outContainer));
            modemProviderState.fromBusy(modemState);
        } catch (Exception e) {
            ModemCheckOutContainer outContainer = new ModemCheckOutContainer(taskId, 0, null, modemState.getPort());
            socketClient.sendMessage(TaskOutKeywords.MODEM_CHECK, gson.toJson(outContainer));
            modemProviderState.fromBusy(modemState);
        }
    }
}
