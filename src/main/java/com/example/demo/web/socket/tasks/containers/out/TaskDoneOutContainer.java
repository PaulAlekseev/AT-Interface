package com.example.demo.web.socket.tasks.containers.out;

public class TaskDoneOutContainer {
    private final Long taskId;

    public TaskDoneOutContainer(Long taskId) {
        this.taskId = taskId;
    }

    public Long getTaskId() {
        return taskId;
    }
}
