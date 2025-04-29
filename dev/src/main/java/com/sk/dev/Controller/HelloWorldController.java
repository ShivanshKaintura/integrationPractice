package com.sk.dev.Controller;

import com.sk.dev.Service.EmailService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/hello")
    public String hello(Model model, HttpServletRequest request) {

        // Extract the email address from the 'X-User-Email' header
        String fromEmail = "";

        String clientIp = request.getRemoteAddr();

        if ("0:0:0:0:0:0:0:1".equals(clientIp)) {
            clientIp = "127.0.0.1"; // Replace with a standard IPv4 loopback address
        }
        fromEmail = "user-" + clientIp.replace(".", "-") + "@gmail.com";
        if (fromEmail == null || fromEmail.isEmpty()) {
            fromEmail = "kainturashi@gmail.com";
        }
        emailService.sendSimpleEmail(
                fromEmail,
                "API Triggered",
                "Hey! Your API endpoint was just hit."
        );
        model.addAttribute("message", "Hello World");
        return "hello"; // This will look for a template called 'hello.html' under resources/templates.
    }
}