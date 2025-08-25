package com.example.mom_project.Models.ValueObjects;

import com.example.mom_project.Models.Exceptions.EmailException;
import com.example.mom_project.Models.Exceptions.ValueObjectException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Email {
    
    @Column(nullable = false, unique = true, length = 100, name = "email")
    private String email;

    protected Email(){}

    @JsonCreator
    public Email(@JsonProperty("email") String email) {
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new ValueObjectException("Email not valid");
        }
        this.email = email;
    }

    @JsonValue
    public String getEmail(){
        return email;
    }
}
