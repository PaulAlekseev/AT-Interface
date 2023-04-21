package com.example.demo.web.modem.states;

import com.example.demo.web.modem.request_handlers.Modem;
import com.example.demo.web.modem.states.threading.SaveNewModemRunnable;
import com.example.demo.web.socket.WebSocketClient;
import com.example.demo.web.socket.tasks.TaskOutKeywords;
import com.example.demo.web.socket.tasks.containers.out.ProviderBusyOutContainer;
import com.google.gson.Gson;
import jssc.SerialPortList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ModemProviderState {

    public static final int BULK_SIZE = 16;
    public static final int THREAD_TIMEOUT = 3000;
    private ArrayList<ModemState> modems;
    private ArrayList<ModemState> busyModems;
    private Boolean busy;
    private Boolean busyOnTask;
    private WebSocketClient socketClient;

    public ModemProviderState(WebSocketClient socketClient) {
        this.modems = new ArrayList<>();
        this.busyModems = new ArrayList<>();
        this.busy = true;
        this.busyOnTask = false;
        this.socketClient = socketClient;
    }

    public List<ModemState> updateModems() {
        modems.clear();
        ArrayList<String> ports = new ArrayList<>(Arrays.asList(SerialPortList.getPortNames()));
        updateModems(ports);
        List<String> modemsPorts = modems.stream()
                .map(ModemState::getPort)
                .toList();
        ArrayList<String> notWorking  = new ArrayList<>(Arrays.asList(SerialPortList.getPortNames()).stream()
                .filter((entity) -> !modemsPorts.contains(entity))
                .toList());
        updateModems(notWorking);
        return modems;
    }

    public List<ModemState> updateModems(List<String> ports) {
        ArrayList<String> innerPorts = new ArrayList<>();
        ArrayList<Thread> finalThreads = new ArrayList<>();
        List<String> busyPorts = busyModems.stream().map(ModemState::getPort).toList();
        while (!ports.isEmpty()) {
            innerPorts.clear();
            for(String s : ports) {
                innerPorts.add(s);
                if (innerPorts.size() == BULK_SIZE) {
                    break;
                }
            }
            for (String deletePorts: innerPorts) {
                ports.remove(deletePorts);
            }
            System.out.println(ports.size());
            ArrayList<Thread> threads = new ArrayList<>();
            ArrayList<ModemState> modemStates = new ArrayList<>();
            System.out.println(innerPorts);
            for (String port : innerPorts) {
                if (!busyPorts.contains(port)) {
                    ModemState modemState = new ModemState(port);
                    modemStates.add(modemState);
                    threads.add(modemState.updateState());
                }
            }
            for (Thread thread : threads) {
                try {
                    finalThreads.add(thread);
                    thread.join(THREAD_TIMEOUT);
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                }
            }
            for (ModemState modemState : modemStates) {
                if (modemState.getIMSI() != null) {
                    this.modems.add(modemState);
                }
            }
        }
        for (Thread thread: finalThreads) {
            if (thread.isAlive()) {
                thread.interrupt();
            }
        }
        return this.modems;
    }

    public void saveNewModems(List<ModemState> newModems) throws InterruptedException {
        ArrayList<ModemState> modemsWithPhone = new ArrayList<>();
        ArrayList<Thread> threads = new ArrayList<>();
        for (ModemState modemState : newModems) {
            Modem modem = new Modem(modemState.getPort());
            SaveNewModemRunnable runnable = new SaveNewModemRunnable(modem, modemState);
            Thread thread = new Thread(runnable);
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join(2000);
        }
        for (ModemState modem : newModems) {
            if (modem.getPhoneNumber() != null) {
                modemsWithPhone.add(modem);
            }
        }
        Gson gson = new Gson();
        socketClient.sendMessage(TaskOutKeywords.SAVE_MODEMS, gson.toJson(modemsWithPhone));
    }

    public void removeByImsiAndIccid(String imsi, String iccid) {
            for (int index = 0; index < modems.size(); index++) {
                ModemState modem = modems.get(index);
                if (Objects.equals(modem.getIMSI(), imsi)) {
                    if (Objects.equals(modem.getICCID(), iccid)) {
                        modems.remove(modem);
                        new Modem(modem.getPort()).switchQLED(true);
                    }
                }
            }
    }

    public List<ModemState> getAllModems() {
        List<ModemState> notBusyModems = new ArrayList<>(modems);
        List<ModemState> newBusyModems = new ArrayList<>(busyModems);
        notBusyModems.addAll(newBusyModems);
        return notBusyModems;
    }

    public boolean portIsInactive(String port) {
        return getInactivePorts().contains(port);
    }

    public List<String> getInactivePorts() {
        List<String> activePorts = getAllModems()
                .stream()
                .map(ModemState::getPort)
                .toList();
        return new ArrayList<>(Arrays.stream(SerialPortList.getPortNames())
                .filter(entity -> !activePorts.contains(entity))
                .toList());
    }

    public void toBusy(ModemState modemState) {
        if (modems.contains(modemState)) {
            modems.remove(modemState);
            busyModems.add(modemState);
        }
    }

    public void fromBusy(ModemState modemState) {
        if (busyModems.contains(modemState)) {
            busyModems.remove(modemState);
            modems.add(modemState);
        }
    }

    public ModemState getWithPhoneNumber(String phoneNumber) {
        for (ModemState modemState : modems) {
            if (Objects.equals(modemState.getPhoneNumber(), phoneNumber)) {
                return modemState;
            }
        }
        return null;
    }

    public Boolean getBusy() {
        return busy;
    }

    public void setBusy(Boolean busy) {
        this.busy = busy;
    }

    public void setBusy() {
        try {
            Gson gson = new Gson();
            ProviderBusyOutContainer container = new ProviderBusyOutContainer(true);
            String jsonResponse = gson.toJson(container);
            socketClient.sendMessage(TaskOutKeywords.PROVIDER_BUSY, jsonResponse);
            busy = true;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void setNotBusy() {
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(this.getModems());
        socketClient.sendMessage(TaskOutKeywords.PROVIDER_READY, jsonResponse);
        busy = false;
    }

    public ModemState getByPortName(String portName) {
        for (ModemState modem : modems) {
            if (Objects.equals(modem.getPort(), portName)) {
                return modem;
            }
        }
        return null;
    }

    public void setModemByPortName(String portName, ModemState modem) {
        List<ModemState> listModems = getModems();
        listModems.remove(getByPortName(portName));
        if (modem == null) return;
        modem.setPort(portName);
        listModems.add(modem);
    }

    public boolean existsByImsiAndIccid(String imsi, String iccid) {
        for (ModemState modem : modems) {
            if (Objects.equals(modem.getIMSI(), imsi) && Objects.equals(modem.getICCID(), iccid)){
                return true;
            }
        }
        return false;
    }

    public void removeModemByPort(String portName) {
        modems.remove(getByPortName(portName));
    }

    public WebSocketClient getSocketClient() {
        return socketClient;
    }

    public void setSocketClient(WebSocketClient socketClient) {
        this.socketClient = socketClient;
    }

    public Boolean getBusyOnTask() {
        return busyOnTask;
    }

    public void setBusyOnTask(Boolean busyOnTask) {
        this.busyOnTask = busyOnTask;
    }


    public List<ModemState> getModems() {
        return modems;
    }

    public void setModems(ArrayList<ModemState> modems) {
        this.modems = modems;
    }

    public List<ModemState> getBusyModems() {
        return busyModems;
    }

    public void setBusyModems(ArrayList<ModemState> busyModems) {
        this.busyModems = busyModems;
    }
}
