package com.example.demo.web.socket.tasks.taskfactory;

import com.example.demo.web.socket.tasks.handler.CheckModemTaskHandler;
import com.example.demo.web.socket.tasks.handler.TaskHandler;
import com.example.demo.web.socket.tasks.runnable.CheckModemTask;
import com.example.demo.web.socket.tasks.runnable.RunnableTask;

public class CheckModemTaskFactory implements TaskFactory {
    @Override
    public RunnableTask getRunnableTask() {
        return new CheckModemTask();
    }

    @Override
    public TaskHandler getTaskHandler() {
        return new CheckModemTaskHandler();
    }
}
