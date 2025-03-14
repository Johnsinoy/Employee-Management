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

    @ElementCollection
    private List<String> employmentType;  // ✅ Store selected employment types

    @ElementCollection
    private List<String> departments;  // ✅ Store multiple department selections

    // Getters and Setters
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public List<String> getEmploymentType() { return employmentType; }
    public void setEmploymentType(List<String> employmentType) { this.employmentType = employmentType; }

    public List<String> getDepartments() { return departments; }
    public void setDepartments(List<String> departments) { this.departments = departments; }
}

