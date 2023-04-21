package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ProviderApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ProviderApplication.class.getResource("Authentication.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Provider");
        stage.setScene(scene);
        stage.show();
    }
}