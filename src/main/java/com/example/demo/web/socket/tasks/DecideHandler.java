package com.example.demo.web.socket.tasks;

import com.example.demo.web.socket.exception.UnsupportedTaskException;
import com.example.demo.web.socket.handlers.SocketMessageContainer;
import com.example.demo.web.socket.tasks.taskfactory.*;

public class DecideHandler {

    public static TaskFactory decideTask(SocketMessageContainer container) throws UnsupportedTaskException {
        return switch (container.getTask()) {
            case "Message" -> new MessageTaskFactory();
            case "CheckModem" -> new CheckModemTaskFactory();
            case "UpdateProvider" -> new UpdateProviderTaskFactory();
            case "SetStationaryModems" -> new SetStationaryModemsTaskFactory();
            case "UpdateModem" -> new UpdateModemTaskFactory();
            case "UpdatePort" -> new UpdatePortTaskFactory();
            case "StartProvider" -> new StartProviderTaskFactory();
            case "StopProvider" -> new StopProviderTaskFactory();
            case "StartSaveModems" -> new StartSaveModemsTaskFactory();
            case "SavedModems" -> new SaveModemsTaskFactory();
            case "AddModems" -> new AddModemsTaskFactory();
            case "DisconnectModems" -> new DisconnectModemsTaskFactory();
            default -> throw new UnsupportedTaskException("Can't find such task: " + container.getTask());
        };
    }
}
