package com.example.myspringapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "SMARTPHONES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Smartphone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "smartphone_id")
    private Integer id;
    @Column(name = "SMARTPHONE_BRAND")
    private String brand;
    @Column(name = "SMARTPHONE_OS")
    private String os;
    @Column(name = "SMARTPHONE_MODEL")
    private String model;

}
