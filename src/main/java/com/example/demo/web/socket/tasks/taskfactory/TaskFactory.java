package com.example.demo.web.socket.tasks.taskfactory;

import com.example.demo.web.socket.tasks.handler.TaskHandler;
import com.example.demo.web.socket.tasks.runnable.RunnableTask;

public interface TaskFactory {
    RunnableTask getRunnableTask();
    TaskHandler getTaskHandler();
}
