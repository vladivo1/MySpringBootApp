package com.example.myspringapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DRIVERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "driver_id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "DRIVER_NAME")
    private String firstName;
    @Column(name = "DRIVER_LAST_NAME")
    private String lastName;
    @Column(name = "DRIVER_CATEGORY")
    private String category;
    @Column(name = "DRIVER_EXPERIENCE")
    private String driverExp;


}
