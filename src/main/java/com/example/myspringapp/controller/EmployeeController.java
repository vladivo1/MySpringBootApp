package com.example.myspringapp.controller;

import com.example.myspringapp.domain.Employee;
import com.example.myspringapp.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }


    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllUsers() {
        return employeeService.getAllUsers();
    }


    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Employee> getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/users/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeeByName(@PathVariable String name) {
        return employeeService.findAllByName(name);
    }

    @GetMapping("/users/country/{country}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeeByCountry(@PathVariable String country) {
        return employeeService.findAllByCountry(country);
    }

    @GetMapping("/users/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeeByEmail(@PathVariable String email) {
        return employeeService.findAllByEmail(email);
    }


    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee refreshEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        return employeeService.refreshEmployee(id, employee);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEmployeeById(@PathVariable Integer id) {
        employeeService.removeEmployeeById(id);

    }

    @DeleteMapping("/users")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllUsers() {
        employeeService.removeAllUsers();
    }
}
