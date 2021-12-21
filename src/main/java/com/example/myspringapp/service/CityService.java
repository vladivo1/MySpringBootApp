package com.example.myspringapp.service;

import com.example.myspringapp.object.City;
import com.example.myspringapp.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository repository;
    public CityService(CityRepository cityRepository){
        this.repository = cityRepository;

    }

    public List<City> getCityByName(String city) {
        return repository.findAllByCity(city);
    }

    public List<City> getCityByCountry(String country) {
        return repository.findAllByCountry(country);
    }

    public List<City> getCityByRegion(String region) {
        return repository.findAllByRegion(region);
    }


}
