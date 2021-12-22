package com.example.myspringapp.domain;

import javax.persistence.*;

@Entity
@Table(name = "SMARTPHONES")
public class Smartphone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "smartphone_id")
    private Integer id;
    @Column(name = "SMARTPHONE_BRAND")
    private String brand;
    @Column(name = "SMARTPHONE_OS")
    private String os;
    @Column(name = "SMARTPHONE_MODEL")
    private String model;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
