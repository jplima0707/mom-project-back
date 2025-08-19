package com.example.mom_project.Models.ValueObjects;

public class PositiveNumber {

    private final Long value;

    public PositiveNumber(Long value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
