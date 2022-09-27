package com.example.embeddedjettyspringboot;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class EmbeddedJettySpringBootApplication extends Application {
    //Application context
    private ConfigurableApplicationContext configurableApplicationContext;
    //JavaFx window one root
    private Parent windowOneRoot;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        //Run Spring context
        configurableApplicationContext = SpringApplication.run(EmbeddedJettySpringBootApplication.class);
        //Get fxml
        FXMLLoader windowOneFXML = new FXMLLoader(getClass().getResource("/fxml/window_one.fxml"));
        //load JavaFX controllers which load like beans from context
        windowOneFXML.setControllerFactory(configurableApplicationContext::getBean);

        //We must run desktope window root in new thread becouse if we don't make it -> we get JavaFx thread error
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
