package com.example.embeddedjettyspringboot;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationShutdownHandlers;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EmbeddedJettySpringBootApplication extends Application {
    private ConfigurableApplicationContext configurableApplicationContext;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        configurableApplicationContext = SpringApplication.run(EmbeddedJettySpringBootApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        //Stop spring boot application
                configurableApplicationContext.close();
    }
}
