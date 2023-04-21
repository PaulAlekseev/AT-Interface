package com.example.demo.web.socket.tasks.taskfactory;

import com.example.demo.web.socket.tasks.handler.AddModemsTaskHandler;
import com.example.demo.web.socket.tasks.handler.TaskHandler;
import com.example.demo.web.socket.tasks.runnable.AddModemTask;
import com.example.demo.web.socket.tasks.runnable.RunnableTask;
import com.example.demo.web.socket.tasks.taskfactory.TaskFactory;

public class AddModemsTaskFactory implements TaskFactory {
    @Override
    public RunnableTask getRunnableTask() {
        return new AddModemTask();
    }

    @Override
    public TaskHandler getTaskHandler() {
        return new AddModemsTaskHandler();
    }
}
