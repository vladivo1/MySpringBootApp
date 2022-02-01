package com.example.myspringapp.service;

import com.example.myspringapp.domain.City;
import com.example.myspringapp.repository.CityRepository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;

    }


    public City saveCity(City city) {
        return cityRepository.save(city);
    }


    public List<City> getAllCity() {
        return cityRepository.findAll();
    }


    public City getCityById(Integer id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("City not found with id " + id));
        return city;
    }

    public City updateCity(Integer id, City city) {
        return cityRepository.findById(id)
                .map(entity -> {
                    entity.setCity(city.getCity());
                    entity.setRegion(city.getRegion());
                    entity.setCountry(city.getCountry());
                    ;
                    return cityRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("City not found with id = " + id));
    }

    public void removeCityById(Integer id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("City not found with id " + id));
        cityRepository.delete(city);

    }

    public void deleteAllCities() {
        cityRepository.deleteAll();
    }

    public List<City> getCityByName(String city) {
        return cityRepository.findAllByCity(city);
    }

    public List<City> getCityByCountry(String country) {
        return cityRepository.findAllByCountry(country);
    }

    public List<City> getCityByRegion(String region) {
        return cityRepository.findAllByRegion(region);
    }


}
