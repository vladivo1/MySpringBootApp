package com.example.myspringapp.service;

import com.example.myspringapp.domain.Driver;
import com.example.myspringapp.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private DriverRepository driverRepository;
    public DriverService (DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> getAllDriversByFirstName (String firstName){
        return driverRepository.getAllDriversByFirstName(firstName);
    }
    public List<Driver> getAllDriversByLastName (String lasName){
        return driverRepository.getAllDriversByLastName(lasName);
    }
    public List<Driver> getAllDriversByCategory (String category){
        return driverRepository.getAllDriversByCategory(category);
    }
    public List<Driver> getAllDriversByDriverExp (String driverExp){
        return driverRepository.getAllDriversByDriverExp(driverExp);
    }

}
