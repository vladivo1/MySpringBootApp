package com.example.myspringapp.controller;

import com.example.myspringapp.domain.Driver;
import com.example.myspringapp.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverController {


    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }


    @PostMapping("/drivers")
    @ResponseStatus(HttpStatus.CREATED)
    public Driver saveDriver(@RequestBody Driver driver) {
        return driverService.saveDriver(driver);
    }

    @GetMapping("/drivers")
    @ResponseStatus(HttpStatus.OK)
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/drivers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Driver getDriverById(@PathVariable Integer id) {
        return driverService.getDriverById(id);
    }

    @GetMapping("/drivers/name/{firstName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Driver> getDriverByName(@PathVariable String firstName) {
        return driverService.getAllDriversByFirstName(firstName);
    }

    @GetMapping("/drivers/lastname/{lastName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Driver> getDriverByLastName(@PathVariable String lastName) {
        return driverService.getAllDriversByLastName(lastName);
    }

    @GetMapping("/drivers/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<Driver> getDriverByCategory(@PathVariable String category) {
        return driverService.getAllDriversByCategory(category);
    }

    @GetMapping("/drivers/experience/{experience}")
    @ResponseStatus(HttpStatus.OK)
    public List<Driver> getDriverByDriverExp(@PathVariable String experience) {
        return driverService.getAllDriversByDriverExp(experience);
    }

    @PutMapping("/drivers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Driver updateDriver(@PathVariable("id") Integer id, @RequestBody Driver driver) {
        return driverService.updateDriver(id, driver);
    }

    @DeleteMapping("/drivers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeDriverById(@PathVariable Integer id) {
        driverService.removeDriverById(id);

    }

    @DeleteMapping("/drivers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllDrivers() {
        driverService.deleteAllDrivers();
    }

}
