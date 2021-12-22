package com.example.myspringapp.service;


import com.example.myspringapp.domain.Car;
import com.example.myspringapp.repository.CarRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;
    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public List<Car> getCarByModel(String model) {
        return carRepository.getAllByModel(model);
    }

    public List<Car> getCarByBrand(String brand) {
        return carRepository.getAllByBrand(brand);
    }

    public List<Car> getCarByType(String type) {
        return  carRepository.getAllByType(type);
    }


}
