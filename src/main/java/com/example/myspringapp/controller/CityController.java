package com.example.myspringapp.controller;

import com.example.myspringapp.domain.City;
import com.example.myspringapp.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {


    private final CityService cityService;

    public CityController(CityService service) {
        this.cityService = service;
    }

    @PostMapping("/cities")
    @ResponseStatus(HttpStatus.CREATED)
    public City saveCity(@RequestBody City city) {
        return cityService.saveCity(city);
    }

    @GetMapping("/cities")
    @ResponseStatus(HttpStatus.OK)
    public List<City> getAllCity() {
        return cityService.getAllCity();
    }

    @GetMapping("/city/{id}")
    @ResponseStatus(HttpStatus.OK)
    public City getCityById(@PathVariable Integer id) {
        return cityService.getCityById(id);

    }

    @GetMapping("/cities/name/{city}")
    @ResponseStatus(HttpStatus.OK)
    public List<City> getCityByName(@PathVariable String city) {
        return cityService.getCityByName(city);
    }

    @GetMapping("/cities/country/{country}")
    @ResponseStatus(HttpStatus.OK)
    public List<City> getCityByCountry(@PathVariable String country) {
        return cityService.getCityByCountry(country);
    }

    @GetMapping("/cities/region/{region}")
    @ResponseStatus(HttpStatus.OK)
    public List<City> getCityByRegion(@PathVariable String region) {
        return cityService.getCityByRegion(region);
    }

    @PutMapping("/cities/{id}")
    @ResponseStatus(HttpStatus.OK)
    public City updateCity(@PathVariable("id") Integer id, @RequestBody City city) {
        return cityService.updateCity(id, city);
    }

    @DeleteMapping("/cities/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCityById(@PathVariable Integer id) {
        cityService.removeCityById(id);

    }

    @DeleteMapping("/cities")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllCities() {
        cityService.deleteAllCities();
    }


}
