package com.example.demo.service;

import com.example.demo.TaskModel;
import com.example.demo.runnable.TaskStartRunnable;
import javafx.application.Platform;
import javafx.scene.control.TableView;

public class TaskService {
    public void startTaskController(TableView<TaskModel> taskModelTableView) {
        Platform.runLater(new TaskStartRunnable(taskModelTableView));
    }
}
