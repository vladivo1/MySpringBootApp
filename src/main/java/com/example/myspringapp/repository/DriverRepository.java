package com.example.myspringapp.repository;

import com.example.myspringapp.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver,Integer> {

    List<Driver> getAllDriversByFirstName (String firstName);

    List<Driver> getAllDriversByLastName (String lasName);

    List<Driver> getAllDriversByCategory (String category);

    List<Driver> getAllDriversByDriverExp (String driverExp);

}
