package com.example.mom_project.Models.ValueObjects;

public class Plate {

    private String plate;

    public Plate(String plate) {
        if (plate.trim().length() < 7 || plate.trim().length() > 10) {
            throw new IllegalArgumentException("Plate number must be between 7 and 10 characters");
        }
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }

}
