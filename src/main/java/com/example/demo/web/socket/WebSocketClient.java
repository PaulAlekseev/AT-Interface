package com.example.demo.web.socket;

import com.example.demo.web.modem.states.ModemProviderState;
import com.example.demo.web.socket.handlers.SocketMessageHandler;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;

@ClientEndpoint(configurator = Config.class)
public class WebSocketClient {
    private final String server_url;
    private Session session;
    private ModemProviderState modemProviderState;

    public WebSocketClient(String server_url) {
        this.server_url = server_url;
    }

    public void start() {
        try {
            modemProviderState = new ModemProviderState(this);
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, new URI(server_url));
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Connected to server");
        this.session = session;
        this.session.setMaxIdleTimeout(0);
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("Disconnected from server: " + closeReason);
        this.session = null;
    }

    @OnMessage
    public void onMessage(String message) {
        SocketMessageHandler socketMessageHandler = new SocketMessageHandler();
        try {
            socketMessageHandler.onMessage(modemProviderState, message, this);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void sendMessage(String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String taskOutKeyword, String jsonOutContainer) {
        sendMessage(taskOutKeyword + ":" + jsonOutContainer);
    }

    public void stop() {
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ModemProviderState getModemProviderState() {
        return modemProviderState;
    }

    public void setModemProviderState(ModemProviderState modemProviderState) {
        this.modemProviderState = modemProviderState;
    }
}