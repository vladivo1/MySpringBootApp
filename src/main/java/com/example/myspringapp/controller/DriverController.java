package com.example.myspringapp.controller;

import com.example.myspringapp.domain.Driver;
import com.example.myspringapp.dto.DriverDto;
import com.example.myspringapp.mapper.DriverMapper;
import com.example.myspringapp.service.DriverService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Driver Controller", description = "The Driver API")
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverController {


    private final DriverService driverService;
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }


    @PostMapping("/drivers")
    public ResponseEntity<DriverDto> saveDriver(@RequestBody DriverDto driverDto) {
        Driver driver = DriverMapper.INSTANCE.driverDtoToDriver(driverDto);
         driverService.saveDriver(driver);
         return ResponseEntity.status(HttpStatus.CREATED).body(driverDto);
    }

    @GetMapping("/drivers")
    public ResponseEntity<List<DriverDto>> getAllDrivers() {
        List <DriverDto> driverDtoList = DriverMapper.INSTANCE.driverToDtos(driverService.getAllDrivers());
        return ResponseEntity.status(HttpStatus.OK).body(driverDtoList);
    }

    @GetMapping("/drivers/{id}")
    public ResponseEntity <DriverDto> getDriverById(@PathVariable Integer id) {
      DriverDto driverDto = DriverMapper.INSTANCE.driverToDto(driverService.getDriverById(id));
      return ResponseEntity.status(HttpStatus.OK).body(driverDto);
    }

    @GetMapping("/drivers/name/{firstName}")
    public ResponseEntity <List<DriverDto>> getDriverByName(@PathVariable String firstName) {
        List <DriverDto> driverDtoList =
                DriverMapper.INSTANCE.driverToDtos(driverService.getAllDriversByLastName(firstName));
        return ResponseEntity.status(HttpStatus.OK).body(driverDtoList);
    }

    @GetMapping("/drivers/lastname/{lastName}")
    public  ResponseEntity <List<DriverDto>> getDriverByLastName(@PathVariable String lastName) {
        List <DriverDto> driverDtoList =
                DriverMapper.INSTANCE.driverToDtos(driverService.getAllDriversByLastName(lastName));
        return ResponseEntity.status(HttpStatus.OK).body(driverDtoList);
    }

    @GetMapping("/drivers/category/{category}")
    public ResponseEntity <List<DriverDto>> getDriverByCategory(@PathVariable String category) {
       List <DriverDto> driverDtoList =
               DriverMapper.INSTANCE.driverToDtos(driverService.getAllDriversByCategory(category));
       return ResponseEntity.status(HttpStatus.OK).body(driverDtoList);
    }

    @GetMapping("/drivers/experience/{experience}")
    public  ResponseEntity <List<DriverDto>> getDriverByDriverExp(@PathVariable String experience) {
        List <DriverDto> driverDtoList =
                DriverMapper.INSTANCE.driverToDtos(driverService.getAllDriversByDriverExp(experience));
        return ResponseEntity.status(HttpStatus.OK).body(driverDtoList);
    }

    @PutMapping("/drivers/{id}")
    public ResponseEntity <DriverDto> updateDriver(@PathVariable("id") Integer id, @RequestBody Driver driver) {
        DriverDto driverDto = DriverMapper.INSTANCE.driverToDto(driverService.updateDriver(id, driver));
        return ResponseEntity.status(HttpStatus.OK).body(driverDto);
    }

    @DeleteMapping("/drivers/{id}")
    public ResponseEntity<String> removeDriverById(@PathVariable Integer id) {
        driverService.removeDriverById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Driver with id : " + id + " deleted");

    }

    @DeleteMapping("/drivers")
    public ResponseEntity<String> deleteAllDrivers() {
        driverService.deleteAllDrivers();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("All driver's deleted!");
    }

}
