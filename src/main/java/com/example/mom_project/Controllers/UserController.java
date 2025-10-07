package com.example.mom_project.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.mom_project.DTOs.User.UserCreateDTO;
import com.example.mom_project.DTOs.User.UserDTO;
import com.example.mom_project.DTOs.User.UserUpdateDTO;
import com.example.mom_project.Models.User;
import com.example.mom_project.Models.Exceptions.InvalidIDException;
import com.example.mom_project.Services.IUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "Endpoints for managing users")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get all users", description = "Retrieve a list of all users")
    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsersDTO();
        
        if (users == null || users.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(users);
    }

    @Operation(summary = "Get user by ID", description = "Retrieve a user by their ID")
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        if (id < 0){
            throw new InvalidIDException("Id must be grather than or equal to 0");
        }
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Operation(summary = "Create a new user", description = "Create a new user with the provided details")
    @PostMapping("/")
    public ResponseEntity<List<User>> createUser(@RequestBody UserCreateDTO user) {
        List<User> users = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }

    @Operation(summary = "Delete a user", description = "Delete a user by their ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id) {
        if (id < 0){
            throw new InvalidIDException("Id must be grather than or equal to 0");
        }
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @Operation(summary = "Update a user", description = "Update an existing user's details by their ID")
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO user) {
        if (id < 0){
            throw new InvalidIDException("Id must be grather than or equal to 0");
        }
        UserDTO updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

}
