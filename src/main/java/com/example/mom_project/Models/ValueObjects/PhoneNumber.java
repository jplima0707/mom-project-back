package com.example.mom_project.Models.ValueObjects;

import jakarta.persistence.Embeddable;

@Embeddable
public class PhoneNumber {
    
    private String phoneNumber;

    public PhoneNumber(String phoneNumber) {
        if (phoneNumber.trim().length() < 10 || phoneNumber.trim().length() > 15) {
            throw new IllegalArgumentException("Phone number must be between 10 and 15 digits");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
