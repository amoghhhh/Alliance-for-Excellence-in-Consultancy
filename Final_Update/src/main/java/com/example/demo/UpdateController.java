package com.example.demo;

import java.io.PrintWriter;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateController {
    @Autowired
    private EmployeeRepository2 employeerepository;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/update")
    public void Update(@RequestParam("id") int id, @RequestParam("username") String username,
                       @RequestParam("age") int age, @RequestParam("sal") int sal,
                       @RequestParam("password") String password, HttpServletResponse response) throws Exception {
        Empe e = employeerepository.findById(id).orElse(null);

        if (e != null) {
            e.setUsername(username);
            e.setAge(age);
            e.setSal(sal);
            e.setPassword(password);
            employeerepository.save(e);

            PrintWriter out = response.getWriter();
            out.println("<html><head>");
            out.println("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>");
            out.println("</head><body style=\"background: linear-gradient(to bottom right,#2193b0, #6dd5ed);\">");
            out.println("<script>");
            out.println("alert('Data Updated successfully.');");
            out.println("window.history.back();");
            out.println("window.location.reload();");
            out.println("</script></body></html>");
        } else {
            employeeService.addEmployee(id, username, age, sal, password);
            PrintWriter out = response.getWriter();
            out.println("<html><head>");
            out.println("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>");
            out.println("</head><body style=\"background: linear-gradient(to bottom right,#2193b0, #6dd5ed);\">");
            out.println("<script>");
            out.println("alert('Employee Added Successfully.');");
            out.println("window.history.back();");
            out.println("window.location.reload();");
            out.println("</script></body></html>");
        }
    }
}