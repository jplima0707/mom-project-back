package com.example.mom_project.Models.ValueObjects;

import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Plate {

    @Column(nullable=true, length=10, name = "plate")
    private String plate;

    protected Plate(){}

    public Plate(String plate) {
        if (plate.trim().length() < 7 || plate.trim().length() > 10) {
            throw new IllegalArgumentException("Plate number must be between 7 and 10 characters");
        }
        this.plate = plate;
    }

    @JsonValue
    public String getPlate() {
        return plate;
    }

}
