package com.example.mom_project.Mappers;

import com.example.mom_project.DTOs.UserCreateDTO;
import com.example.mom_project.DTOs.UserDTO;
import com.example.mom_project.Models.User;

public class UserMapper {
    
    public static UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    public static User toEntity(UserCreateDTO UserCreateDTO) {
        if (UserCreateDTO == null) {
            return null;
        }

        User user = new User();
        user.setName(UserCreateDTO.getName());
        user.setEmail(UserCreateDTO.getEmail());
        user.setPassword(UserCreateDTO.getPassword());
        return user;
    }

}
