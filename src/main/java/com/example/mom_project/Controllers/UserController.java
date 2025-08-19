package com.example.mom_project.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mom_project.DTOs.UserDTO;
import com.example.mom_project.Models.ValueObjects.PositiveNumber;
import com.example.mom_project.Services.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsersDTO() {
        List<UserDTO> users = userService.getAllUsersDTO();
        
        if (users == null || users.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable PositiveNumber id) {
        return ResponseEntity.ok(userService.getUserById(id.getValue()));
    }

}
