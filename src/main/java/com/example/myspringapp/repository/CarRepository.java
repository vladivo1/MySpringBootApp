package com.example.myspringapp.repository;

import com.example.myspringapp.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository <Car, Integer> {

    List<Car> getAllByModel(String model);

    List<Car> getAllByBrand(String brand);

    List<Car> getAllByType(String type);

}
