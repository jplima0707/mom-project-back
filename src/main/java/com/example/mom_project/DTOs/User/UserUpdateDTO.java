package com.example.mom_project.DTOs.User;

import java.util.List;

import com.example.mom_project.Models.ValueObjects.Email;

public class UserUpdateDTO {
    private Email email;
    private String name;
    private List<Long> clientsIds;

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getClientsIds() {
        return clientsIds;
    }

    public void setClientsIds(List<Long> clientsIds) {
        this.clientsIds = clientsIds;
    }
}
