package com.example.demo;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class Login_As_Employee_Controller {

    @Autowired
    private EmployeeRepository2 employeerepository;

    @GetMapping("/loginE")
    public void addEmp(@RequestParam("id") Integer id,@RequestParam("username") String username,
    		@RequestParam("password") String password,
                       HttpServletResponse response) {
        Empe e = employeerepository.findById(id).orElse(null);
        PrintWriter out;
        try {
            out = response.getWriter();
            if (e != null && e.getUsername().equals(username) && e.getPassword().equals(password)) {
                out.println("<html><head>");
                out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">");
                out.println("</head><body style=\"background: linear-gradient(to bottom right, #ffafbd, #ffc3a0);\">");
                out.println("<div class=\"container d-flex justify-content-center align-items-center vh-100\">");
                out.println("<div class=\"card bg-gradient w-50\">");
                out.println("<div class=\"card-body text-center\">");
                out.println("<h2 class=\"card-title\">Welcome "+e.getUsername()+"!</h2>");
                out.println("<p class=\"card-text\">ID: " + e.getId() + "</p>");
                out.println("<p class=\"card-text\">Username: " + e.getUsername() + "</p>");
                out.println("<p class=\"card-text\">Age: " + e.getAge() + "</p>");
                out.println("<p class=\"card-text\">Salary: " + e.getSal() + "</p>");
                out.println("</div></div></div></body></html>");
            } else {
                out.println("<html><head>");
                out.println("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>");
                out.println("</head><body style=\"background: linear-gradient(to bottom right,#2193b0, #6dd5ed);\">");
                out.println("<script>");
                out.println("alert('Invalid Credentials Enter data carefully.');");
                out.println("window.history.back();");
                out.println("window.location.reload();");
                out.println("</script></body></html>");
            }
        } catch (Exception ioException) {
        }
    }
}
