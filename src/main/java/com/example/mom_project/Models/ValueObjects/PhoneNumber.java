package com.example.mom_project.Models.ValueObjects;

import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PhoneNumber {
    
    @Column(nullable = false, length = 15, name = "phone")
    private String phoneNumber;

    protected PhoneNumber(){}

    public PhoneNumber(String phoneNumber) {
        if (phoneNumber.trim().length() < 10 || phoneNumber.trim().length() > 15) {
            throw new IllegalArgumentException("Phone number must be between 10 and 15 digits");
        }
        this.phoneNumber = phoneNumber;
    }

    @JsonValue
    public String getPhoneNumber() {
        return phoneNumber;
    }

}
