package com.example.demo.web.socket.tasks.taskfactory;

import com.example.demo.web.socket.tasks.handler.SetStationaryModemsHandler;
import com.example.demo.web.socket.tasks.handler.TaskHandler;
import com.example.demo.web.socket.tasks.runnable.RunnableTask;
import com.example.demo.web.socket.tasks.runnable.SetStationaryModemsTask;

public class SetStationaryModemsTaskFactory implements TaskFactory{
    @Override
    public RunnableTask getRunnableTask() {
        return new SetStationaryModemsTask();
    }

    @Override
    public TaskHandler getTaskHandler() {
        return new SetStationaryModemsHandler();
    }
}
