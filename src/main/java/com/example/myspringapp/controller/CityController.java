package com.example.myspringapp.controller;

import com.example.myspringapp.domain.City;
import com.example.myspringapp.repository.CityRepository;
import com.example.myspringapp.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {

    private final CityRepository cityRepository;
    private final CityService service;
     public CityController(CityRepository cityRepository, CityService service) {
         this.cityRepository = cityRepository;
         this.service = service;
     }

     @PostMapping("/saveCity")
    @ResponseStatus(HttpStatus.CREATED)
    public City saveCity (@RequestBody City city) {
         return cityRepository.save(city);
     }

     @GetMapping("/getAllCity")
    @ResponseStatus(HttpStatus.OK)
    public List<City> getAllCity () {
         return cityRepository.findAll();
     }

     @GetMapping("/getCityById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public City getCityById (@PathVariable Integer id) {
         City city = cityRepository.findById(id)
                 .orElseThrow(() -> new EntityNotFoundException("City not found with id " + id));
         return city;
     }

    @GetMapping("/getCityByName/{city}")
    @ResponseStatus(HttpStatus.OK)
    public List<City> getCityByName( @PathVariable String city) {
         return service.getCityByName(city);
    }
    @GetMapping("/getCityByCountry/{country}")
    @ResponseStatus(HttpStatus.OK)
    public List<City> getCityByCountry( @PathVariable String country) {
        return service.getCityByCountry(country);
    }
    @GetMapping("/getCityByRegion/{region}")
    @ResponseStatus(HttpStatus.OK)
    public List<City> getCityByRegion( @PathVariable String region) {
        return service.getCityByRegion(region);
    }

    @PutMapping("/updateCityById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public City updateCity (@PathVariable ("id") Integer id, @RequestBody City city) {
         return cityRepository.findById(id)
                 .map(entity ->{
                     entity.setCity(city.getCity());
                     entity.setRegion(city.getRegion());
                     entity.setCountry(city.getCountry());;
                     return cityRepository.save(entity);
                 })
                 .orElseThrow(() -> new EntityNotFoundException("City not found with id = " + id));
    }

     @DeleteMapping("/deleteCityById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCityById (@PathVariable Integer id) {
         City city = cityRepository.findById(id)
                 .orElseThrow(() -> new EntityNotFoundException("City not found with id " + id));
         cityRepository.delete(city);

     }
     @DeleteMapping("/deleteAll")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllCities() {
         cityRepository.deleteAll();
    }



}
