package com.example.myspringapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmartphoneDto {

    private String brand;
    private String os;
    private String model;
}
