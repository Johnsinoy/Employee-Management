package com.EmployeeManagement.Employee_Management_System.controller;

import com.EmployeeManagement.Employee_Management_System.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.EmployeeManagement.Employee_Management_System.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController (EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("employee", new Employee());
        return "register";
    }
    @PostMapping("/register")
    public String registerEmployee(@Validated @ModelAttribute Employee employee, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "register";
        }
        employeeService.saveEmployee(employee);
        return "success";
    }
}
