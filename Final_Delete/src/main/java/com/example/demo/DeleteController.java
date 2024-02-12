package com.example.demo;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class DeleteController {
    @Autowired
    EmployeeRepository2 employeerepository;

    @GetMapping("/delete")
    public void delEmp(@RequestParam("id") int id, HttpServletResponse response) throws Exception {
        Empe e = employeerepository.findById(id).orElse(null);

        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>");
        out.println("</head><body style=\"background: linear-gradient(to bottom right,#2193b0, #6dd5ed);\">");
        out.println("<script>");

        if (e != null) {
            employeerepository.delete(e);
            out.println("alert('Data Deleted Successfully.');");
        } else {
            out.println("alert('Invalid ID. Data not found.');");
        }

        out.println("window.history.back();");
        out.println("window.location.reload();");
        out.println("</script></body></html>");
    }
}
