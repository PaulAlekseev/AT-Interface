package com.example.demo.controller;

import com.example.demo.ModemModel;
import com.example.demo.provider.ModemDeleteHolder;
import com.example.demo.provider.ModemIdProvider;
import com.example.demo.service.ProviderService;
import com.example.demo.web.socket.SocketSingleton;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IndexController implements Initializable {
    @FXML
    private AnchorPane anchorPane;

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

    @FXML
    private Button startButton;

    @FXML
    private Button stopButton;

    @FXML
    private Button saveAllModemsButton;

    @FXML
    private Button getModemsButton;

    @FXML
    private Button openButton;

    @FXML
    private Button modemByCriteria;

    @FXML
    private Button deleteModemButton;

    @FXML
    private Button addModemsButton;

    @FXML
    private Button startPhoneAssignerButton;


    private final ProviderService providerService = new ProviderService();

    public void startProvider() {
        providerService.startProvider();
    }

    public void stopProvider() {
        providerService.stopProvider();
    }

    public void saveAllModems() {
        providerService.saveModems();
    }

    public void getModems() {
        providerService.getModems(tableView);
    }

    public void openWindowByCriteria() throws IOException {
        providerService.openWindowByCriteria();
    }

    public int openTaskWindow() throws IOException {
        return providerService.openTaskWindow(tableView);
    }

    public void startRemoveModems() throws IOException {
        providerService.startRemoveModem(tableView);
    }

    public void startAddModems() {
        providerService.startAddModems();
    }

    public void startPhoneAssigner() throws IOException {
        providerService.startPhoneAssigner();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<ModemModel, Long>("id"));
        imsi.setCellValueFactory(new PropertyValueFactory<ModemModel, String>("imsi"));
        busy.setCellValueFactory(new PropertyValueFactory<ModemModel, Boolean>("busy"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<ModemModel, String>("phoneNumber"));
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        services.setCellValueFactory(new PropertyValueFactory<ModemModel, String>("services"));
    }
}
