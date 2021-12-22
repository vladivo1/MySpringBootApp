package com.example.myspringapp.controller;

import com.example.myspringapp.domain.City;
import com.example.myspringapp.domain.Smartphone;
import com.example.myspringapp.repository.SmartphoneRepository;
import com.example.myspringapp.service.SmartphoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class SmartphoneController {

    private SmartphoneRepository smartphoneRepository;
    private SmartphoneService smartphoneService;
    public SmartphoneController(SmartphoneRepository smartphoneRepository, SmartphoneService smartphoneService) {
        this.smartphoneRepository = smartphoneRepository;
        this.smartphoneService = smartphoneService;
    }

    @PostMapping("/saveSmartphone")
    @ResponseStatus(HttpStatus.CREATED)
    public Smartphone saveSmartphone (@RequestBody Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    @GetMapping("/getAllSmartphone")
    @ResponseStatus(HttpStatus.OK)
    public List<Smartphone> getAllSmartphone () {
        return smartphoneRepository.findAll();
    }

    @GetMapping("/getSmartphoneById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Smartphone getSmartphoneById (@PathVariable Integer id) {
        Smartphone smartphone = smartphoneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Smartphone not found with id " + id));
        return smartphone;
    }

    @GetMapping("/getSmartphoneByBrand/{brand}")
    @ResponseStatus(HttpStatus.OK)
    public List<Smartphone> getSmartphoneByBrand( @PathVariable String brand) {
        return smartphoneService.findAllByBrand(brand);
    }

    @GetMapping("/getSmartphoneByOs/{os}")
    @ResponseStatus(HttpStatus.OK)
    public List<Smartphone> getSmartphoneByOs( @PathVariable String os) {
        return smartphoneService.findAllByOs(os);
    }

    @GetMapping("/getSmartphoneByModel/{model}")
    @ResponseStatus(HttpStatus.OK)
    public List<Smartphone> getSmartphoneByModel( @PathVariable String model) {
        return smartphoneService.findAllByModel(model);
    }

    @PutMapping("/updateSmartphoneById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Smartphone updateSmartphone (@PathVariable ("id") Integer id, @RequestBody Smartphone smartphone) {
        return smartphoneRepository.findById(id)
                .map(entity ->{
                    entity.setBrand(smartphone.getBrand());
                    entity.setModel(smartphone.getModel());
                    entity.setOs(smartphone.getOs());;
                    return smartphoneRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Smartphone not found with id = " + id));
    }

    @DeleteMapping("/deleteSmartphoneById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeSmartphoneById (@PathVariable Integer id) {
        Smartphone smartphone = smartphoneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("City not found with id " + id));
        smartphoneRepository.delete(smartphone);

    }
    @DeleteMapping("/deleteAllSmartphone")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllSmartphone() {
        smartphoneRepository.deleteAll();
    }



}
