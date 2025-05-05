package com.example.demo.service.impl;

import com.example.demo.Dto.UserDTO;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDTO registerNewUserAccount(UserDTO userDTO) {
        // Controlla se l'utente esiste già
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new RuntimeException("User with this email already exists");
        }

        // Crea un nuovo utente dal DTO
        User user = UserMapper.toEntity(userDTO);

        // Codifica la password
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        // Salva l'utente nel database
        User savedUser = userRepository.save(user);

        // Restituisci il DTO dell'utente salvato
        return UserMapper.toDTO(savedUser);
    }

    @Override
    public Optional<UserDTO> findUserByEmail(String email) {
        // Trova l'utente per email
        Optional<User> user = userRepository.findByEmail(email);
        // Mappa l'utente in UserDTO e restituisci l'Optional
        return user.map(UserMapper::toDTO); // Converte User in UserDTO
    }
}
