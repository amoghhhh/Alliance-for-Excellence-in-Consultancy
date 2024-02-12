package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository2 extends JpaRepository<Empe, Integer> {
    // You can add custom query methods here if needed
}
