package com.example.mom_project.Models.ValueObjects;

<<<<<<< Updated upstream
=======
import com.example.mom_project.Models.Exceptions.ValueObjectException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
>>>>>>> Stashed changes
import com.fasterxml.jackson.annotation.JsonValue;

public class PositiveNumber {

    private Long value;

    protected PositiveNumber(){}

<<<<<<< Updated upstream
    public PositiveNumber(Long value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
=======
    @JsonCreator
    public PositiveNumber(@JsonProperty("positiveNumber") Long value) {
        if (value < 0) {
            throw new ValueObjectException("Value cannot be negative");
>>>>>>> Stashed changes
        }
        this.value = value;
    }

    @JsonValue
    public Long getValue() {
        return value;
    }
}
