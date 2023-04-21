package com.example.demo.web.socket.tasks;

import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.socket.WebSocketClient;
import com.example.demo.web.socket.tasks.runnable.RunnableTask;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RunnableTaskImpl implements Runnable {
    private RunnableTask runnableTask;

    private ModemProviderState modemProviderState;
    private String jsonString;
    private WebSocketClient socketClient;

    @Override
    public void run() {
        runnableTask.run(modemProviderState, jsonString, socketClient);
    }
}
