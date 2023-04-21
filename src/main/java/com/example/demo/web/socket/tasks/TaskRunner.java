package com.example.demo.web.socket.tasks;

import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.socket.WebSocketClient;
import com.example.demo.web.socket.tasks.handler.TaskHandler;
import com.example.demo.web.socket.tasks.runnable.RunnableTask;
import com.example.demo.web.socket.tasks.taskfactory.TaskFactory;

public class TaskRunner{
    private final RunnableTask runnableTask;
    private final TaskHandler taskHandler;

    public TaskRunner(TaskFactory taskFactory) {
        this.runnableTask = taskFactory.getRunnableTask();
        this.taskHandler = taskFactory.getTaskHandler();
    }

    public void run(ModemProviderState modemProviderState, String jsonString, WebSocketClient socketClient) {
        if (taskHandler.checkIfAvailable(modemProviderState, socketClient, jsonString)) {
            taskHandler.safeBeforeStart(modemProviderState, socketClient, jsonString);
            RunnableTaskImpl task = new RunnableTaskImpl(runnableTask, modemProviderState, jsonString, socketClient);
            Thread thread = new Thread(task);
            thread.start();
        } else {
            taskHandler.abort(modemProviderState, socketClient, jsonString);
        }
    }
}
