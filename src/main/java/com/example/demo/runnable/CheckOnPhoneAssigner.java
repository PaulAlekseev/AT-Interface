package com.example.demo.runnable;

import com.example.demo.ModemPortModel;
import com.example.demo.web.modem.states.ModemState;
import com.example.demo.web.socket.SocketSingleton;
import com.example.demo.web.socket.WebSocketClient;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.List;

public class CheckOnPhoneAssigner implements Runnable{

    private TableView<ModemPortModel> tableView;
    public CheckOnPhoneAssigner(TableView<ModemPortModel> tableView) {
        this.tableView = tableView;
    }

    @Override
    public void run() {
        List<CheckModemOnPhoneRunnable> checkers = SocketSingleton
                .getWebSocketClient().getModemProviderState().getInactivePorts()
                .stream()
                .map(CheckModemOnPhoneRunnable::new)
                .toList();
        List<Thread> threads = checkers
                .stream()
                .map(Thread::new)
                .toList();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads ) {
            try {
                thread.join(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
        List<ModemPortModel> result = checkers
                .stream()
                .filter(CheckModemOnPhoneRunnable::isNeedAssign)
                .map(entity -> new ModemPortModel(entity.getPort(), entity.getIccid()))
                .toList();
        ObservableList<ModemPortModel> items = tableView.getItems();
        items.removeAll();
        items.addAll(result);
        tableView.setItems(items);
    }
}
