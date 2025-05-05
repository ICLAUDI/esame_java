package com.example.demo.service;

import com.example.demo.Dto.UserDTO;
import java.util.Optional;

public interface UserService {
    UserDTO registerNewUserAccount(UserDTO userDTO);
    Optional<UserDTO> findUserByEmail(String email);  // Cambiato Optional<User> a Optional<UserDTO>
}
