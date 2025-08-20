package com.example.mom_project.DTOs;

import com.example.mom_project.Models.ValueObjects.Email;
import com.example.mom_project.Models.ValueObjects.Password;


public class UserCreateDTO {
    private String name;
    private Email email;
    private Password password;

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

}
