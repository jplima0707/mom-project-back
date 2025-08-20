package com.example.mom_project.Models.ValueObjects;

import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Email {
    
    @Column(nullable = false, unique = true, length = 100, name = "email")
    private String email;

    protected Email(){}

    public Email(String email){
        if(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Email not valid");
        }
        this.email = email;
    }

    @JsonValue
    public String getEmail(){
        return email;
    }
}
