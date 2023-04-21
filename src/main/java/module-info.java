module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires com.google.gson;
    requires lombok;
    requires jssc;
    requires jetty.websocket.api;

    opens com.example.demo to javafx.fxml, com.google.gson;
    opens com.example.demo.entities.authentication to com.google.gson;
    opens com.example.demo.entities.modem to com.google.gson;
    opens com.example.demo.entities.task to com.google.gson;
    opens com.example.demo.web.socket.tasks.containers.out to com.google.gson;
    opens com.example.demo.web.socket.tasks.containers.in to com.google.gson;
    opens com.example.demo.web.modem.states to com.google.gson;
    exports com.example.demo;
    exports com.example.demo.controller;
    exports com.example.demo.web.socket;
    exports com.example.demo.runnable;
    opens com.example.demo.runnable to com.google.gson, javafx.fxml;
    opens com.example.demo.web.socket to com.google.gson, javafx.fxml;
    exports com.example.demo.service;
    opens com.example.demo.service to com.google.gson, javafx.fxml;
    opens com.example.demo.controller to com.google.gson, javafx.fxml;
}