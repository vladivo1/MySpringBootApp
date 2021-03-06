package com.example.myspringapp.repository;


import com.example.myspringapp.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Integer> {

    List<City> findAllByCity(String city);

    List<City> findAllByCountry(String country);

    List<City> findAllByRegion(String region);

}
