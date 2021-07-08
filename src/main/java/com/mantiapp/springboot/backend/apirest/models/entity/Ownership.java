package com.mantiapp.springboot.backend.apirest.models.entity;

import com.sun.corba.se.spi.orb.Operation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="ownerships")
public class Ownership implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String operation;
    private String population;
    private String zone;

    @Column(name="kind_ownership")
    private String kindOwnership;
    private int bedrooms;

    private float price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getKindOwnership() {
        return kindOwnership;
    }

    public void setKindOwnership(String kindOwnership) {
        this.kindOwnership = kindOwnership;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private static final long serialVersionUID = 1L;

}
