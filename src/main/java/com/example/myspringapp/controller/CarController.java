package com.example.myspringapp.controller;

import com.example.myspringapp.domain.Car;
import com.example.myspringapp.dto.CarDto;
import com.example.myspringapp.service.CarService;
import com.example.myspringapp.mapper.CarMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Car Controller", description = "The Car API")
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {

    private final CarService carService;
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/cars")
    public ResponseEntity<CarDto> saveCar(@RequestBody CarDto carDto) {
        Car car = CarMapper.INSTANCE.CarDtoToCar(carDto);
        carService.saveCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(carDto);
    }

    @Operation(summary = "Get all cars")
    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getAllCars() {
       List<CarDto>  carDtoList = CarMapper.INSTANCE.CarToCarDtos(carService.getAllCars());
       return ResponseEntity.status(HttpStatus.OK).body(carDtoList);
    }

    @GetMapping("/cars/id/{car_id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable Integer car_id) {
        CarDto carDto = CarMapper.INSTANCE.CarToCarDto(carService.getCarById(car_id));
        return ResponseEntity.status(HttpStatus.OK).body(carDto);
    }

    @GetMapping("/cars/model/{model}")
    public ResponseEntity <List<CarDto>> getAllCarsByModel(@PathVariable String model) {
       List <CarDto> carsDtoList = CarMapper.INSTANCE.CarToCarDtos(carService.getCarByModel(model));
       return ResponseEntity.status(HttpStatus.OK).body(carsDtoList);
    }

    @GetMapping("/cars/brand/{brand}")
    public ResponseEntity <List<CarDto>> getAllCarsByBrand(@PathVariable String brand) {
        List <CarDto> carDtoList = CarMapper.INSTANCE.CarToCarDtos(carService.getCarByBrand(brand));
        return ResponseEntity.status(HttpStatus.OK).body(carDtoList);
    }

    @GetMapping("/cars/type/{type}")
    public  ResponseEntity <List<CarDto>> getAllCarsByType(@PathVariable String type) {
        List<CarDto> carDtoList = CarMapper.INSTANCE.CarToCarDtos(carService.getCarByType(type));
        return ResponseEntity.status(HttpStatus.OK).body(carDtoList);
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable("id") Integer id, @RequestBody Car car) {
       CarDto carDto = CarMapper.INSTANCE.CarToCarDto(carService.updateCar(id, car));
       return ResponseEntity.status(HttpStatus.OK).body(carDto);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<String> deleteCarById(@PathVariable Integer id) {
        carService.deleteCarById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Car with id : " + id + "deleted");
    }

    @DeleteMapping("/cars")
    public ResponseEntity<String> deleteAllCities() {
        carService.deleteAllCars();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("All cars deleted!");

    }

}
