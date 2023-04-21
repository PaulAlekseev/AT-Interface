package com.example.demo.web.socket.tasks.taskfactory;

import com.example.demo.web.socket.tasks.handler.SaveModemsTaskHandler;
import com.example.demo.web.socket.tasks.handler.TaskHandler;
import com.example.demo.web.socket.tasks.runnable.RunnableTask;
import com.example.demo.web.socket.tasks.runnable.SaveModemsTask;

public class SaveModemsTaskFactory implements TaskFactory {
    @Override
    public RunnableTask getRunnableTask() {
        return new SaveModemsTask();
    }

    @Override
    public TaskHandler getTaskHandler() {
        return new SaveModemsTaskHandler();
    }
}
