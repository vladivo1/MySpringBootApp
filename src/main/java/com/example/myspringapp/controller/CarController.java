package com.example.myspringapp.controller;

import com.example.myspringapp.domain.Car;
import com.example.myspringapp.repository.CarRepository;
import com.example.myspringapp.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {

    private final CarService carService;
    private final CarRepository carRepository;
    public CarController (CarService carService, CarRepository carRepository){
        this.carService = carService;
        this.carRepository = carRepository;

    }

    @PostMapping("/saveCar")
    @ResponseStatus(HttpStatus.CREATED)
    public Car saveCar(@RequestBody Car car){
        return carRepository.save(car);
    }

    @GetMapping("/getAllCars")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/getCarById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Car getCarById(@PathVariable Integer id){
        return carRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Car not found with id " + id));
    }
    @GetMapping("/getCarsByModel/{model}")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getAllCarsByModel (@PathVariable String model){
       return carService.getCarByModel(model);
    }
    @GetMapping("/getCarsByBrand/{brand}")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getAllCarsByBrand(@PathVariable String brand) {
        return carService.getCarByBrand(brand);
    }
    @GetMapping("/getCarsByType/{type}")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getAllCarsByType(@PathVariable String type) {
        return carService.getCarByType(type);
    }

    @PutMapping("/updateCarById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Car updateCar(@PathVariable ("id") Integer id, @RequestBody Car car) {
       return carRepository.findById(id)
               .map(entity ->{
               entity.setBrand(car.getBrand());
               entity.setModel(car.getModel());
               entity.setType(car.getType());
               return carRepository.save(entity);
               })
               .orElseThrow(() -> new EntityNotFoundException("Car not found with id = " + id));
    }

    @DeleteMapping("/deleteCarById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarById (@PathVariable Integer id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car not found with id " + id));
        carRepository.delete(car);

    }

    @DeleteMapping("/deleteAllCars")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllCities() {
        carRepository.deleteAll();


    }

}
