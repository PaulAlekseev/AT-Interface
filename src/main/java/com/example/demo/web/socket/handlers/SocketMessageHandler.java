package com.example.demo.web.socket.handlers;

import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.socket.WebSocketClient;
import com.example.demo.web.socket.exception.UnsupportedTaskException;
import com.example.demo.web.socket.tasks.DecideHandler;
import com.example.demo.web.socket.tasks.TaskRunner;
import com.example.demo.web.socket.tasks.taskfactory.TaskFactory;

import java.text.ParseException;

public class SocketMessageHandler {

    private final SocketMessageParser socketMessageParser;

    public SocketMessageHandler() {
        this.socketMessageParser = new SocketMessageParser();
    }

    public void onMessage(ModemProviderState modemProviderState, String message, WebSocketClient socketClient)
            throws ParseException, UnsupportedTaskException {
        SocketMessageContainer container = socketMessageParser.parseMessage(message);
        TaskFactory taskFactory = DecideHandler.decideTask(container);
        if (taskFactory == null) return;
        TaskRunner taskRunner = new TaskRunner(taskFactory);
        taskRunner.run(modemProviderState, message, socketClient);
    }
}
