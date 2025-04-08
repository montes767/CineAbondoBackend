package com.cineabondo.Services;

import com.cineabondo.Models.User;
import com.cineabondo.Repositories.JwtUtil;
import com.cineabondo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired private UserRepository userRepo;
    @Autowired private JwtUtil jwtUtil;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String login(String username, String password) {
        User user = userRepo.findByUsername(username).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }
        return jwtUtil.generateToken(username);
    }

    public String register(User user) {
        if (userRepo.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Ya existe ese usuario");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return jwtUtil.generateToken(user.getUsername());
    }
}