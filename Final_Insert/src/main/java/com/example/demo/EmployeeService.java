package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository2 employeerepository;

    public void addEmployee(int id, String username, int age, int sal, String password){
        Empe e = new Empe(id, username, age, sal, password);
        employeerepository.save(e);
    }
}
