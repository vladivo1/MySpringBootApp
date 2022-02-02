package com.example.myspringapp.controller;

import com.example.myspringapp.domain.Smartphone;
import com.example.myspringapp.dto.SmartphoneDto;
import com.example.myspringapp.mapper.SmartphoneMapper;
import com.example.myspringapp.service.SmartphoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity <SmartphoneDto> saveSmartphone(@RequestBody SmartphoneDto smartphoneDto) {
        Smartphone smartphone = SmartphoneMapper
                .INSTANCE.smartphoneDtoToSmartphone(smartphoneDto);
        smartphoneService.saveSmartphone(smartphone);
        return ResponseEntity.status(HttpStatus.CREATED).body(smartphoneDto);
    }

    @GetMapping("/smartphones")
    public ResponseEntity <List<SmartphoneDto>> getAllSmartphone() {
        List <SmartphoneDto> smartphoneDtoList = SmartphoneMapper
                .INSTANCE.smartphoneToDtos(smartphoneService.getAllSmartphone());
        return ResponseEntity.status(HttpStatus.OK).body(smartphoneDtoList);
    }

    @GetMapping("/smartphones/{id}")
    public ResponseEntity <SmartphoneDto> getSmartphoneById(@PathVariable Integer id) {
        SmartphoneDto smartphoneDto = SmartphoneMapper
                .INSTANCE.smartphoneToDto(smartphoneService.getSmartphoneById(id));
        return ResponseEntity.status(HttpStatus.OK).body(smartphoneDto);
    }

    @GetMapping("/smartphones/brand/{brand}")
    public  ResponseEntity <List<SmartphoneDto>> getSmartphoneByBrand(@PathVariable String brand) {
        List <SmartphoneDto> smartphoneDtoList = SmartphoneMapper
                .INSTANCE.smartphoneToDtos(smartphoneService.findAllByBrand(brand));
        return ResponseEntity.status(HttpStatus.OK).body(smartphoneDtoList);
    }

    @GetMapping("/smartphones/os/{os}")
    public  ResponseEntity <List<SmartphoneDto>> getSmartphoneByOs(@PathVariable String os) {
        List <SmartphoneDto> smartphoneDtoList = SmartphoneMapper
                .INSTANCE.smartphoneToDtos(smartphoneService.findAllByOs(os));
        return ResponseEntity.status(HttpStatus.OK).body(smartphoneDtoList);
    }

    @GetMapping("/smartphones/model/{model}")
    public ResponseEntity <List<SmartphoneDto>> getSmartphoneByModel(@PathVariable String model) {
        List <SmartphoneDto> smartphoneDtoList = SmartphoneMapper
                .INSTANCE.smartphoneToDtos(smartphoneService.findAllByModel(model));
        return ResponseEntity.status(HttpStatus.OK).body(smartphoneDtoList);
    }

    @PutMapping("/smartphones/{id}")
    public  ResponseEntity <SmartphoneDto> updateSmartphone(@PathVariable("id") Integer id, @RequestBody Smartphone smartphone) {
       SmartphoneDto smartphoneDto = SmartphoneMapper
               .INSTANCE.smartphoneToDto(smartphoneService.updateSmartphone(id, smartphone));
        return ResponseEntity.status(HttpStatus.OK).body(smartphoneDto);
    }

    @DeleteMapping("/smartphones/{id}")
    public ResponseEntity<String> removeSmartphoneById(@PathVariable Integer id) {
        smartphoneService.removeSmartphoneById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Smartphone with id : " + " deleted!");

    }

    @DeleteMapping("/smartphones")
    public ResponseEntity <String> deleteAllSmartphone() {
        smartphoneService.deleteAllSmartphone();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("All smartphones deleted!");
    }

}
