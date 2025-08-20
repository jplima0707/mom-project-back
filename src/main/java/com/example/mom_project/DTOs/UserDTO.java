package com.example.mom_project.DTOs;

import com.example.mom_project.Models.ValueObjects.Email;

public class UserDTO {
    private Long id;
    private String name;
    private Email email;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

}
