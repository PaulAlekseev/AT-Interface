package com.example.demo.web.socket.tasks.taskfactory;

import com.example.demo.web.socket.tasks.handler.StartSaveModemsTaskHandler;
import com.example.demo.web.socket.tasks.handler.TaskHandler;
import com.example.demo.web.socket.tasks.runnable.RunnableTask;
import com.example.demo.web.socket.tasks.runnable.StartSaveModemsTask;

public class StartSaveModemsTaskFactory implements TaskFactory {
    @Override
    public RunnableTask getRunnableTask() {
        return new StartSaveModemsTask();
    }

    @Override
    public TaskHandler getTaskHandler() {
        return new StartSaveModemsTaskHandler();
    }
}
