package com.example.mom_project.Models.ValueObjects;

import com.example.mom_project.Models.Exceptions.ValueObjectException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PhoneNumber {
    
    @Column(nullable = false, length = 15, name = "phone")
    private String phoneNumber;

    protected PhoneNumber(){}

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)    
    public PhoneNumber(String phoneNumber) {
        if (phoneNumber.trim().length() < 10 || phoneNumber.trim().length() > 15) {
            throw new ValueObjectException("Phone number must be between 10 and 15 digits");
        }
        this.phoneNumber = phoneNumber;
    }

    @JsonValue
    public String getPhoneNumber() {
        return phoneNumber;
    }

}
