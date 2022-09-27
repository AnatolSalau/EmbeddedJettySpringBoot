package com.example.embeddedjettyspringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pingpong")
public class WebSocketController {
    @GetMapping
    public ModelAndView pingpong() {
        ModelAndView modelAndView = new ModelAndView("pingpong.html");
        System.out.println("Hello from WebSocketController");
        return modelAndView;
    }
}
