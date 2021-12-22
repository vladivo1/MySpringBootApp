package com.example.myspringapp.controller;


import com.example.myspringapp.domain.Employee;
import com.example.myspringapp.repository.EmployeeRepository;
import com.example.myspringapp.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;
    public EmployeeController (EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }


    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllUsers() {
        return employeeRepository.findAll();
    }


    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable Integer id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
        return employee;
    }

    @GetMapping("/usersByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List <Employee> getEmployeeByName(@PathVariable String name) {
        return employeeService.findAllByName(name);
    }

    @GetMapping("/usersByCountry/{country}")
    @ResponseStatus(HttpStatus.OK)
    public List <Employee> getEmployeeByCountry(@PathVariable String country) {
        return employeeService.findAllByCountry(country);
    }

    @GetMapping("/usersByEmail/{email}")
    @ResponseStatus(HttpStatus.OK)
    public List <Employee> getEmployeeByEmail(@PathVariable String email) {
        return employeeService.findAllByEmail(email);
    }


    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee refreshEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {

        return employeeRepository.findById(id)
                .map(entity -> {
                    entity.setName(employee.getName());
                    entity.setEmail(employee.getEmail());
                    entity.setCountry(employee.getCountry());
                    return employeeRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEmployeeById(@PathVariable Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
        employeeRepository.delete(employee);
    }

    @DeleteMapping("/users")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllUsers() {
        employeeRepository.deleteAll();
    }
}
