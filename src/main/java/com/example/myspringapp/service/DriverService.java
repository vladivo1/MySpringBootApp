package com.example.myspringapp.service;

import com.example.myspringapp.domain.Driver;
import com.example.myspringapp.repository.DriverRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver getDriverById(Integer id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Driver not found with id " + id));
    }

    public Driver updateDriver(Integer id, Driver driver) {
        return driverRepository.findById(id)
                .map(entity -> {
                    entity.setFirstName(driver.getFirstName());
                    entity.setLastName(driver.getLastName());
                    entity.setCategory(driver.getCategory());
                    entity.setDriverExp(driver.getDriverExp());
                    return driverRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Driver not found with id = " + id));
    }

    public void removeDriverById(Integer id) {
        driverRepository.deleteById(id);

    }

    public void deleteAllDrivers() {
        driverRepository.deleteAll();
    }

    public List<Driver> getAllDriversByFirstName(String firstName) {
        return driverRepository.getAllDriversByFirstName(firstName);
    }

    public List<Driver> getAllDriversByLastName(String lasName) {
        return driverRepository.getAllDriversByLastName(lasName);
    }

    public List<Driver> getAllDriversByCategory(String category) {
        return driverRepository.getAllDriversByCategory(category);
    }

    public List<Driver> getAllDriversByDriverExp(String driverExp) {
        return driverRepository.getAllDriversByDriverExp(driverExp);
    }

}
