package com.example.demo.web.socket.tasks.containers.in;

public class UpdateProviderInContainer {
    private final int taskId;


    public UpdateProviderInContainer(int taskId) {
        this.taskId = taskId;
    }

    public int getTaskId() {
        return taskId;
    }
}
