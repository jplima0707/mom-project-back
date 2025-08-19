package com.example.mom_project.Services;

import java.util.List;

import com.example.mom_project.DTOs.UserCreateDTO;
import com.example.mom_project.DTOs.UserDTO;
import com.example.mom_project.Models.User;

public interface IUserService {

    public List<UserDTO> getAllUsersDTO();
    public List<User> getAllUsers();
    public UserDTO getUserById(Long id);
    public UserDTO deleteUser(Long id);
    public List<User> createUser(UserCreateDTO userCreateDTO);
    public User updateUser(Long id, UserCreateDTO userCreateDTO);

}
