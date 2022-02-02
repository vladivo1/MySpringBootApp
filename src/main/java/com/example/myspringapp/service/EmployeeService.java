package com.example.myspringapp.service;

import com.example.myspringapp.domain.Employee;
import com.example.myspringapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    public EmployeeService (EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllUsers() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) {
       return employeeRepository.findById(id)
               .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
    }

    public Employee refreshEmployee(Integer id, Employee employee) {
        return employeeRepository.findById(id)
                .map(entity -> {
                    entity.setName(employee.getName());
                    entity.setEmail(employee.getEmail());
                    entity.setCountry(employee.getCountry());
                    return employeeRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
    }

    public void removeEmployeeById(Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
        employeeRepository.delete(employee);
    }

    public void removeAllUsers() {
        employeeRepository.deleteAll();
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
