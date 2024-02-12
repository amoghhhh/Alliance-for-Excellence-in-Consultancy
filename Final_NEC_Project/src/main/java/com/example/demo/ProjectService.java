package com.example.demo;

import java.sql.Date;

import org.springframework.stereotype.Service;

@Service
public class ProjectService {
	long timestamp = System.currentTimeMillis();
	Date date = new Date(timestamp);

    private final EmployeeRepository3 projectRepository;

    public ProjectService(EmployeeRepository3 projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void addMessage(String name, String email, String details) {
        Project p = new Project(name, email, details, date);
        projectRepository.save(p);
    }
}
