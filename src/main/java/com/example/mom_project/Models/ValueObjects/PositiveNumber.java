package com.example.mom_project.Models.ValueObjects;

import com.fasterxml.jackson.annotation.JsonValue;

public class PositiveNumber {

    private Long value;

    protected PositiveNumber(){}

    public PositiveNumber(Long value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }
        this.value = value;
    }

    @JsonValue
    public Long getValue() {
        return value;
    }
}
