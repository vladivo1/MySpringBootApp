package com.example.myspringapp.repository;

import com.example.myspringapp.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    List<Employee> findAllByName(String name);

    List<Employee> findAllByCountry(String country);

    List<Employee> findAllByEmail(String email);
}
