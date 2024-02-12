package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/add")
    public String addEmp(@RequestParam("id") int id,
                         @RequestParam("username") String username,
                         @RequestParam("age") int age,
                         @RequestParam("sal") int sal,
                         @RequestParam("password") String password) {
        try {
            employeeService.addEmployee(id, username, age, sal, password);
            return "<html><head>" +
                   "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>" +
                   "</head><body style=\"background: linear-gradient(to bottom right,#2193b0, #6dd5ed);\">" +
                   "<script>" +
                   "alert('Employee Added Successfully!');" +
                   "window.location.reload();" +
                   "window.history.back();" +
                   "</script></body></html>";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
