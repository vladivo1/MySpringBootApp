package com.example.myspringapp.service;

import com.example.myspringapp.domain.Smartphone;
import com.example.myspringapp.repository.SmartphoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneService {

    private SmartphoneRepository smartphoneRepository;

    public SmartphoneService(SmartphoneRepository smartphoneRepository) {
        this.smartphoneRepository = smartphoneRepository;
    }

    public List<Smartphone> findAllByModel(String model) {
       return smartphoneRepository.findAllByModel(model);
    }

    public List<Smartphone> findAllByOs(String os) {
        return smartphoneRepository.findAllByOs(os);
    }

    public List<Smartphone> findAllByBrand(String brand) {
       return smartphoneRepository.findAllByBrand(brand);
    }



}
