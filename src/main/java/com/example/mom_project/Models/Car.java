package com.example.mom_project.Models;

import com.example.mom_project.Models.ValueObjects.Plate;
import com.example.mom_project.Models.ValueObjects.Year;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cars")
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @Column(nullable=false, name = "year")
    @Embedded
    private Year year;

    @Column(nullable=true, length=10, name = "plate")
    @Embedded
    private Plate plate;

    @Column(nullable=false, length=60)
    private String brand;

    @Column(nullable=false, length=50)
    private String state;

    @Column(nullable=true, length = 255)
    private String extra;

    protected Car() {
    }

    public Car(Year year, Plate plate, String brand, String state, String extra) {
        this.year = year;
        this.plate = plate;
        this.brand = brand;
        this.state = state;
        this.extra = extra;
    }

    public Long getId() {
        return id;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Plate getPlate() {
        return plate;
    }

    public void setPlate(Plate plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
