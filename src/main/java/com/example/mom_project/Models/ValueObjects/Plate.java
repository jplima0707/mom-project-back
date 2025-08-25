package com.example.mom_project.Models.ValueObjects;

<<<<<<< Updated upstream
=======
import com.example.mom_project.Models.Exceptions.ValueObjectException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
>>>>>>> Stashed changes
import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Plate {

    @Column(nullable=true, length=10, name = "plate")
    private String plate;

    protected Plate(){}

<<<<<<< Updated upstream
    public Plate(String plate) {
        if (plate.trim().length() < 7 || plate.trim().length() > 10) {
            throw new IllegalArgumentException("Plate number must be between 7 and 10 characters");
=======
    @JsonCreator
    public Plate(@JsonProperty("plate") String plate) {
        if (plate.trim().length() < 7 || plate.trim().length() > 10) {
            throw new ValueObjectException("Plate number must be between 7 and 10 characters");
>>>>>>> Stashed changes
        }
        this.plate = plate;
    }

    @JsonValue
    public String getPlate() {
        return plate;
    }

}
