package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("/message")
    public String addProject(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("details") String details
    ) {
        try {
            projectService.addMessage(name, email, details);
            return "<html><head>" +
                    "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>" +
                    "</head><body style=\"background: linear-gradient(to bottom right,#2193b0, #6dd5ed);\">" +
                    "<script>" +
                    "alert('Message Sent!');" +
                    "window.location.reload();" +
                    "window.history.back();" +
                    "</script></body></html>";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}