package com.example.myspringapp.controller;

import com.example.myspringapp.domain.Employee;
import com.example.myspringapp.dto.EmployeeDto;
import com.example.myspringapp.mapper.EmployeeMapper;
import com.example.myspringapp.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/users")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.INSTANCE.employeeDtoToEmployee(employeeDto);
        employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDto);
    }

    @GetMapping("/users")
    public ResponseEntity <List<EmployeeDto>> getAllUsers() {
        List <EmployeeDto> employeeDtoList =
                EmployeeMapper.INSTANCE.employeeToDtos(employeeService.getAllUsers());
        return ResponseEntity.status(HttpStatus.OK).body(employeeDtoList);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity <EmployeeDto> getEmployeeById(@PathVariable Integer id) {
        EmployeeDto employeeDto = EmployeeMapper
                .INSTANCE.employeeToDto(employeeService.getEmployeeById(id));
        return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
    }

    @GetMapping("/users/name/{name}")
    public  ResponseEntity <List<EmployeeDto>> getEmployeeByName(@PathVariable String name) {
        List <EmployeeDto> employeeDtoList = EmployeeMapper
                .INSTANCE.employeeToDtos(employeeService.findAllByName(name));
        return ResponseEntity.status(HttpStatus.OK).body(employeeDtoList);
    }

    @GetMapping("/users/country/{country}")
    public ResponseEntity <List<EmployeeDto>> getEmployeeByCountry(@PathVariable String country) {
        List <EmployeeDto> employeeDtoList = EmployeeMapper
                .INSTANCE.employeeToDtos(employeeService.findAllByCountry(country));
        return ResponseEntity.status(HttpStatus.OK).body(employeeDtoList);
    }

    @GetMapping("/users/email/{email}")
    public  ResponseEntity <List<EmployeeDto>> getEmployeeByEmail(@PathVariable String email) {
        List <EmployeeDto> employeeDtoList = EmployeeMapper
                .INSTANCE.employeeToDtos(employeeService.findAllByEmail(email));
        return ResponseEntity.status(HttpStatus.OK).body(employeeDtoList);
    }

    @PutMapping("/users/{id}")
    public  ResponseEntity <EmployeeDto> refreshEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        EmployeeDto employeeDto = EmployeeMapper
                .INSTANCE.employeeToDto(employeeService.refreshEmployee(id, employee));
        return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> removeEmployeeById(@PathVariable Integer id) {
        employeeService.removeEmployeeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Employee with id : " + id + " deleted");
    }

    @DeleteMapping("/users")
    public ResponseEntity<String> removeAllUsers() {
        employeeService.removeAllUsers();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("All employee deleted");
    }
}
