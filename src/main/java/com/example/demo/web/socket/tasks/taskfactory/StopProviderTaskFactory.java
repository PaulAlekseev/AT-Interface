package com.example.demo.web.socket.tasks.taskfactory;

import com.example.demo.web.socket.tasks.handler.StopProviderTaskHandler;
import com.example.demo.web.socket.tasks.handler.TaskHandler;
import com.example.demo.web.socket.tasks.runnable.RunnableTask;
import com.example.demo.web.socket.tasks.runnable.StopProviderTask;

public class StopProviderTaskFactory implements TaskFactory {
    @Override
    public RunnableTask getRunnableTask() {
        return new StopProviderTask();
    }

    @Override
    public TaskHandler getTaskHandler() {
        return new StopProviderTaskHandler();
    }
}
