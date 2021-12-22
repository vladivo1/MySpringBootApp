package com.example.myspringapp.repository;

import com.example.myspringapp.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver,Integer> {

    public List<Driver> getAllDriversByFirstName (String firstName);

    public List<Driver> getAllDriversByLastName (String lasName);

    public List<Driver> getAllDriversByCategory (String category);

    public List<Driver> getAllDriversByDriverExp (String driverExp);

}
