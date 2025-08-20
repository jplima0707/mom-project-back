package com.example.mom_project.Models.ValueObjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonValue;

@Embeddable
public class Year {
    
    @Column(nullable=false, name = "year")
    private int year;

    protected Year(){}

    public Year(int year) {
        verifyYear(year);
        this.year = year;
    }

    @JsonValue
    public int getYear() {
        return year;
    }

    private void verifyYear(int year) throws IllegalArgumentException {
        if (year < 1800 || year > Calendar.getInstance().get(Calendar.YEAR)+1) {
            throw new IllegalArgumentException("Invalid year. Year must be between 1800 and " + (Calendar.getInstance().get(Calendar.YEAR)+1) + ".");
        }
    }
}
