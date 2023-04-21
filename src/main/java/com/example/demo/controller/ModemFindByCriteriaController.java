package com.example.demo.controller;

import com.example.demo.ModemModel;
import com.example.demo.ProviderApplication;
import com.example.demo.provider.ModemDeleteHolder;
import com.example.demo.provider.ModemRevenueServicesProvider;
import com.example.demo.service.ModemFindByCriteriaService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ModemFindByCriteriaController implements Initializable {

    @FXML
    private TextField serviceField;
    @FXML
    private TextField revenueField;
    @FXML
    private Button button;
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
    private Button deleteModemsButton;

    private final ModemFindByCriteriaService modemFindByCriteriaService = new ModemFindByCriteriaService();

    public void getModemsByCriteria() {
        String revenue = revenueField.getText();
        String services = serviceField.getText();
        if (Objects.equals(revenue, "")) {
            revenue = "100000";
        }
        if (Objects.equals(services, "")) {
            services = "aaaaaaaaaaaaaa";
        }
        ModemRevenueServicesProvider.setCriteria(revenue, services);
        modemFindByCriteriaService.getModemsByRevenueAndServices(tableView);
    }

    public void deleteChosenModems() throws IOException {
        ObservableList<ModemModel> modems = tableView.getSelectionModel().getSelectedItems();
        ModemDeleteHolder.setHolder(modems);
        FXMLLoader fxmlLoader = new FXMLLoader(ProviderApplication.class.getResource("ModemsRemove.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage newStage = new Stage();
        newStage.setTitle("Remove modems");
        newStage.setScene(scene);
        newStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<ModemModel, Long>("id"));
        imsi.setCellValueFactory(new PropertyValueFactory<ModemModel, String>("imsi"));
        busy.setCellValueFactory(new PropertyValueFactory<ModemModel, Boolean>("busy"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<ModemModel, String>("phoneNumber"));
        services.setCellValueFactory(new PropertyValueFactory<ModemModel, String>("services"));
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
}
