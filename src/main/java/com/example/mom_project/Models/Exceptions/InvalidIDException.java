package com.example.mom_project.Models.Exceptions;

public class InvalidIDException extends RuntimeException {
    public InvalidIDException(String message){
        super(message);
    }    
}
