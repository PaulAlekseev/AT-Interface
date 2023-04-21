package com.example.demo.web.socket.tasks.taskfactory;

import com.example.demo.web.socket.tasks.handler.StartProviderTaskHandler;
import com.example.demo.web.socket.tasks.handler.TaskHandler;
import com.example.demo.web.socket.tasks.runnable.RunnableTask;
import com.example.demo.web.socket.tasks.runnable.StartProviderTask;

public class StartProviderTaskFactory implements TaskFactory{
    @Override
    public RunnableTask getRunnableTask() {
        return new StartProviderTask();
    }

    @Override
    public TaskHandler getTaskHandler() {
        return new StartProviderTaskHandler();
    }
}
