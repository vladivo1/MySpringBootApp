package com.example.myspringapp.service;

import com.example.myspringapp.domain.Employee;
import com.example.myspringapp.domain.Smartphone;
import com.example.myspringapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    public EmployeeService (EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAllByName(String name) {
        return employeeRepository.findAllByName(name);
    }

    public List<Employee> findAllByCountry(String country){
        return employeeRepository.findAllByCountry(country);
    }

    public List<Employee> findAllByEmail(String email) {
        return employeeRepository.findAllByEmail(email);
    }
}
