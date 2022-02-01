package com.example.myspringapp.repository;


import com.example.myspringapp.domain.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SmartphoneRepository extends JpaRepository<Smartphone,Integer> {

    List<Smartphone> findAllByModel(String model);

    List<Smartphone> findAllByOs(String os);

    List<Smartphone> findAllByBrand(String brand);
}
