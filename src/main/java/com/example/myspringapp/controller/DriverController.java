package com.example.myspringapp.controller;

import com.example.myspringapp.domain.Driver;
import com.example.myspringapp.repository.DriverRepository;
import com.example.myspringapp.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverController {

    private DriverRepository driverRepository;
    private DriverService driverService;
    public DriverController (DriverRepository driverRepository, DriverService driverService) {
        this.driverRepository = driverRepository;
        this.driverService = driverService;
    }


    @PostMapping("/saveDriver")
    @ResponseStatus(HttpStatus.CREATED)
    public Driver saveDriver (@RequestBody Driver driver) {
        return driverRepository.save(driver);
    }

    @GetMapping("/getAllDrivers")
    @ResponseStatus(HttpStatus.OK)
    public List<Driver> getAllDrivers () {
        return driverRepository.findAll();
    }

    @GetMapping("/getDriverById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Driver getDriverById (@PathVariable Integer id) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Driver not found with id " + id));
        return driver;
    }

    @GetMapping("/getDriverByName/{firstName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Driver> getDriverByName( @PathVariable String firstName) {
        return driverService.getAllDriversByFirstName(firstName);
    }

    @GetMapping("/getDriverByLastName/{lastName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Driver> getDriverByLastName( @PathVariable String lastName) {
        return driverService.getAllDriversByLastName(lastName);
    }
    @GetMapping("/getDriverByCategory/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<Driver> getDriverByCategory( @PathVariable String category) {
        return driverService.getAllDriversByCategory(category);
    }
    @GetMapping("/getDriverByDriversExp/{driverExp}")
    @ResponseStatus(HttpStatus.OK)
    public List<Driver> getDriverByDriverExp( @PathVariable String driverExp) {
        return driverService.getAllDriversByDriverExp(driverExp);
    }

    @PutMapping("/updateDriverById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Driver updateDriver (@PathVariable ("id") Integer id, @RequestBody Driver driver) {
        return driverRepository.findById(id)
                .map(entity ->{
                    entity.setFirstName(driver.getFirstName());
                    entity.setLastName(driver.getLastName());
                    entity.setCategory(driver.getCategory());
                    entity.setDriverExp(driver.getDriverExp());
                    return driverRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Driver not found with id = " + id));
    }

    @DeleteMapping("/deleteDriverById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeDriverById (@PathVariable Integer id) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Driver not found with id " + id));
        driverRepository.delete(driver);

    }
    @DeleteMapping("/deleteAllDrivers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllDrivers() {
        driverRepository.deleteAll();
    }

}
