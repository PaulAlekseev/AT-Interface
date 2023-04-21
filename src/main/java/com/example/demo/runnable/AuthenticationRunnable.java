package com.example.demo.runnable;

import com.example.demo.controller.AuthenticationController;
import com.example.demo.entities.authentication.JwtTokenProvider;
import com.example.demo.web.socket.ProviderSocketApplication;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import lombok.Getter;
import lombok.Setter;
import okhttp3.OkHttpClient;

public class AuthenticationRunnable implements Runnable {
    private final String login;
    private final String password;
    private boolean running;

    @Setter
    private Button button;
    @Setter
    private ActionEvent event;
    @Getter
    private final boolean success = false;

    public AuthenticationRunnable(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public void run() {
        if (running) return;
        running = true;
        if (JwtTokenProvider.authenticate(login, password) != null) {
            ProviderSocketApplication application = new ProviderSocketApplication();
            application.run();
            AuthenticationController.changeToIndex(event);
        }
        System.out.println("Wrong password");
        button.setDisable(false);
        running = false;
    }


}
