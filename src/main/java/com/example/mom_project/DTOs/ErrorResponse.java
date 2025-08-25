package com.example.mom_project.DTOs;

<<<<<<< Updated upstream
import java.util.List;

public class ErrorResponse {
    private int status;
    private String message;
    private List<String> errors;

    public ErrorResponse(int status, String message, List<String> errors){
        this.status = status;
        this.message = message;
        this.errors = errors;
=======
public class ErrorResponse {
    private int status;
    private String message;

    public ErrorResponse(int status, String message){
        this.status = status;
        this.message = message;
>>>>>>> Stashed changes
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

<<<<<<< Updated upstream
    public List<String> getErrors() {
        return errors;
    }

=======
>>>>>>> Stashed changes
    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
<<<<<<< Updated upstream

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
=======
>>>>>>> Stashed changes
}
