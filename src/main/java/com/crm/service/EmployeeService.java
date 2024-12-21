package com.crm.service;

import com.crm.entity.Employee;
import com.crm.payload.EmployeeDto;
import com.crm.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private  EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
        public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
        }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    public void UpdateEmployee(Long id, EmployeeDto dto) {


       Optional<Employee> opEmp = employeeRepository.findById(id);
       Employee employee = opEmp.get();

            employee.setName(dto.getName());
            employee.setEmailId(dto.getEmailId());
            employee.setMobile(dto.getMobile());
            employeeRepository.save(employee);

    }

    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }
}

