package com.example.myspringapp.service;

import com.example.myspringapp.domain.Smartphone;
import com.example.myspringapp.repository.SmartphoneRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SmartphoneService {

    private final SmartphoneRepository smartphoneRepository;

    public SmartphoneService(SmartphoneRepository smartphoneRepository) {
        this.smartphoneRepository = smartphoneRepository;
    }

    public Smartphone saveSmartphone(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    public List<Smartphone> getAllSmartphone() {
        return smartphoneRepository.findAll();
    }

    public Smartphone getSmartphoneById(Integer id) {
        return smartphoneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Smartphone not found with id " + id));
    }

    public Smartphone updateSmartphone(Integer id, Smartphone smartphone) {
        return smartphoneRepository.findById(id)
                .map(entity -> {
                    entity.setBrand(smartphone.getBrand());
                    entity.setModel(smartphone.getModel());
                    entity.setOs(smartphone.getOs());
                    return smartphoneRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Smartphone not found with id = " + id));
    }

    public void removeSmartphoneById(Integer id) {
        Smartphone smartphone = smartphoneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("City not found with id " + id));
        smartphoneRepository.delete(smartphone);

    }

    public void deleteAllSmartphone() {
        smartphoneRepository.deleteAll();
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
