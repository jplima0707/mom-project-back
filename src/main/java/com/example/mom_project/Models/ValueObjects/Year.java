package com.example.mom_project.Models.ValueObjects;

import jakarta.persistence.Embeddable;
import java.util.Calendar;

@Embeddable
public class Year {
    
    private int year;

    public Year(int year) {
        verifyYear(year);
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    private void verifyYear(int year) throws IllegalArgumentException {
        if (year < 1800 || year > Calendar.getInstance().get(Calendar.YEAR)+1) {
            throw new IllegalArgumentException("Invalid year. Year must be between 1800 and " + (Calendar.getInstance().get(Calendar.YEAR)+1) + ".");
        }
    }
}
