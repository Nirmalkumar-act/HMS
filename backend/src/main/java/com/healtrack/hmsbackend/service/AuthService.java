package com.healtrack.hmsbackend.service;

import com.healtrack.hmsbackend.model.User;
import com.healtrack.hmsbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public String register(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "User already exists";
        }
        userRepository.save(user);
        return "Registration successful";
    }

    public Optional<User> login(User user) {
        Optional<User> dbUser = userRepository.findByEmail(user.getEmail());
        if (dbUser.isPresent() &&
            dbUser.get().getPassword().equals(user.getPassword())) {
            return dbUser;
        }
        return Optional.empty();
    }
}
