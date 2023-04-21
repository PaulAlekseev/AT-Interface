package com.example.demo.controller;

import com.example.demo.ModemPortModel;
import com.example.demo.service.PhoneAssignerService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PhoneAssignerController implements Initializable {

    @FXML
    private Button updateModemsButton;

    @FXML
    private Button lightOnButton;

    @FXML
    private Button lightOffButton;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private Button SetPhoneNumberButton;

    @FXML
    private TableView<ModemPortModel> tableView;

    @FXML
    private TableColumn<ModemPortModel, String> port;

    @FXML
    private TableColumn<ModemPortModel, String> iccid;

    private PhoneAssignerService service = new PhoneAssignerService();

    public void updateModems() {
        service.updateModems(tableView);
    }

    public void turnQledOnPortOff() {
        service.setPortQledMode(false, tableView);
    }

    public void turnQledOnPortOn() {
        service.setPortQledMode(true, tableView);
    }

    public void setPhoneNumber() {
        service.setPhoneNumber(tableView, phoneNumberField);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        port.setCellValueFactory(new PropertyValueFactory<ModemPortModel, String>("port"));
        iccid.setCellValueFactory(new PropertyValueFactory<ModemPortModel, String>("iccid"));
    }
}
