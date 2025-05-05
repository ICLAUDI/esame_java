package com.example.demo.Mapper;

import com.example.demo.Dto.UserDTO;
import com.example.demo.model.User;

public class UserMapper {

    // Metodo per convertire User in UserDTO
    public static UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getRole()
        );
    }

    // Metodo per convertire UserDTO in User
    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return user;
    }
}
