package com.example.demo.controller;

import com.example.demo.runnable.AuthenticationRunnable;
import com.example.demo.ProviderApplication;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthenticationController {
    @FXML
    private Button button;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    public static void changeToIndex(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(ProviderApplication.class.getResource("Index.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            stage.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onAuthenticateButtonClick(ActionEvent event) {
        button.setDisable(true);
        AuthenticationRunnable runnableThing = new AuthenticationRunnable(loginField.getText(), passwordField.getText());
        runnableThing.setButton(button);
        runnableThing.setEvent(event);
        Platform.runLater(runnableThing);
    }
}