package com.example.demo.entities.task;

import com.example.demo.TaskModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetTasksResponse {
    private boolean ok;
    private List<TaskModel> tasks;
}
