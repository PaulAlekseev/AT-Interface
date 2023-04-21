package com.example.demo.service;

import com.example.demo.ModemModel;
import com.example.demo.ProviderApplication;
import com.example.demo.provider.ModemDeleteHolder;
import com.example.demo.provider.ModemIdProvider;
import com.example.demo.runnable.*;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class ProviderService {

    public void startProvider() {
        Platform.runLater(new StartProviderRunnable());
    }

    public void stopProvider() {
        Platform.runLater(new StopProviderRunnable());
    }

    public void saveModems() {
        Platform.runLater(new SaveAllModemsRunnable());
    }

    public void getModems(TableView<ModemModel> tableView) {
        Platform.runLater(new GetModemsRunnable(tableView));
    }

    public void startAddModems() {
        Platform.runLater(new StartAddModemsRunnable());
    }
    public void openWindowByCriteria() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ProviderApplication.class.getResource("ModemFindByCriteria.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage newStage = new Stage();
        newStage.setTitle("Tasks");
        newStage.setScene(scene);
        newStage.show();
    }

    public int openTaskWindow(TableView<ModemModel> tableView) throws IOException {
        ModemModel modem = tableView.getSelectionModel().selectedItemProperty().get();
        if (modem == null) {
            System.out.println("Select modem");
            return 0;
        }
        ModemIdProvider.setProvider(modem.getId());
        FXMLLoader fxmlLoader = new FXMLLoader(ProviderApplication.class.getResource("TaskWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage newStage = new Stage();
        newStage.setTitle("Tasks");
        newStage.setScene(scene);
        newStage.show();
        return 1;
    }

    public void startRemoveModem(TableView<ModemModel> tableView) throws IOException {
        ObservableList<ModemModel> modems = tableView.getSelectionModel().getSelectedItems();
        ModemDeleteHolder.setHolder(modems);
        FXMLLoader fxmlLoader = new FXMLLoader(ProviderApplication.class.getResource("ModemsRemove.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage newStage = new Stage();
        newStage.setTitle("Remove modems");
        newStage.setScene(scene);
        newStage.show();
    }

    public void startPhoneAssigner() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ProviderApplication.class.getResource("PhoneAssigner.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage newStage = new Stage();
        newStage.setTitle("Phone Assigner");
        newStage.setScene(scene);
        newStage.show();
    }
}
