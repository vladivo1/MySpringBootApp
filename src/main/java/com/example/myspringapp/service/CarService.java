package com.example.myspringapp.service;

import com.example.myspringapp.domain.Car;
import com.example.myspringapp.repository.CarRepository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Integer id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car not found with id " + id));
    }

    public Car updateCar(Integer id, Car car) {
        return carRepository.findById(id)
                .map(entity -> {
                    entity.setBrand(car.getBrand());
                    entity.setModel(car.getModel());
                    entity.setType(car.getType());
                    return carRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Car not found with id = " + id));
    }

    public void deleteCarById(Integer id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car not found with id " + id));
        carRepository.delete(car);
    }

    public void deleteAllCars() {
        carRepository.deleteAll();
    }

    public List<Car> getCarByModel(String model) {
        return carRepository.getAllByModel(model);
    }

    public List<Car> getCarByBrand(String brand) {
        return carRepository.getAllByBrand(brand);
    }

    public List<Car> getCarByType(String type) {
        return carRepository.getAllByType(type);
    }


}
