package com.example.demo.web.socket.tasks.taskfactory;

import com.example.demo.web.socket.tasks.handler.TaskHandler;
import com.example.demo.web.socket.tasks.handler.UpdateProviderTaskHandler;
import com.example.demo.web.socket.tasks.runnable.RunnableTask;
import com.example.demo.web.socket.tasks.runnable.UpdateProviderTask;
import com.example.demo.web.socket.tasks.taskfactory.TaskFactory;

public class UpdateProviderTaskFactory implements TaskFactory {

    @Override
    public RunnableTask getRunnableTask() {
        return new UpdateProviderTask();
    }

    @Override
    public TaskHandler getTaskHandler() {
        return new UpdateProviderTaskHandler();
    }
}
