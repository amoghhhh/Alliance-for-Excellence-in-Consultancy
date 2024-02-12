package com.example.demo;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class Login_As_Admin_Controller {

    @Autowired
    private EmployeeRepository employeerepository;

    @GetMapping("/loginA")
    public void addEmp(@RequestParam("id") Integer id,
                       @RequestParam("username") String username,
                       @RequestParam("password") String password,
                       HttpServletResponse response) {
        Emp e = employeerepository.findById(id).orElse(null);
        PrintWriter out;
        if (e != null && e.getUsername().equals(username) && e.getPassword().equals(password)) {
            try {
            	out = response.getWriter();
                response.sendRedirect("/list.html");
            } catch (Exception ex) {
                // Handle redirect exception
            }
        } else {
            try {
            	out = response.getWriter();
            	out.println("<html><head>");
                out.println("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>");
                out.println("</head><body style=\"background: linear-gradient(to bottom right,#2193b0, #6dd5ed);\">");
                out.println("<script>");
                out.println("alert('Invalid Credentials Enter data carefully.');");
                out.println("window.history.back();");
                out.println("window.location.reload();");
                out.println("</script></body></html>");
            } catch (Exception ex) {
            }
        }
    }
}
