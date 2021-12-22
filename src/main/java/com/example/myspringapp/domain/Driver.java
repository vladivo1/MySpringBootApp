package com.example.myspringapp.domain;

import javax.persistence.*;

@Entity
@Table(name = "DRIVERS")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDriverExp() {
        return driverExp;
    }

    public void setDriverExp(String driverExp) {
        this.driverExp = driverExp;
    }
}
