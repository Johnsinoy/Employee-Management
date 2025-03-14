package com.EmployeeManagement.Employee_Management_System.repository;

import com.EmployeeManagement.Employee_Management_System.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
