package com.healtrack.hmsbackend.controller;

import com.healtrack.hmsbackend.model.User;
import com.healtrack.hmsbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // ✅ Signup
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        Optional<User> existing = userRepository.findByEmail(user.getEmail());
        if (existing.isPresent()) {
            return "User already exists!";
        }
        userRepository.save(user);
        return "✅ Registration successful!";
    }

    // ✅ Login
    @PostMapping("/login")
    public Object loginUser(@RequestBody User user) {
        Optional<User> existing = userRepository.findByEmail(user.getEmail());
        if (existing.isPresent() && existing.get().getPassword().equals(user.getPassword())) {
            return existing.get(); // return user info
        }
        return "❌ Invalid credentials";
    }
}
