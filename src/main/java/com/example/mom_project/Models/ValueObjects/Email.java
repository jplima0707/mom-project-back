package com.example.mom_project.Models.ValueObjects;

import jakarta.persistence.Embeddable;

@Embeddable
public class Email {
    
    private String email;

    protected Email(){}

    public Email(String email){
        if(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Email not valid");
        }
        this.email = email;
    }

    public String getEmail(){
        return email;
    }
}
