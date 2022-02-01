package com.example.myspringapp.controller;

import com.example.myspringapp.domain.Smartphone;
import com.example.myspringapp.service.SmartphoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class SmartphoneController {

    private final SmartphoneService smartphoneService;

    public SmartphoneController(SmartphoneService smartphoneService) {
        this.smartphoneService = smartphoneService;
    }

    @PostMapping("/smartphones")
    @ResponseStatus(HttpStatus.CREATED)
    public Smartphone saveSmartphone(@RequestBody Smartphone smartphone) {
        return smartphoneService.saveSmartphone(smartphone);
    }

    @GetMapping("/smartphones")
    @ResponseStatus(HttpStatus.OK)
    public List<Smartphone> getAllSmartphone() {
        return smartphoneService.getAllSmartphone();
    }

    @GetMapping("/smartphones/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Smartphone getSmartphoneById(@PathVariable Integer id) {
        return smartphoneService.getSmartphoneById(id);
    }

    @GetMapping("/smartphones/brand/{brand}")
    @ResponseStatus(HttpStatus.OK)
    public List<Smartphone> getSmartphoneByBrand(@PathVariable String brand) {
        return smartphoneService.findAllByBrand(brand);
    }

    @GetMapping("/smartphones/os/{os}")
    @ResponseStatus(HttpStatus.OK)
    public List<Smartphone> getSmartphoneByOs(@PathVariable String os) {
        return smartphoneService.findAllByOs(os);
    }

    @GetMapping("/smartphones/model/{model}")
    @ResponseStatus(HttpStatus.OK)
    public List<Smartphone> getSmartphoneByModel(@PathVariable String model) {
        return smartphoneService.findAllByModel(model);
    }

    @PutMapping("/smartphones/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Smartphone updateSmartphone(@PathVariable("id") Integer id, @RequestBody Smartphone smartphone) {
        return smartphoneService.updateSmartphone(id, smartphone);
    }

    @DeleteMapping("/smartphones/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeSmartphoneById(@PathVariable Integer id) {
        smartphoneService.removeSmartphoneById(id);

    }

    @DeleteMapping("/smartphones")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllSmartphone() {
        smartphoneService.deleteAllSmartphone();
    }

}
