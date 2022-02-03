package com.example.myspringapp.controller;

import com.example.myspringapp.domain.City;
import com.example.myspringapp.dto.CityDto;
import com.example.myspringapp.mapper.CityMapper;
import com.example.myspringapp.service.CityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "City Controller", description = "The City API")
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {


    private final CityService cityService;
    public CityController(CityService service) {
        this.cityService = service;
    }

    @PostMapping("/cities")
    public ResponseEntity<CityDto> saveCity(@RequestBody CityDto cityDto) {
        City city = CityMapper.INSTANCE.cityDtoToCity(cityDto);
        cityService.saveCity(city);
        return ResponseEntity.status(HttpStatus.CREATED).body(cityDto);
    }

    @GetMapping("/cities")
    public ResponseEntity <List<CityDto>> getAllCity() {
        List <CityDto> cityDto = CityMapper.INSTANCE.cityToDtos(cityService.getAllCity());
        return ResponseEntity.status(HttpStatus.OK).body(cityDto);
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<CityDto> getCityById(@PathVariable Integer id) {
        CityDto cityDto = CityMapper.INSTANCE.cityToDto(cityService.getCityById(id));
        return  ResponseEntity.status(HttpStatus.OK).body(cityDto);

    }

    @GetMapping("/cities/name/{city}")
    public ResponseEntity <List<CityDto>> getCityByName(@PathVariable String city) {
       List <CityDto> cityDtoList = CityMapper.INSTANCE.cityToDtos(cityService.getCityByName(city));
       return ResponseEntity.status(HttpStatus.OK).body(cityDtoList);
    }

    @GetMapping("/cities/country/{country}")
    public ResponseEntity <List<CityDto>> getCityByCountry(@PathVariable String country) {
        List <CityDto> cityDtoList = CityMapper.INSTANCE.cityToDtos(cityService.getCityByCountry(country));
        return ResponseEntity.status(HttpStatus.OK).body(cityDtoList);
    }

    @GetMapping("/cities/region/{region}")
    public ResponseEntity <List<CityDto>> getCityByRegion(@PathVariable String region) {
        List <CityDto> cityDtoList = CityMapper.INSTANCE.cityToDtos(cityService.getCityByRegion(region));
        return ResponseEntity.status(HttpStatus.OK).body(cityDtoList);
    }

    @PutMapping("/cities/{id}")
    public ResponseEntity <CityDto> updateCity(@PathVariable("id") Integer id, @RequestBody City city) {
       CityDto cityDto = CityMapper.INSTANCE.cityToDto(cityService.updateCity(id,city));
       return ResponseEntity.status(HttpStatus.OK).body(cityDto);
    }

    @DeleteMapping("/cities/{id}")
    public ResponseEntity<String> removeCityById(@PathVariable Integer id) {
        cityService.removeCityById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("City with id : " + id + " deleted");
    }

    @DeleteMapping("/cities")
    public ResponseEntity<String> deleteAllCities() {
        cityService.deleteAllCities();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("All cities deleted!");
    }


}
