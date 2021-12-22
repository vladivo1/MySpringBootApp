package com.example.myspringapp.repository;


import com.example.myspringapp.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Integer> {

    public List<City> findAllByCity(String city);

    public List<City> findAllByCountry(String country);

    public List<City> findAllByRegion(String region);

}
