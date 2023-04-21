package com.example.demo.web.socket.tasks.taskfactory;

import com.example.demo.web.socket.tasks.handler.TaskHandler;
import com.example.demo.web.socket.tasks.handler.UpdateModemTaskHandler;
import com.example.demo.web.socket.tasks.runnable.RunnableTask;
import com.example.demo.web.socket.tasks.runnable.UpdateModemTask;

public class UpdateModemTaskFactory implements TaskFactory{
    @Override
    public RunnableTask getRunnableTask() {
        return new UpdateModemTask();
    }

    @Override
    public TaskHandler getTaskHandler() {
        return new UpdateModemTaskHandler();
    }
}
