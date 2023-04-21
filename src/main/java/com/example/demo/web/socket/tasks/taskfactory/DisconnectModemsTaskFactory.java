package com.example.demo.web.socket.tasks.taskfactory;

import com.example.demo.web.socket.tasks.handler.DisconnectModemsTaskHandler;
import com.example.demo.web.socket.tasks.handler.TaskHandler;
import com.example.demo.web.socket.tasks.runnable.DisconnectModemsTask;
import com.example.demo.web.socket.tasks.runnable.RunnableTask;

public class DisconnectModemsTaskFactory implements TaskFactory{
    @Override
    public RunnableTask getRunnableTask() {
        return new DisconnectModemsTask();
    }

    @Override
    public TaskHandler getTaskHandler() {
        return new DisconnectModemsTaskHandler();
    }
}
