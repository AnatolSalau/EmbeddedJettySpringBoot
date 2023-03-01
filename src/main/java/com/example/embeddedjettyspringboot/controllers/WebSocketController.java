package com.example.embeddedjettyspringboot.controllers;

import com.example.embeddedjettyspringboot.EmbeddedJettySpringBootApplication;
import javafx.application.Platform;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/pingpong")
public class WebSocketController {
    @GetMapping
    public ModelAndView pingpong() {
        ModelAndView modelAndView = new ModelAndView("pingpong.html");
        System.out.println("Hello from WebSocketController");

        EmbeddedJettySpringBootApplication  embeddedJettySpringBootApplication =
              new EmbeddedJettySpringBootApplication();

        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        try {
            Platform.exit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
