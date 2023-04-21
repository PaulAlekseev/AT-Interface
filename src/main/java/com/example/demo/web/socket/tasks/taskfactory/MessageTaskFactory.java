package com.example.demo.web.socket.tasks.taskfactory;

import com.example.demo.web.socket.tasks.handler.MessageTaskHandler;
import com.example.demo.web.socket.tasks.handler.TaskHandler;
import com.example.demo.web.socket.tasks.runnable.MessageTask;
import com.example.demo.web.socket.tasks.runnable.RunnableTask;
import com.example.demo.web.socket.tasks.taskfactory.TaskFactory;

public class MessageTaskFactory implements TaskFactory {
    @Override
    public RunnableTask getRunnableTask() {
        return new MessageTask();
    }

    @Override
    public TaskHandler getTaskHandler() {
        return new MessageTaskHandler();
    }
}
