package com.crm.controller;

import com.crm.entity.Employee;
import com.crm.payload.EmployeeDto;
import com.crm.service.EmployeeService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private  EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService =employeeService;
    }
    //create method to add employee
    @PostMapping("/add")
    public String addEmployee(
            @RequestBody Employee employee
    ) {
        employeeService.addEmployee(employee);
        return "data added successfully";
    }
//http://localhost:8080/api/employee?id=1
    @DeleteMapping
    public String deleteEmployee(@RequestParam Long id) {
        employeeService.deleteById(id);
        return "data deleted successfully";
    }

    @PutMapping
    public String updateEmployee(
            @RequestParam Long id,
            @RequestBody EmployeeDto dto

    ) {
        employeeService.UpdateEmployee(id, dto);
        return "data updated successfully";
    }

    @GetMapping
    public List<Employee> getEmployee() {
       List<Employee> employees=employeeService.getEmployee();
       return employees;
    }
}
