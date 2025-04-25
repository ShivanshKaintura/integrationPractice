package com.sk.dev.Controller;

import com.sk.dev.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/hello")
    public String hello(Model model) {
        emailService.sendSimpleEmail(
                "kainturashi@gmail.com",
                "API Triggered",
                "Hey! Your API endpoint was just hit."
        );
        model.addAttribute("message", "Hello World");
        return "hello"; // This will look for a template called 'hello.html' under resources/templates.
    }
}