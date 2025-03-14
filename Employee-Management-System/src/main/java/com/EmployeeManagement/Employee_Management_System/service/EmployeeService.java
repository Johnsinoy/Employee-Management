package com.EmployeeManagement.Employee_Management_System.service;

import com.EmployeeManagement.Employee_Management_System.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.EmployeeManagement.Employee_Management_System.repository.EmployeeRepository;

import java.util.Map;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    private static final Map<String, Double> salaryMap = Map.of(
            "Manager", 90000.0,
            "Software Engineer", 70000.0,
            "HR", 60000.0,
            "Intern", 30000.0
    );

    public Employee saveEmployee(Employee employee) {
        employee.setSalary(salaryMap.getOrDefault(employee.getDesignation(), 50000.0));
        return employeeRepository.save(employee);
    }
}
