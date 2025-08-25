package com.example.mom_project.Models.ValueObjects;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

<<<<<<< Updated upstream
=======
import com.example.mom_project.Models.Exceptions.ValueObjectException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
>>>>>>> Stashed changes
import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Password {

    @Column(name = "password", nullable = false)
    private String password;

    protected Password(){}

<<<<<<< Updated upstream
    public Password(String password) {
=======
    @JsonCreator
    public Password(@JsonProperty("password") String password) {
>>>>>>> Stashed changes
        validatePassword(password);
        this.password = encrypt(password);
    }

    @JsonValue
    public String getPassword() {
        return password;
    }

    private void validatePassword(String password) {
        if (password == null || password.trim().isEmpty()) {
<<<<<<< Updated upstream
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
=======
            throw new ValueObjectException("Password cannot be null or empty");
        }
        if (password.length() < 8) {
            throw new ValueObjectException("Password must be at least 8 characters long");
>>>>>>> Stashed changes
        }
    }

    private String encrypt(String rawPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(rawPassword);
    }

    public boolean matches(String rawPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(rawPassword, this.password);
    }
}
