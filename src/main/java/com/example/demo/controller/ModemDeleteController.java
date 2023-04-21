package com.example.demo.controller;

import com.example.demo.ModemModel;
import com.example.demo.provider.ModemDeleteHolder;
import com.example.demo.service.ModemDeleteService;
import com.example.demo.service.ModemFindByCriteriaService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ModemDeleteController implements Initializable {
    @FXML
    private Button removeButton;
    @FXML
    private Button removeFromListButton;
    @FXML
    private TableView<ModemModel> tableView;
    @FXML
    private TableColumn<ModemModel, Long> id;

    @FXML
    private TableColumn<ModemModel, String> imsi;
    @FXML
    private TableColumn<ModemModel, Boolean> busy;

    @FXML
    private TableColumn<ModemModel, String> phoneNumber;
    @FXML
    private TableColumn<ModemModel, String> services;

    private final ModemDeleteService modemDeleteService = new ModemDeleteService();

    public void removeModems() {
        modemDeleteService.removeModems(tableView);
    }

    public void removeFromList() {
        modemDeleteService.removeFromList(tableView);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<ModemModel, Long>("id"));
        imsi.setCellValueFactory(new PropertyValueFactory<ModemModel, String>("imsi"));
        busy.setCellValueFactory(new PropertyValueFactory<ModemModel, Boolean>("busy"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<ModemModel, String>("phoneNumber"));
        services.setCellValueFactory(new PropertyValueFactory<ModemModel, String>("services"));
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ModemDeleteHolder modemDeleteHolder = ModemDeleteHolder.getHolder();
        modemDeleteService.addModemsToTable(modemDeleteHolder.getModems(), tableView);
    }
}
