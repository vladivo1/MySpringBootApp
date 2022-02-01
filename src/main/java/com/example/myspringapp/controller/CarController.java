package com.example.myspringapp.controller;

import com.example.myspringapp.domain.Car;
import com.example.myspringapp.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public Car saveCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/car/id/{car_id}")
    @ResponseStatus(HttpStatus.OK)
    public Car getCarById(@PathVariable Integer car_id) {
        return carService.getCarById(car_id);
    }

    @GetMapping("/cars/model/{model}")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getAllCarsByModel(@PathVariable String model) {
        return carService.getCarByModel(model);
    }

    @GetMapping("/cars/brand/{brand}")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getAllCarsByBrand(@PathVariable String brand) {
        return carService.getCarByBrand(brand);
    }

    @GetMapping("/cars/type/{type}")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getAllCarsByType(@PathVariable String type) {
        return carService.getCarByType(type);
    }

    @PutMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Car updateCar(@PathVariable("id") Integer id, @RequestBody Car car) {
        return carService.updateCar(id, car);
    }

    @DeleteMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarById(@PathVariable Integer id) {
        carService.deleteCarById(id);
    }

    @DeleteMapping("/cars")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllCities() {
        carService.deleteAllCars();
    }

}
