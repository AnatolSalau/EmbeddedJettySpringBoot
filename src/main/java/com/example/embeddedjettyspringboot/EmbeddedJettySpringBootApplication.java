package com.example.embeddedjettyspringboot;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationShutdownHandlers;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class EmbeddedJettySpringBootApplication extends Application {
    private ConfigurableApplicationContext configurableApplicationContext;
    private Parent windowOneRoot;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        configurableApplicationContext = SpringApplication.run(EmbeddedJettySpringBootApplication.class);
        FXMLLoader windowOneFXML = new FXMLLoader(getClass().getResource("/fxml/window_one.fxml"));
        windowOneFXML.setControllerFactory(configurableApplicationContext::getBean);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    windowOneRoot = windowOneFXML.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World!");

        primaryStage.setScene(new Scene(windowOneRoot, 600, 400));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        //Stop spring boot application
                configurableApplicationContext.close();
    }
}
