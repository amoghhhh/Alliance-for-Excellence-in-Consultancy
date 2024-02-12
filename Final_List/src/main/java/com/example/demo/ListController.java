package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ListController {

    private final EmployeeRepository2 employeerepository;

    public ListController(EmployeeRepository2 employeerepository) {
        this.employeerepository = employeerepository;
    }

    @GetMapping("/list")
    public String listEmployees() {
        List<Empe> employees = employeerepository.findAll();
        
        StringBuilder html = new StringBuilder();
        
        html.append("<html><head>");
        html.append("<link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">");
        html.append("</head><body style=\"background: linear-gradient(to bottom right,#2193b0, #6dd5ed);\">");
        html.append("<div class=\"card\" style=\"width: 70%; margin: 50px auto;\">");
        html.append("<div class=\"card-header d-flex justify-content-between align-items-center\">");
        html.append("<div><a href=\"front.html\"><img src=\"logo.png\" alt=\"Company Logo\" height=\"50\"></a></div>");
        html.append("<h1 class=\"m-0\">Alliance for Excellence in Consultancy</h1>");
        html.append("</div>");
        html.append("<div class=\"card-body\">");
        html.append("<table class=\"table\">");
        html.append("<thead class=\"thead-light\"><tr><th>ID</th><th>Username</th><th>Age</th><th>Salary</th><th>Password</th></tr></thead>");
        html.append("<tbody>");
        
        for (Empe employee : employees) {
            html.append("<tr>");
            html.append("<td>").append(employee.getId()).append("</td>");
            html.append("<td>").append(employee.getUsername()).append("</td>");
            html.append("<td>").append(employee.getAge()).append("</td>");
            html.append("<td>").append(employee.getSal()).append("</td>");
            html.append("<td>").append(employee.getPassword()).append("</td>");
            html.append("</tr>");
        }
        
        html.append("</tbody>");
        html.append("</table>");
        html.append("</div></div>");
        html.append("</body></html>");
        
        return html.toString();
    }
}
