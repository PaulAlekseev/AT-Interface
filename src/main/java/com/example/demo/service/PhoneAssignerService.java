package com.example.demo.service;

import com.example.demo.ModemPortModel;
import com.example.demo.runnable.CheckOnPhoneAssigner;
import com.example.demo.runnable.TurnQledRunnable;
import com.example.demo.web.modem.request_handlers.Modem;
import javafx.application.Platform;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PhoneAssignerService {

    public void updateModems(TableView<ModemPortModel> tableView) {
        Platform.runLater(new CheckOnPhoneAssigner(tableView));
    }

    public void setPortQledMode(boolean mode, TableView<ModemPortModel> tableView) {
        ModemPortModel modem = tableView.getSelectionModel().selectedItemProperty().get();
        String port = modem.getPort();
        Platform.runLater(new TurnQledRunnable(port, mode));
    }

    public void setPhoneNumber(TableView<ModemPortModel> tableView, TextField textField) {
        ModemPortModel modemModel = tableView.getSelectionModel().selectedItemProperty().get();
        String port = modemModel.getPort();
        Modem modem = new Modem(port);
        System.out.println(textField.getText());
        modem.setPhoneNumber(textField.getText());
    }
}
