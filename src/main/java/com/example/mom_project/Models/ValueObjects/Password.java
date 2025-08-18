package com.example.mom_project.Models.ValueObjects;

import jakarta.persistence.Embeddable;

@Embeddable
public class Password {
    private String value;

    public Password(String value) {
        validatePassword(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void validatePassword(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        if (value.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
    }
}
