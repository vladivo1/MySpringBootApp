package com.example.myspringapp.repository;

import com.example.myspringapp.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository <Car, Integer> {

    public List<Car> getAllByModel(String model);

    public List<Car> getAllByBrand(String brand);

    public List<Car> getAllByType(String type);

}
