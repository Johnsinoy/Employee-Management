package com.EmployeeManagement.Employee_Management_System.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Designation is required")
    private String designation;

    @NotNull
    private Double salary;

    @NotBlank(message = "Employment type is required")
    private String employmentType;  //  Restrict to one employment type

    @ElementCollection
    private List<String> departments;  // Multiple departments allowed

    // Getters and Setters
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public String getEmploymentType() { return employmentType; }
    public void setEmploymentType(String employmentType) {
        if (employmentType == null || employmentType.trim().isEmpty()) {
            throw new IllegalArgumentException("Employment type cannot be empty");
        }
        this.employmentType = employmentType;
    }

    public List<String> getDepartments() { return departments; }
    public void setDepartments(List<String> departments) { this.departments = departments; }
}

