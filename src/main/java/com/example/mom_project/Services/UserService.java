package com.example.mom_project.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mom_project.DTOs.UserCreateDTO;
import com.example.mom_project.DTOs.UserDTO;
import com.example.mom_project.Models.User;
import com.example.mom_project.Repositories.UserRepository;
import com.example.mom_project.Mappers.UserMapper;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsersDTO() {
       return userRepository.findAll().stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDTO getUserById(Long id) {
        return UserMapper.toDTO(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
    }

    @Override
    public UserDTO deleteUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);
            return UserMapper.toDTO(user);
        }
        return null;
    }

    @Override
    public List<User> createUser(UserCreateDTO userCreateDTO) {
        User user = UserMapper.toEntity(userCreateDTO);
        userRepository.save(user);
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, UserCreateDTO userCreateDTO) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            User updatedUser = UserMapper.toEntity(userCreateDTO);
            updatedUser.setId(existingUser.getId());
            userRepository.save(updatedUser);
            return updatedUser;
        }
        return null;
    }
    
}
