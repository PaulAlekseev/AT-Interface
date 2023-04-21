package com.example.demo.controller;

import com.example.demo.TaskModel;
import com.example.demo.service.TaskService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.RequiredArgsConstructor;

import java.net.URL;
import java.util.ResourceBundle;

public class TasksController implements Initializable {

    @FXML
    private TableView<TaskModel> tableView;
    @FXML
    private TableColumn<TaskModel, Long> id;
    @FXML
    private TableColumn<TaskModel, String> serviceName;
    @FXML
    private TableColumn<TaskModel, Integer> cost;
    @FXML
    private TableColumn<TaskModel, Boolean> done;
    @FXML
    private TableColumn<TaskModel, Boolean> success;

    private final TaskService taskService = new TaskService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<TaskModel, Long>("id"));
        serviceName.setCellValueFactory(new PropertyValueFactory<TaskModel, String>("serviceName"));
        done.setCellValueFactory(new PropertyValueFactory<TaskModel, Boolean>("done"));
        success.setCellValueFactory(new PropertyValueFactory<TaskModel, Boolean>("success"));
        cost.setCellValueFactory(new PropertyValueFactory<TaskModel, Integer>("cost"));
        taskService.startTaskController(tableView);
    }
}
