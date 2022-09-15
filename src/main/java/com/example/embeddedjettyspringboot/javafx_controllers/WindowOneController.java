package com.example.embeddedjettyspringboot.javafx_controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class WindowOneController implements Initializable {
    @FXML
    private WebView windowOne;

    private String link = getClass().getResource("/static/window_one.html").toExternalForm();
    private WebEngine engine;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        engine = windowOne.getEngine();
        engine.setJavaScriptEnabled(true);
        engine.load(link);
    }
}
