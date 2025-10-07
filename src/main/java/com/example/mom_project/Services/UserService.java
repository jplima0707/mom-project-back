package com.example.mom_project.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mom_project.DTOs.User.UserCreateDTO;
import com.example.mom_project.DTOs.User.UserDTO;
import com.example.mom_project.DTOs.User.UserUpdateDTO;
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
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
        return UserMapper.toDTO(user);
    }

    @Override
    public List<User> createUser(UserCreateDTO userCreateDTO) {
        User user = UserMapper.toEntity(userCreateDTO);
        userRepository.save(user);
        return userRepository.findAll();
    }

    @Override
    public UserDTO updateUser(Long id, UserUpdateDTO user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        List<Client> clients = ClientRepository.findAllById(user.getClientsIds());
        User updatedUser = UserMapper.toEntity(user);
        updatedUser.setId(existingUser.getId());
        updatedUser.setPassword(existingUser.getPassword());
        userRepository.save(updatedUser);
        return UserMapper.toDTO(updatedUser);
    }
    
}
