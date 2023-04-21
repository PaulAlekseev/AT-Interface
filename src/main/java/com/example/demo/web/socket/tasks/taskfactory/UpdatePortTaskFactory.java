package com.example.demo.web.socket.tasks.taskfactory;

import com.example.demo.web.socket.tasks.handler.TaskHandler;
import com.example.demo.web.socket.tasks.handler.UpdatePortHandler;
import com.example.demo.web.socket.tasks.runnable.RunnableTask;
import com.example.demo.web.socket.tasks.runnable.UpdatePortTask;

public class UpdatePortTaskFactory implements TaskFactory{
    @Override
    public RunnableTask getRunnableTask() {
        return new UpdatePortTask();
    }

    @Override
    public TaskHandler getTaskHandler() {
        return new UpdatePortHandler();
    }
}
