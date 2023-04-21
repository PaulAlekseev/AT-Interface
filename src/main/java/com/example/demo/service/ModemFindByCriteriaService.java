package com.example.demo.service;

import com.example.demo.ModemModel;
import com.example.demo.runnable.GetModemByCriteriaRunnable;
import javafx.application.Platform;
import javafx.scene.control.TableView;

public class ModemFindByCriteriaService {
    public void getModemsByRevenueAndServices(TableView<ModemModel> tableView) {
        Platform.runLater(new GetModemByCriteriaRunnable(tableView));
    }
}
